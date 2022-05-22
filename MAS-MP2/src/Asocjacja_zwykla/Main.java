package Asocjacja_zwykla;

public class Main {
    public static void main (String[] args) {
        Client client1 = new Client("Jakub", "Slusarski", "s20568@pjwstk.edu.pl", "Koszykowa 86, 12-345, Warszawa", 123456789, false);
        Client client2 = new Client("John", "Doe", "johndoe1@gmail.com", "Słoneczna 2, 00-321 Poznan", 987654321, true);

        Repair repair1 = new Repair(1, "Wymiana ekranu");
        Repair repair2 = new Repair(2, "Wymiana baterii", RepairStatus.During_repair);
        Repair repair3 = new Repair(3, "Wymiana głosnika", RepairStatus.Accepted);

        client1.addRepair(repair1);
        client2.addRepair(repair2);
        client2.addRepair(repair3);

        client1.getListOfRepairs();
        client2.getListOfRepairs();


    }
}
