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
    List<Repair> listOfRepairs = new ArrayList<>();

    public Client(String name, String surname, String email, String address, int phoneNumber, boolean isRegistered) {
        super(name, surname);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
        addClient(this);
    }

    public void addRepair(Repair newRepair) {
        if(newRepair == null)
            throw new IllegalArgumentException("Repair cannot be null");
        if(!listOfRepairs.contains(newRepair)) {
            listOfRepairs.add(newRepair);
            newRepair.setClient(this);
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

    public void getListOfRepairs() {
        System.out.println(name + " " + surname);
        for(Repair repair : listOfRepairs) {
            System.out.println(repair);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + surname;
    }
}
