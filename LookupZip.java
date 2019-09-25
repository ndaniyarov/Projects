/** Searches for a place with a given ziplocs
 */
import java.util.*;
import java.io.*;

class LookupZip{
    //Splits the line
    //returns either place or populated place
    public static Place parseLine(String line){
	String[] fields = line.split(",",-1);
	String zip = fields[0];
	String town = fields[1];
	String state = fields[2];
	if (!fields[3].equals("")) {
	    int population = Integer.parseInt(fields[3]);
	    PopulatedPlace p = new PopulatedPlace(zip, town, state,
						  null,null, population);
	    return p;
	}
	else{
	    Place p = new Place(zip, town, state);
	    return p;
	}
    }
    public static LocatedPlace parseLine2(String line){
	String[] fields = line.split(",", -1);
	String zip = fields[0];
	String latitude = fields[5];
	String longitude = fields[6];
	LocatedPlace p = new LocatedPlace(zip, null, null, null, null);
	p.setLatitude(latitude);
	p.setLongitude(longitude);
      	zip = zip.replaceAll("\"", "");
	return p;
    }
    
    // creates an arraylist of places with the parseLine2
    public static ArrayList<Place> readZipCodes(String uszipcodes, String ziplocs)
	throws FileNotFoundException{
	String line;
	String line2;
	ArrayList<Place> place = new ArrayList<>();
	try{
	    Scanner input = new Scanner(new File(uszipcodes));
	    line = input.nextLine();
	    int i =0;
	    while (input.hasNextLine()){
		line = input.nextLine();
		place.add(i, parseLine(line));
		i++;
	    }
	    
	    Scanner input2 = new Scanner(new File(ziplocs));
	    //line2 = input2.nextLine();
	    //line2 = input2.nextLine();
	    // System.out.println(place.size());
	    // break;
	    //int b = 0;
	    //
	    while (input2.hasNextLine()){
		line2 = input2.nextLine();
		LocatedPlace lp = parseLine2(line2);
		String lat = lp.getLatitude();
		//System.out.println(lat);
		String lon = lp.getLongitude();
		//if (input2.hasNextLine())
		String newzip = lp.getZip();
		// System.out.println(b);
		newzip = newzip.replaceAll("\"", "");
		   
		for(int b = 0; b < place.size(); b++){
		    //    System.out.print(b+ ": "+newzip + ", ");
		    // System.out.print(place.get(b).getZip()+", ");
		    //System.out.println(place.get(b).getZip().compareTo(newzip) == 0);		    // System.out.println(newzip);
		    if (newzip.equals(place.get(b).getZip())
			&& !lat.equals(null)){
			if(place.get(b) instanceof PopulatedPlace){
			    PopulatedPlace p = (PopulatedPlace)place.get(b);
			    //    System.out.println(p + "NEW POPPLACE");
			    p.setLatitude(lat);
			    p.setLongitude(lon);
			    //System.out.println("( "+p + "THIS IS NEW )");
			}
			else if (place.get(b) instanceof LocatedPlace){
			    LocatedPlace p = (LocatedPlace)place.get(b);
			    p.setLatitude(lat);
			    p.setLongitude(lon);
			    //System.out.println("( "+p + "THIS IS NEW )");
			}
			//	else 
			//  System.out.println("It's not an instance of anything");
		    }
		    // System.out.println("zips are not equal and lat is 0");
		}
	    }
	
	     //	    System.out.println("No mathces found");
	
	    
	    input.close();
	    input2.close();
	}
	catch (FileNotFoundException e){
	    System.out.println("Error in opening the file");
	    System.exit(1);
	}
	return place;
    }
    public static Place lookupZip(ArrayList<Place> place, String zip){
	for (int i = 0; i < place.size(); i++){
	    if (place.get(i).getZip().compareTo(zip) == 0)
		return place.get(i);
	}
	return null;
    }
}
