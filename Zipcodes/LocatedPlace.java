/* Name: Nigina Daniyarova
 * File: LocatedPlace.java
 * Desc:
 *      Class, constructor, getters and setters for a LocatedPlace
 *      with the given zip, town, state, latitude and longitude
 *
 */

public class LocatedPlace extends Place{
    private double latitude;
    private double longitude;

    /** Creates a LocatedPlace with the given zip, town name, state,
        latitude and a longitude
        * @param zip The 5-digit zip code
        * @param town The town name
        * @param state The state abbreviation
        * @param latitude the latitude of the place
        * @param longitude the longitude of the place
        */
    public LocatedPlace(String zip, String town, String state,
			double latitiude, double longitude){
	super(zip, town, state);
	this.latitude = latitude;
	this.longitude = longitude;
    }
    public double getLatitude(){
	return latitude;
    }
    public void setLatitude(double lat) {
	latitude = lat;
    }
    public double getLongitude(){
	return longitude;
    }
    public void setLongitude(double lon) {
	longitude = lon;
    }

    @Override
    public String toString(){
	return super.toString()+" " + latitude + " " + longitude;
    }
}
