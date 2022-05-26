package Asocjacja_kwalifikowana;

import java.time.LocalDate;

public class Repair {

    int repairId;
    LocalDate repairTime;
    String typeOfRepair;
    RepairStatus repairStatus;
    ServiceEmployee serviceEmployee;

    public Repair(int repairId, String typeOfRepair) {
        this.repairId = repairId;
        this.typeOfRepair = typeOfRepair;
        this.repairTime = LocalDate.now();
        this.repairStatus = RepairStatus.Waiting_for_product;
    }

    public Repair(int repairId, String typeOfRepair, RepairStatus repairStatus) {
        this.repairId = repairId;
        this.typeOfRepair = typeOfRepair;
        this.repairTime = LocalDate.now();
        this.repairStatus = repairStatus;
    }

    public void setServiceEmployee(ServiceEmployee newServiceEmployee) {
        if (newServiceEmployee == null)
            throw new IllegalArgumentException("Service employee cannot be null");
        this.serviceEmployee = newServiceEmployee;
        newServiceEmployee.addRepairQuali(this);
    }

    public int getRepairId() {
        return repairId;
    }

    public String getTypeOfRepair() {
        return typeOfRepair;
    }

    public LocalDate getRepairTime() {
        return repairTime;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    @Override
    public String toString() {
        return "Repair ID " + getRepairId() + ": " + getTypeOfRepair() + ", " + getRepairTime() + ", " + getRepairStatus();
    }
}
