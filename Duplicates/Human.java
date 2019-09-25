/* Name: Nigina Daniyarova
 * File: Human.java
 * Desc: Class, constructor, getters, equals, CompareTo and toString methods
 * for a Candidate object with sex, race, dob, age, height, weight, hairColor
 * and eyeColor.
 *
 *
 */
public class Human implements Comparable<Human>{
    private String sex, race, eyeColor, hairColor;
    private int dob, age, weight;
    private Double height;

    /** Constructs a Human with sex, race, dob, age, height, weight, hairColor
     * and eyeColor
     */
    public Human(String sex, String race, int dob, int age, Double height,
		 int weight, String hairColor, String eyeColor){
	this.sex = sex;
	this.race = race;
	this.dob = dob;
	this.age = age;
	this.height = height;
	this.weight = weight;
	this.hairColor = hairColor;
	this.eyeColor = eyeColor;
    }
    public String getSex(){return sex;}
    public String getRace(){return race;}
    public int getDob(){return dob;}
    public int getAge(){return age;}
    public Double getHeight(){return height;}
    public int getWeight(){return weight;}
    public String getHairColor(){return hairColor;}
    public String getEyeColor(){return eyeColor;}

    @Override
    public int hashCode(){
	return 	toString().hashCode();
    }

    /** compares to another Human object based on their toString representation
     * @param h The Human that is being compared with
     * @return 0 if equals, 1 if bigger and -1 if smaller
     */
    public int compareTo(Human h){
	return this.toString().compareTo(h.toString());
    }

    public boolean equals(Human h){
	return compareTo(h) == 0;
    }

    @Override
    public String toString(){
	return "("+sex+", "+race+", "+dob+", "+age+", "+height+", "+weight+", "
	    +", "+hairColor +", " +eyeColor+")";
    }
}
