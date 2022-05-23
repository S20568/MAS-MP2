package Asocjacja_kwalifikowana;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name, surname;

    protected Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                '}';
    }
}
