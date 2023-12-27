package org.example;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {

        PersonRepository personRepository = new PersonRepository();
//        List<Person> personList = personRepository.getAllPerson();
//        System.out.println("Total persoane initial: " + personList.size());
//
//        Person person = new Person("Robert", "Mandalac", 40, 91983);
//
//        personRepository.addPersonPreparedStatement(person);
//
//        personList = personRepository.getAllPerson();
//        System.out.println("Total persoane dupa insert: " + personList.size());


        Person person = personRepository.findPersonByNameAndSurname("Robert", "Mandalac");
        System.out.println(person);

        personRepository.deletePersonByIdnp(person.getIdnp());

        person = personRepository.findPersonByNameAndSurname("Robert", "Mandalac");
        System.out.println(person);









        // Starea initiala
//        Person person = personRepository.getPersonByIdnp(9876);
//        System.out.println(person);




        // Modificam Varsta
//        personRepository.updatePersonAge(9876, 20);
//
//        // Verificam modificarea
//        person = personRepository.getPersonByIdnp(9876);
//        System.out.println(person);




        //        List<Person> personList = personRepository.getAllPerson();

//        for (Person person : personList) {
//            System.out.println(person);
//        }

    }

}
