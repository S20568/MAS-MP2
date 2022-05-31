package Asocjacja_kwalifikowana;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Repair {

    int repairId;
    LocalDate repairTime;
    String typeOfRepair;
    RepairStatus repairStatus;
//    ServiceEmployee serviceEmployee;
    Map<Integer, ServiceEmployee> serviceEmployeeQualif = new HashMap<>();

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

    public void addServiceEmployeeQuailif(ServiceEmployee newServiceEmployee) {
        if(!serviceEmployeeQualif.containsKey(newServiceEmployee.getEmployeeId())) {
            serviceEmployeeQualif.put(newServiceEmployee.getEmployeeId(), newServiceEmployee);

            newServiceEmployee.addRepair(this);
        }
    }

    public void removeRepairQuali(int employeeId) {
        serviceEmployeeQualif.remove(employeeId);
    }

    public ServiceEmployee findServiceEmployeeQuali(int employeeId) {
        if(!serviceEmployeeQualif.containsKey(employeeId)) {
            throw new IllegalArgumentException("Unable to find serviceEmployee with id: " + employeeId);
        }
        return serviceEmployeeQualif.get(employeeId);
    }

//    public void setServiceEmployee(ServiceEmployee newServiceEmployee) {
//        if (newServiceEmployee == null)
//            throw new IllegalArgumentException("Service employee cannot be null");
//        if(this.serviceEmployee != newServiceEmployee) {
//            this.serviceEmployee = newServiceEmployee;
//            newServiceEmployee.addRepairQuali(this);
//        }
//    }

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
