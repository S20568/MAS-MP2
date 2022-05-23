package Asocjacja_kwalifikowana;

import java.util.HashMap;
import java.util.Map;

public class ServiceEmployee extends Employee {

    private String specialization;
    Map<Integer, Repair> repairQuali = new HashMap<>();

    public ServiceEmployee(String name, String surname, String address, int employeeId, String specialization) {
        super(name, surname, address, employeeId);
        this.specialization = specialization;
    }

    public void addRepairQuali(Repair newRepair) {
        if(newRepair == null)
            throw new IllegalArgumentException("Service employee cannot be null");
        if(!repairQuali.containsKey(newRepair.getRepairId())) {
            repairQuali.put(newRepair.getRepairId(), newRepair);
            newRepair.setServiceEmployee(this);
        }
    }

    public void removeRepairQuali(int repairId) {
        repairQuali.remove(repairId);
    }

    public String getSpecialization() {
        return specialization;
    }

    public Map<Integer, Repair> getRepairQuali() {
        return repairQuali;
    }

    @Override
    public String toString() {
        return "Naprawy pracownika o ID: " + getEmployeeId() + '\n' + getRepairQuali().values();
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
