package org.example.person;


import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Pedro Ankersmit
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender;

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param //name the name of the person
     * @param //age the age of the person
     * @param //gender the gender of the person
     */

    public Person(String n, int a, String g){
        this.name = n;
        this.age = a;
        this.gender = g;
    }


    public String getName() {return name;}

    public int getAge() {return age;}

    public String getGender() {return gender;}
    public double[] averageAgePerGender( List<Person> persons){
        double maleAge = 0, femaleAge = 0;
        double mCount = 0, fCount = 0;
        if(persons != null){
        for (Person a: persons) {
            if (a.getGender().equals("Male")) {
                maleAge += a.getAge();
                mCount++;
            } else if (a.getGender().equals("Female")) {
                femaleAge +=a.getAge();
                fCount++;
            }
        }
        }



        double[] res = new double[2];
        if(mCount == 0){
        res[0] = mCount;} else {
          res[0] = maleAge/mCount;
        }
        if(fCount == 0){
            res[1] = fCount;
        }else {
            res[1] = femaleAge / fCount;
        }
        return res;
    }


}
