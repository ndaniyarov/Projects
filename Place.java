/** Creates a Place with the given zip, town name, and
 * state
 * @param zip The 5-digit zip code
 * @param town The town name
 * @param state The state abbreviation
 */
public class Place{
    private String zip;
    private String town;
    private String state;

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
    public String toString(){
	return town + ", " + state;

    }
}
