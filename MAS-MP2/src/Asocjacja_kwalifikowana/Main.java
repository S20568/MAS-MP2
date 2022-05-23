package Asocjacja_kwalifikowana;

public class Main {
    public static void main(String[] args) {

        ServiceEmployee serviceEmployee1 = new ServiceEmployee("Jakub", "Slusarski", "Warszawa", 1, "Laptopy");
        ServiceEmployee serviceEmployee2 = new ServiceEmployee("Jan", "Kowalski", "Krakow", 2, "Telefony");

        Repair repair1 = new Repair(12412, "Wymiana głośnika");
        Repair repair2 = new Repair(8923, "Wymiana baterii");
        Repair repair3 = new Repair(72, "Czyszczenie telefonu");

        serviceEmployee1.addRepairQuali(repair1);
        serviceEmployee1.addRepairQuali(repair3);
        serviceEmployee2.addRepairQuali(repair2);
        System.out.println(serviceEmployee1);
        System.out.println(serviceEmployee2);
        System.out.println("==========================");
        serviceEmployee1.removeRepairQuali(72);
        serviceEmployee2.addRepairQuali(repair3);
        System.out.println(serviceEmployee1);
        System.out.println(serviceEmployee2);
    }
}
