import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)
    throws FileNotFoundException{
	try{
	    String zipcodes = "uszipcodes.csv";
	    String ziplocs = "ziplocs.csv";
	    String exit = "00000";
	      
	   ArrayList<Place> place = LookupZip.readZipCodes(zipcodes, ziplocs);
	   //LookupZip.readZipCodes(zipcodes, ziplocs);
			     
	    Scanner input = new Scanner(System.in);
	  
	    while (true){
		System.out.print("zipcode: ");	
		String zip = input.nextLine();
		if (zip.equals(exit)){
		    System.out.println("Good Bye!");
		    break;
		}
		else if (LookupZip.lookupZip(place, zip) != null)
		    System.out.println(LookupZip.lookupZip(place, zip).toString());
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
	
	
