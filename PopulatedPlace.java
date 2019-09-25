/** Creates a LocatedPlace with the given zip, town name, state,
    latitude and a longitude
    * @param zip The 5-digit zip code
    * @param town The town name
    * @param state The state abbreviation
    * @param latitude the latitude of the place
    * @param longitude the longitude of the place
    * @param population the population of the place
    */


public class PopulatedPlace extends LocatedPlace{
    /* private String zip;
    private String town;
    private String state;
    private String latitude;
    private String longitude;
    */
    private int population;

    public PopulatedPlace(String zip, String town, String state,
			  String latitude, String longitude, int population){
	super(zip, town, state, latitude, longitude);
	this.population = population;
	//	this.latitude = latitude;
	//	this.longitude = longitude;
    }
    /*

    public String getZip(){
	return zip;
    }
    public void setZip() {
	this.zip = zip;
    }

    public String getTown(){
	return town;
    }
    public void setTown() {
	this.town = town;
    }

    public String getState(){
	return state;
    }
    public void setState() {
	this.state = state;
    }
    public String getLatitude(){
	return latitude;
    }
    public void setLatitude() {
	this.latitude = latitude;
    }
    public String getLongitude(){
	return longitude;
    }
    public void setLongitude() {
	this.longitude = longitude;
    }
    */
    public int getPopulation(){
	return population;
    }
    public void setPopulation(int pop) {
	population = pop;
    }
    public String toString(){
	return super.toString()+" " + population;
    }
}
