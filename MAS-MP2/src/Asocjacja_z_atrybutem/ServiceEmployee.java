package Asocjacja_z_atrybutem;

import java.util.ArrayList;
import java.util.List;

public class ServiceEmployee extends Employee{

    String specialization;
    List<ServiceEmployee_ServicePoint> employee_servicePointList = new ArrayList<>();

    public ServiceEmployee(String name, String surname, String address, int employeeId, String specialization) {
        super(name, surname, address, employeeId);
        this.specialization = specialization;
    }

    public void addEmployee_ServicePoint(ServiceEmployee_ServicePoint employee_servicePoint) {
        if(!(employee_servicePoint == null) && !employee_servicePointList.contains(employee_servicePoint)) {
            employee_servicePointList.add(employee_servicePoint);
            employee_servicePoint.setServiceEmployee(this);
        } else {
            throw new IllegalArgumentException("Client already has this repair");
        }
    }

    public void removeEmployee_ServicePoint(ServiceEmployee_ServicePoint employee_servicePoint) {
        employee_servicePointList.remove(employee_servicePoint);
    }

    public List<ServiceEmployee_ServicePoint> getEmployee_servicePointList() {
        return employee_servicePointList;
    }

    @Override
    public String toString() {
        return "ServiceEmployee{" +
                "Id pracownika=" + employeeId +
                ", Imię='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                ", specjalizacja='" + specialization + '\'' +
                ", adres='" + address + '\'' +
                '}';
    }
}
