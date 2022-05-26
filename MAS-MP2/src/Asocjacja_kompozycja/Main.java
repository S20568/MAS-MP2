package Asocjacja_kompozycja;

public class Main {
    public static void main(String[] args) {

        ProductInventory productInventory = new ProductInventory();

        //Filling product inventory
        Product product1 = new Product("iPhone 13", "Appple", "Smartphone", "AP4129", 995120120, 4799, true, 10);
        Product product2 = new Product("Galaxy S22", "Samsung", "Smartphone", "SP58124", 7741289, 3999, false, 12);
        Product product3 = new Product("MacBook Pro", "Apple", "Laptop", "AL1120", 15125152, 8999, true, 4);
        Product product4 = new Product("AirPods Pro", "Apple", "Headphones", "AH9902", 21412495, 999, true, 40);

        System.out.println();
        productInventory.listProductInventory();

        Order order1 = new Order(1,"Card", "DPD");
        Order order2 = new Order(2,"Cash", "Pick-up point");
        order1.addOrderedProduct(productInventory.getSpecificProduct(product1));
        order1.addOrderedProduct(productInventory.getSpecificProduct(product4));
        //Listing ordered products in order1
        System.out.println();
        System.out.println("Products ordered in order1");
        order1.getOrderedProducts();
        System.out.println();
        order1.setOrderStatus(1, OrderStatus.Ready_for_shipping);
        order1.getOrderedProducts();

        System.out.println();
        productInventory.listProductInventory();
    }
}
