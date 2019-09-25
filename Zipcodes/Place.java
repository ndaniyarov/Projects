/* Name: Nigina Daniyarova
 * File: Place.java
 * Desc:
 *      Class, constructor, getters, setters and CompareTo method for
 *      a PopulatedPlace with the given zip, town and state
 * 
 */

public class Place implements Comparable<Place>{
    private String zip;
    private String town;
    private String state;

    /** Constructs a Place with the given zip, town, and state
     * @param zip The 5-digit zip code
     * @param town The town name
     * @param state The state abbreviation
     */
    public Place(String zip, String town, String state){
	this.zip = zip;
	this.town = town;
	this.state = state;
    }
    public String getZip(){
	return zip;
    }
    public void setZip(String z) {
	zip = z;
    }
    public String getTown(){
	return town;
    }
    public void setTown(String t) {
	town = t;
    }
    public String getState(){
	return state;
    }
    public void setState(String s) {
	state = s;
    }

    /** compares two Place objects
     * @param p The Place that is being compared with
     * @return 0 if equals, 1 if bigger and -1 if smaller
     */
    public int compareTo(Place p){
  	return this.getZip().compareTo(p.getZip());
    }
    @Override
    public String toString(){
	return town + ", " + state;
    }

}
