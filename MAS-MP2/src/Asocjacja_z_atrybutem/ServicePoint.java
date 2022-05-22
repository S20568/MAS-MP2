package Asocjacja_z_atrybutem;

import java.util.ArrayList;
import java.util.List;

public class ServicePoint {

    String address;
    List<ServiceEmployee_ServicePoint> employee_servicePointList = new ArrayList<>();

    public ServicePoint(String address) {
        this.address = address;
    }

    public void addEmployee_ServicePoint(ServiceEmployee_ServicePoint employee_servicePoint) {
        if(!(employee_servicePoint == null) && !employee_servicePointList.contains(employee_servicePoint)) {
            employee_servicePointList.add(employee_servicePoint);
            employee_servicePoint.setServicePoint(this);
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
        return "Punkt serwisowy{" +
                "Adres='" + address + '\'' +
                '}';
    }
}
