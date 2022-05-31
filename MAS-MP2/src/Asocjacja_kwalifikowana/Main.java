package Asocjacja_kwalifikowana;

public class Main {
    public static void main(String[] args) {

        ServiceEmployee serviceEmployee1 = new ServiceEmployee("Jakub", "Slusarski", "Warszawa", 1, "Laptopy");
        ServiceEmployee serviceEmployee2 = new ServiceEmployee("Jan", "Kowalski", "Krakow", 2, "Telefony");

        Repair repair1 = new Repair(12412, "Wymiana głośnika");
        Repair repair2 = new Repair(8923, "Wymiana baterii");
        Repair repair3 = new Repair(72, "Czyszczenie telefonu");

        repair1.addServiceEmployeeQuailif(serviceEmployee1);
        repair2.addServiceEmployeeQuailif(serviceEmployee1);
        repair3.addServiceEmployeeQuailif(serviceEmployee2);
        System.out.println(repair1);
        System.out.println(repair2);
        System.out.println(repair3);
        System.out.println("==========================");
        repair1.removeRepairQuali(1);
        repair1.addServiceEmployeeQuailif(serviceEmployee2);
        System.out.println(repair1);
        System.out.println(repair2);
        System.out.println(repair3);
        System.out.println("==========================");
        System.out.println(repair3.findServiceEmployeeQuali(2));
    }
}
