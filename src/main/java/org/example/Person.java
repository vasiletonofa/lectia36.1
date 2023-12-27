package org.example;

public class Person {

    private String name;
    private String surname;
    int varsta;
    int idnp;

    public Person(String name, String surname, int varsta, int idnp) {
        this.name = name;
        this.surname = surname;
        this.varsta = varsta;
        this.idnp = idnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getIdnp() {
        return idnp;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", varsta=" + varsta +
                ", idnp=" + idnp +
                '}';
    }
}
