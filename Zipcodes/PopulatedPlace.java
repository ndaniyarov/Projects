/* Name: Nigina Daniyarova
 * File: PopulatedPlace.java
 * Desc:
 *      Class, constructor, getters and setters for a PopulatedPlace
 *      with the given zip, town name, state, latitude, longitude and
 *      population
 *
 *
 */

public class PopulatedPlace extends LocatedPlace{
    private int population;

    /** Constructs a PopulatedPlace object that extends LocatedPlace
     * @param zip The 5-digit zip code
     * @param town The town name
     * @param state The state abbreviation
     * @param latitude the latitude of the place
     * @param longitude the longitude of the place
     * @param population the population of the place
     */
    public PopulatedPlace(String zip, String town, String state,
			  double latitude, double longitude, int population){
	super(zip, town, state, latitude, longitude);
	this.population = population;
    }
    public int getPopulation(){
	return population;
    }
    public void setPopulation(int pop) {
	population = pop;
    }
    @Override
    public String toString(){
	return super.toString()+" " + population;
    }
}
