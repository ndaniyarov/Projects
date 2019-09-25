/* Name: Nigina Daniyarova
 * File: Main.java
 * Desc:
 *       The main driver program for assignment 8.
 *       After getting csv file from the New York Police department using
 *       command line and proccessing it, this program eliminates all the
 *       duplicates of people who were already stopped by the police before.
 *       It prints the number of people stopped in total, their attributes
 *
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws FileNotFoundException{
	String fileName = args[0];
	try{
	    GetData dataSet = new GetData(fileName);
	    dataSet.hashDoubleDeduplication();
	    System.out.println("Record given:" + dataSet.getOldSize());
	    System.out.println("Attributes checked:sex, race, dob, age, ht_feet, ht_inch, weight, haircolor, eyecolor");
	    System.out.println("Duplicates found:" + dataSet.getDupCount());
	}
	catch (FileNotFoundException e){
	    System.out.println("Error in opening the file");
	    System.exit(1);
	}
    }
}
