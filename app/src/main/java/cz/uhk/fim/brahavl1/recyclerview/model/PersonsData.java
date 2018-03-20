package cz.uhk.fim.brahavl1.recyclerview.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.brahavl1.recyclerview.model.Person;

/**
 * Created by brahavl1 on 19.03.2018.
 */

public class PersonsData extends ArrayList<Person>{

    public static PersonsData newTestInstance(){

        //veřejna metoda vracejici testovaci data
        PersonsData testPersonData = new PersonsData();
        testPersonData.add(new Person("karel", 18, true));
        testPersonData.add(new Person("michal", 88, true));
        testPersonData.add(new Person("misa", 18, false));
        return testPersonData;
    }

    //kdyby nebyl extends
 /*   private List<Person> persons;

    public List<Person> getAll() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void addPerson(String name, int age, boolean male) {
        persons.add(new Person(name, age, male));
    }*/


}
