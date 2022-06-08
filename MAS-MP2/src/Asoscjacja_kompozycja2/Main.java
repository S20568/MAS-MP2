package Asoscjacja_kompozycja2;

public class Main {
    public static void main(String[] args) throws Exception {

        Product iPhone13 = new Product("iPhone 13");
        Product GalaxyS22 = new Product("Galaxy S22");
        Product MacBookPro = new Product("MacBook Pro");
        Product AirPodsPro = new Product("AirPods Pro");

        Part part1 = Part.createPart(iPhone13, "Battery");
        Part part2 = Part.createPart(iPhone13, "Battery");
        Part part3 = Part.createPart(GalaxyS22, "Display");
        Part part4 = Part.createPart(iPhone13, "Display");
        Part part5 = Part.createPart(AirPodsPro, "Speaker");

        System.out.println(iPhone13);
        System.out.println(GalaxyS22);
    }
}
