/** Creates a LocatedPlace with the given zip, town name, state,
    latitude and a longitude
    * @param zip The 5-digit zip code
    * @param town The town name
    * @param state The state abbreviation
    * @param latitude the latitude of the place
    * @param longitude the longitude of the place
    */

public class LocatedPlace extends Place{
    private String latitude;
    private String longitude;
    public LocatedPlace(String zip, String town, String state,
			String latitiude, String longitude){
	super(zip, town, state);
	this.latitude = latitude;
	this.longitude = longitude;

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
    */
    public String getLatitude(){
	return latitude;

    }
    public void setLatitude(String lat) {
	latitude = lat;
    }
    public String getLongitude(){
	return longitude;
    }
    public void setLongitude(String lon) {
	longitude = lon;
    }
    public String toString(){
	return super.toString()+" " + latitude + " " + longitude;
    }
}
