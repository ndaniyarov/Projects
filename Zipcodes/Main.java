/* Name: Nigina Daniyarova
 * File: Main.java
 * Desc:
 *
 * The main driver program for Assignment 5.
 *
 * This program asks the user to input a zipcode. It returns either a Place with
 * zipcode, town and state, LocatedPlace which is a place but with latitude
 * and longitute or a PopulatedPlace which is a Located Place with a
 * population
 *
 */

import java.util.*;
import java.io.*;

public class Main{
public static final String EXIT = "00000";
    public static void main(String[] args)
	throws FileNotFoundException{
	try{
	    String zipcodes = "uszipcodes.csv";
	    String ziplocs = "ziplocs.csv";
	    ArrayList<Place> place = LookUpZip.readZipCodes(zipcodes, ziplocs);
	    Scanner input = new Scanner(System.in);
	    while (true){
		System.out.print("zipcode: ");
		String zip = input.nextLine();
		if (zip.equals(EXIT)){
		    System.out.println("Good Bye!");
		    break;
		}
		else if (LookUpZip.lookupZip(place, zip) != null)
		    System.out.println(LookUpZip.lookupZip(place, zip).toString());
		else System.out.println("No such zipcode");
		System.out.println();
	    }
	    input.close();
	}
	catch (FileNotFoundException e){
	    System.out.println("Error in opening the file");
	    System.exit(1);
	}
    }
}
