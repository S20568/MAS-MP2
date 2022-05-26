package Asocjacja_z_atrybutem;

import Asocjacja_zwykla.Client;

import java.time.LocalDate;

public class ServiceEmployee_ServicePoint {

    ServiceEmployee serviceEmployee;
    ServicePoint servicePoint;
    LocalDate worksFrom;
    LocalDate worksTo;
    int salary;

    public ServiceEmployee_ServicePoint(LocalDate worksFrom, LocalDate worksTo, int salary, ServiceEmployee serviceEmployee, ServicePoint servicePoint) {
        this.worksFrom = worksFrom;
        this.worksTo = worksTo;
        this.salary = salary;
        this.setServiceEmployee(serviceEmployee);
        this.setServicePoint(servicePoint);
    }

    public void setServiceEmployee(ServiceEmployee serviceEmployee) {
        if(serviceEmployee == null)
            throw new IllegalArgumentException("Client cannot be null");
        if(this.serviceEmployee != serviceEmployee) {
            this.serviceEmployee = serviceEmployee;
            serviceEmployee.addEmployee_ServicePoint(this);
        }
    }

    public void setServicePoint(ServicePoint servicePoint) {
        if(servicePoint == null)
            throw new IllegalArgumentException("Client cannot be null");
        if(this.servicePoint != servicePoint) {
            this.servicePoint = servicePoint;
            servicePoint.addEmployee_ServicePoint(this);
        }
    }

    public void removeServicePoint() {
        this.servicePoint.removeEmployee_ServicePoint(this);
        this.servicePoint = null;
    }

    public void removeServiceEmployee() {
        this.serviceEmployee.removeEmployee_ServicePoint(this);
        this.serviceEmployee = null;
    }

    @Override
    public String toString() {
        return "Service employee: \n"+ serviceEmployee +
                "works in: " + servicePoint +
                ", from: " + worksFrom +
                ", to: " + worksTo +
                ", with " + salary + " salary]";
    }
}
