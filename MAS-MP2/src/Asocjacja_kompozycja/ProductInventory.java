package Asocjacja_kompozycja;

import java.util.*;

public class ProductInventory {

    static Map<Product, Integer> availableProducts = new HashMap<>();

    public ProductInventory() {}

    public static void addToProductInventory(int quantity, Product newProduct) {
        availableProducts.put(newProduct, quantity);
    }

    public Product getSpecificProduct(Product takenProduct) {
        for(Map.Entry<Product, Integer> p : availableProducts.entrySet()) {
            if (Objects.equals(takenProduct.getSku(), p.getKey().getSku())) {
                takenProduct = p.getKey();
                availableProducts.replace(p.getKey(), p.getValue() - 1);
            }
        }
        return takenProduct;
    }

    public void listProductInventory() {
        List<Product> availableProductsList = new ArrayList<>();
        for(Map.Entry<Product, Integer> entry : availableProducts.entrySet()) {
            availableProductsList.add(entry.getKey());
        }
        System.out.println("Available products:");
        for(Product p : availableProductsList) {
            System.out.print(p + ", quantity=");
            System.out.print(availableProducts.get(p));
            System.out.println();
        }
    }
}
