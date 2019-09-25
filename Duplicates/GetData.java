/* Name: Nigina Daniyarova
 * File: GetData.java
 * Desc: Program consists of a GetData constructor that creates an ArrayList of   
 *   Human objects from the given file, following getters: getOldSize,
 *   getDoupCount, size and following deduplication methods: 
 *   allPairsDeduplication, hashLinearDeduplication, hashDoubleDeduplication
 *   quicksortDeduplication and builtinSortDeduplication    
 */

import java.util.*;
import java.io.*;

public class GetData{
    private int count = 0;
    private int size = 0;
    private int oldSize = 0;
    ArrayList<Human> dataSet = new ArrayList<>();
    private static final int SEX = 80, RACE = 81, DOB = 82, AGE = 83, FEET = 84,
	INCH = 85, WEIGHT = 86, HAIR_COLOR = 87, EYE_COLOR = 88;
    public static final int HASH_SIZE = 1000003;

    /** Constructs a GetData object that stores an ArrayList of human Object 
     *  from the given file
     * @param fileName The name of the file that is being proccessed
     */
    public GetData(String fileName) throws FileNotFoundException,
					   NumberFormatException {
	try {
	    Scanner input = new Scanner(new File(fileName));
	    String line = input.nextLine();
	    int number = 0;
	    while (input.hasNextLine()){
		line = input.nextLine();
		String[] fields = line.split(",", -1);
		if (fields.length != 112){
		    fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		    List<String> fieldsList = new ArrayList<String>();
		    boolean quotes = false;
		    StringBuilder builder = new StringBuilder();

		    /** for loop the takes words closed in quotation marks as a
		     * single element of a fields array */
		    for (char c = 0; c < line.toCharArray().length; c++){
			if (c == ','){
			    if (quotes) {builder.append(c);}
			    else {
				fieldsList.add(builder.toString());
				builder = new StringBuilder();
			    }
			    break;
			}
			if (c == '\"'){quotes = !quotes;}
			else {
			    builder.append(c);
			    break;
			}
		    }
		    fieldsList.add(builder.toString());
		    fieldsList.toArray(fields);
		}
		String sex = fields[SEX];
		String race = fields[RACE];
		int dob = Integer.parseInt(fields[DOB]);
		int age = Integer.parseInt(fields[AGE]);
		Double height = Double.parseDouble(fields[FEET]+"."+fields[INCH]);
		int weight = Integer.parseInt(fields[WEIGHT]);
		String hairColor = fields[HAIR_COLOR];
		String eyeColor = fields[EYE_COLOR];
		Human person = new Human(sex, race, dob, age, height, weight, hairColor, eyeColor);
		dataSet.add(person);
		oldSize = dataSet.size();
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("Error in opening the file");
	    System.exit(1);
	}
	catch (NumberFormatException e){
	    System.out.println("LOL WROOOOONG");
	    System.exit(1);
	}
    }
    public int getOldSize(){
	return oldSize;
    }
    public int getDupCount(){
	return count;
    }
    public int size(){
	return size;
    }

    /** Creates an ArrayList of deduplicated people by comparing every element of 
     *  a given ArrayList to the others
     * @return Deduplicated arrayList
     */
    public ArrayList<Human> allPairsDeduplication(){
	for(int i = 0; i < dataSet.size()-1; i++){
	    for (int j = i+1; j < dataSet.size(); j++){
	    	if (dataSet.get(i).compareTo(dataSet.get(j)) == 0){
		    count++;
	    	    dataSet.remove(j);
	    	}
	    }
	}
	size = dataSet.size();
	return dataSet;
    }

    /** Creates an ArrayList of deduplicated people by using a hashMap to store
     *  Human objects and compare them at the same time
     * @return Deduplicated arrayList
     */
    public ArrayList<Human> hashLinearDeduplication(){
	Human old;
	ArrayList<Human> deduplicated = new ArrayList<Human>();
	ProbeHashMap<String, Human> hash =
	    new ProbeHashMap<String, Human>(HASH_SIZE);
	for (int i = 0; i < dataSet.size(); i++){
	    old = hash.put(dataSet.get(i).toString(), dataSet.get(i));
	    if (old != null)
		count++;
	}
	Iterable<Human> values = hash.values();
	Iterator<Human> iter = values.iterator();
	
	/** Loop with an iterator to move elements from the hashMap back to the 
	 *  ArrayList */
	while(iter.hasNext()){
	    deduplicated.add(iter.next());
	}
	int max = hash.getMaxTemp();
	int total = hash.getCount();
	System.out.println("average number of probes: "+(float)total/dataSet.size());
	System.out.println("max number of probes: "+max);

	System.out.println("load_factor after insertions: " + (float)hash.size()/HASH_SIZE);
	size = deduplicated.size();
	return deduplicated;
    }

    /** Creates an ArrayList of deduplicated people by using a DoubleHashMap to 
     *  store Human objects and compare them at the same time
     * @return Deduplicated arrayList
     */
    public ArrayList<Human> hashDoubleDeduplication(){
	Human old;
	ArrayList<Human> deduplicated = new ArrayList<Human>();
	DoubleHashMap<String, Human> hash =
	    new DoubleHashMap<String, Human>(HASH_SIZE);
	for (int i = 0; i < dataSet.size(); i++){
	    old = hash.put(dataSet.get(i).toString(), dataSet.get(i));
	    if (old != null)
		count++;
	}
	Iterable<Human> values = hash.values();
	Iterator<Human> iter = values.iterator();

	/**Loop to move elements from the doubleHashMap back to the ArrayList */
	while(iter.hasNext()){
	    deduplicated.add(iter.next());
      	}
	int max = hash.getMaxTemp();
	int total = hash.getCount();
	System.out.println("average number of probes: "+(float)total/dataSet.size());
	System.out.println("max number of probes: "+max);
	System.out.println("load_factor after insertions: " + (float)hash.size()/HASH_SIZE);
	return deduplicated;
    }
    
    /** A Helper method that creates an ArrayList of deduplicated people by using a     *  quickSort to store Human objects 
     * @return Deduplicated arrayList
     */
       
    private ArrayList<Human> quickSort(ArrayList<Human> dataSet){
	int oldDataSet = dataSet.size();
	if (dataSet.size() >= 2){
	    Human pivot = dataSet.get((int)Math.random() * (dataSet.size() + 1));
	    ArrayList<Human> lower = new ArrayList<Human>();
	    ArrayList<Human> greater = new ArrayList<Human>();
	    ArrayList<Human> equals = new ArrayList<Human>();
	    while (!dataSet.isEmpty()){
		Human removed = dataSet.remove(0);
		if (removed.compareTo(pivot) < 0)
		    lower.add(removed);
		else if (removed.compareTo(pivot) == 0)
		    equals.add(removed);
		else
		    greater.add(removed);
	    }
	    quickSort(lower);
	    quickSort(greater);
	    dataSet.addAll(lower);
	    dataSet.add(equals.get(0));
	    dataSet.addAll(greater);

	}
	size = dataSet.size();
	count = oldDataSet - dataSet.size();
	return dataSet;
    }

    /** Creates an ArrayList of deduplicated people by using a helper method 
     *  quickSort to store Human objects
     * @return Deduplicated arrayList
     */
    public ArrayList<Human> quicksortDeduplication(){
	dataSet = quickSort(dataSet);
	return dataSet;
    }

    /** Helper method to use the built in java collection.sort method
     *  @return Deduplicated ArrayList
     */
    private ArrayList<Human> collectionSort(ArrayList<Human> dataSet){
	Collections.sort(dataSet);
	return dataSet;
    }

    /** Creates an ArrayList of deduplicated people by using a helper method 
     *  collectionSort to store Human objects and remove the dublicates
     * @return Deduplicated arrayList
     */
    public ArrayList<Human> builtinSortDeduplication(){
	ArrayList<Human> newData = new ArrayList<>();
	dataSet = collectionSort(dataSet);
	for (int k = 0; k < dataSet.size(); k++){
	    for (int i = k+1; i < dataSet.size()-1; i++){
		if (dataSet.get(k).compareTo(dataSet.get(i)) == 0){
		    count++;
		    dataSet.remove(i);
		    k--;
		}
	    }
	}
	size = newData.size();
	return dataSet;
    }
}
