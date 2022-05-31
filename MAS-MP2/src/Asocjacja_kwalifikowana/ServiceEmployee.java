package Asocjacja_kwalifikowana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceEmployee extends Employee {

    private String specialization;
//    Map<Integer, Repair> repairQuali = new HashMap<>();
    List<Repair> repairList = new ArrayList<>();

    public ServiceEmployee(String name, String surname, String address, int employeeId, String specialization) {
        super(name, surname, address, employeeId);
        this.specialization = specialization;
    }

    public void addRepair(Repair newRepair) {
        if(newRepair == null)
            throw new IllegalArgumentException("Service employee cannot be null");
        if(!repairList.contains(newRepair)) {
            repairList.add(newRepair);
            newRepair.addServiceEmployeeQuailif(this);
        }
    }

    public List<Repair> getRepairList() {
        return repairList;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Naprawy pracownika o ID: " + getEmployeeId() + '\n' + getRepairList();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public int getEmployeeId() {
        return super.getEmployeeId();
    }
}
