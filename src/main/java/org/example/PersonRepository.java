package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {


    private ConnectionService connectionService;

    public PersonRepository() {
        connectionService = new ConnectionService();
    }

    public List<Person> getAllPerson() throws SQLException {
        try (Connection connection = connectionService.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select name, surname, varsta, idnp FROM person ORDER BY id;");

            List<Person> personList = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                int varsta = resultSet.getInt(3);
                int idnp = resultSet.getInt(4);

                Person person = new Person(name, surname, varsta, idnp);

                personList.add(person);
            }

            return personList;
        }
    }


    public Person getPersonByIdnp(int idnp) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select name, surname, varsta, idnp FROM person WHERE idnp = " + idnp + " ;");

            if(resultSet.next()){
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                int varsta = resultSet.getInt(3);

                return new Person(name, surname, varsta, idnp);
            }

        }

        return null;
    }

    public void updatePersonAge(int idnp, int age) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {
            Statement statement = connection.createStatement();
           int randuriModificate = statement.executeUpdate("UPDATE person SET varsta = " + age + " WHERE idnp = " + idnp + ";");

            System.out.println("Au fost modificate " + randuriModificate + " randuri");
        }
    }

    public void addPerson(Person person) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO person(name,surname,idnp,varsta) VALUES("
                    +  "'" +  person.getName()  +  "'" +  ", "
                    +  "'" + person.getSurname()  +  "'" + ", "
                    + person.getIdnp() + ", "
                    + person.getVarsta() + ")");
        }

    }


    public void addPersonPreparedStatement(Person person) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person(name,surname,idnp,varsta) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getIdnp());
            preparedStatement.setInt(4, person.getVarsta());

            preparedStatement.execute();

        }

    }

    public Person findPersonByNameAndSurname(String name, String surname) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("Select name, surname, varsta, idnp FROM person WHERE name = ? AND surname = ? ");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int varsta = resultSet.getInt(3);
                int idnp = resultSet.getInt(4);
                return new Person(name, surname, varsta, idnp);
            }
        }

        return null;

    }

    public void deletePersonByIdnp(int idnp) throws SQLException {
        try (Connection connection = connectionService.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE idnp = ?");
            preparedStatement.setInt(1, idnp);

            preparedStatement.execute();
        }
    }




}
