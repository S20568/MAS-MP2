package Asocjacja_zwykla;

import java.time.LocalDate;

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

    public void setClient(Client client) {
        if(!(client == null)){
            this.client = client;
            client.addRepair(this);
        }
    }



    public RepairStatus getRepairStatus() {
        return repairStatus;
    }
}
