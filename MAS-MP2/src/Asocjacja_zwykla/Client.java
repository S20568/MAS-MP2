package Asocjacja_zwykla;
/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Serializable {
    String email, address;
    int phoneNumber;
    boolean isRegistered;
    List<Repair> listOfRepairs; //implementacja asocjacji zwykłej pomiędzy Klientem a naprawą, liczność *

    public Client(String name, String surname, String email, String address, int phoneNumber, boolean isRegistered, Repair repair) {
        super(name, surname);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
        addClient(this);
    }

    public void addRepair(Repair newRepair) {
        if(!(newRepair == null) && !listOfRepairs.contains(newRepair)) {
            listOfRepairs.add(newRepair);
            newRepair.setClient(this);
        } else {
            throw new IllegalArgumentException("Client already has this repair");
        }
    }

    private static List<Client> extent = new ArrayList<>();
    private static void addClient(Client client) {
        extent.add(client);
    }

    static void showExtent(){
        System.out.println("Extent of the class: " + Client.class.getName());

        for (Client client : extent) {
            System.out.println(client);
        }
    }

    static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Client>)stream.readObject();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber= +48 " + phoneNumber +
                ", isRegistered=" + isRegistered +
                '}';
    }
}
