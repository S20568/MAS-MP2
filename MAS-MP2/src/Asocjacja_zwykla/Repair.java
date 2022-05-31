package Asocjacja_zwykla;

/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repair implements Serializable {
    int repairId;
    LocalDate repairTime;
    Client client;
    String typeOfRepair;
    RepairStatus repairStatus;

    public Repair(int repairId, String typeOfRepair) {
        this.repairId = repairId;
        this.typeOfRepair = typeOfRepair;
        this.repairTime = LocalDate.now();
        this.repairStatus = RepairStatus.Waiting_for_product;
        addRepair(this);
    }

    public Repair(int repairId, String typeOfRepair, RepairStatus repairStatus) {
        this.repairId = repairId;
        this.typeOfRepair = typeOfRepair;
        this.repairTime = LocalDate.now();
        this.repairStatus = repairStatus;
        addRepair(this);
    }

    public void setClient(Client newClient) {
        if(newClient == null)
            throw new IllegalArgumentException("Client cannot be null");
        if(this.client == newClient)
            return;
        if(this.client != null)
            this.client.removeRepair(this);
        this.client = newClient;
        newClient.addRepair(this);
        //        if(this.client != null) {
//            if (this.client != newClient) {
//                this.client = newClient;
//                newClient.addRepair(this);
//            }
//        } else {
//
//        }
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

    @Override
    public String toString() {
        return "Repair ID: " + repairId + "; Repair date: " + repairTime + "; Repair type: " + typeOfRepair + "; Repair status: " + repairStatus;
    }
}
