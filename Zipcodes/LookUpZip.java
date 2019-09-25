/* Name: Nigina Daniyarova
 * File: LookUpZip.java
 * Desc:
 *      Program consists of functions parseLine, parseLine2, readZipCodes
 *      and lookupZip. It collects the data from the main, creates an
 *      ArrayList of Places, searches for a particular place and returns it
 *
 */

import java.util.*;
import java.io.*;

class LookUpZip{
    public static final int ZIP=0, TOWN=1, STATE=2, POPULATION=3;
    /** Splits the line of a first file with Places and populations
     * and creates either a Place or a PopulatedPlace
     * @param line the line that is being splitted
     * @return either a Place or a PopulatedPlace
     */
    public static Place parseLine(String line){
	String[] fields = line.split(",",-1);
	String zip = fields[ZIP];
	String town = fields[TOWN];
	String state = fields[STATE];
	if (!fields[POPULATION].equals("")) {
	    int population = Integer.parseInt(fields[POPULATION]);
	    PopulatedPlace p = new PopulatedPlace(zip, town, state,
						  0,0, population);
	    return p;
	}
	else{
	    Place p = new Place(zip, town, state);
	    return p;
	}
    }

    public static final int NEWZIP=0, LATITUDE=5, LONGITUDE=6;
    /** Creates an ArrayList of Places by reading two files
     * @param uszipcodes first File
     * @param ziplocs second File
     * @return ArrayList of Places, PopulatedPlaces and LocatedPlaces
     */
    public static ArrayList<Place> readZipCodes(String uszipcodes, String ziplocs)
	throws FileNotFoundException{
	String line;
	String line2;
	Place p2;
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
	    line2 = input2.nextLine();
	    while (input2.hasNextLine()){
		line2 = input2.nextLine();
		String[] fields = line2.split(",", -1);
		String zip = fields[ZIP];
		if (!fields[LATITUDE].equals("") && !fields[LONGITUDE].equals("")){
		    double latitude = Double.parseDouble(fields[LATITUDE]);
		    double longitude = Double.parseDouble(fields[LONGITUDE]);
		    zip = zip.replaceAll("\"", "");
		    Place newPlace = lookupZip(place, zip);
		    if (newPlace != null){
			if(newPlace instanceof PopulatedPlace) {
			    PopulatedPlace p = (PopulatedPlace)newPlace;
			    p.setLatitude(latitude);
			    p.setLongitude(longitude);
			}
			else{
			    LocatedPlace p = new LocatedPlace(zip, newPlace.getTown(), newPlace.getState(), latitude, longitude);
			    p.setLatitude(latitude);
			    int index = place.indexOf(newPlace);
			    place.set(index, p);
			}
		    }
		}
	    }
	    input.close();
	    input2.close();
	}
	catch (FileNotFoundException e){
	    System.out.println("Error in opening the file");
	    System.exit(1);
	}
	return place;
    }

    /** Uses binary search to look for a place with a zipcode that user inputs
     * @param place ArrayList that was created in readZipCodes
     * @param zip The zipcode requested by user
     * @return Place that corresponds to the given zip
     */
    public static Place lookupZip(ArrayList<Place> place, String zip){
	int min = 0;
	int max = place.size()-1;
	int mid = place.size()/2;
	Place newest = new Place(zip, null, null);
	while(place.get(mid).compareTo(newest) != 0){
	    if ((mid == min && mid == max) || mid == max ){
		return null;
	    }
	    if (place.get(mid).compareTo(newest) > 0){
		max = mid-1;
		mid = (max + min)/2;
	    }
	    else {
		min = mid+1;
		mid = (max + min)/2;
	    }
	}
	return place.get(mid);
    }
}
