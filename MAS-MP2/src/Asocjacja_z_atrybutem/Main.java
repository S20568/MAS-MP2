package Asocjacja_z_atrybutem;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        ServiceEmployee serviceEmployee1 = new ServiceEmployee("Jakub", "Slusarski", "Koszykowa 86, 12-345 Warszawa", 1, "Laptopy");
        ServiceEmployee serviceEmployee2 = new ServiceEmployee("John", "Doe", "Kaktusowa 12, 98-765 Krakow", 2, "Telefony");
        ServiceEmployee serviceEmployee3 = new ServiceEmployee("Jan", "Kowalski", "Kowalska 1, 11-111 Krakow", 3, "Telefony");

        ServicePoint servicePoint1 = new ServicePoint("Marszalkowska 42, 02-231 Warszawa");
        ServicePoint servicePoint2 = new ServicePoint("Wawelska 234, 42-311 Krakow");

        ServiceEmployee_ServicePoint serviceEmployee_servicePoint1 = new ServiceEmployee_ServicePoint(LocalDate.of(2019, 10, 12), LocalDate.of(2022, 1, 10), 5000, serviceEmployee1, servicePoint1);
        ServiceEmployee_ServicePoint serviceEmployee_servicePoint2 = new ServiceEmployee_ServicePoint(LocalDate.of(2020, 4, 30), LocalDate.of(2022, 5, 26), 3500, serviceEmployee2, servicePoint2);
        ServiceEmployee_ServicePoint serviceEmployee_servicePoint3 = new ServiceEmployee_ServicePoint(LocalDate.of(2017, 12, 5), LocalDate.of(2024, 2, 10), 7000, serviceEmployee3, servicePoint2);

        System.out.println(servicePoint1.getEmployee_servicePointList());
        System.out.println(servicePoint2.getEmployee_servicePointList());
    }
}
