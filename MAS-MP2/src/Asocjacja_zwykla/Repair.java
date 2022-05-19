package Asocjacja_zwykla;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repair {
    int repairId;
    LocalDate repairTime;
    Client client; //implementacja asocjacji zwykłej pomiędzy Klientem a naprawą, liczność 1
    String typeOfRepair;
    RepairStatus repairStatus;

    public Repair(int repairId, String typeOfRepair) {
        this.repairId = repairId;
        this.typeOfRepair = typeOfRepair;
        this.repairTime = LocalDate.now();
        this.repairStatus = RepairStatus.Waiting_for_product;
    }

    public void setClient(Client newClient) {
        if(client == null)
            throw new IllegalArgumentException("Client cannot be null");
        if(this.client != newClient) {
            this.client = newClient;
            newClient.addRepair(this);
        }
    }

    private static List<Repair> extent = new ArrayList<>();
    private static void addRepair(Repair repair) {
        extent.add(repair);
    }

    static void showExtent(){
        System.out.println("Extent of the class: " + Client.class.getName());

        for (Repair repair : extent) {
            System.out.println(repair);
        }
    }

    static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Repair>)stream.readObject();
    }

    public void setRepairStatus(int repairId, RepairStatus repairStatus) {
        for(Repair repair : extent){
            if(repair.repairId == repairId) {
                repair.repairStatus = repairStatus;
            } else {
                throw new IllegalArgumentException("There is no repair registered with given id");
            }
        }
    }
}
