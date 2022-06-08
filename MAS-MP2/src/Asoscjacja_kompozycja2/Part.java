package Asoscjacja_kompozycja2;

public class Part {
    String partName;
    Product product;

    private Part(Product product, String partName) {
        this.partName = partName;
        this.product = product;
    }

    public static Part createPart(Product product, String partName) throws Exception{
        if(product == null)
            throw new Exception("Given product does not exist");
        Part part = new Part(product, partName);
        product.addPart(part);

        return part;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partName='" + partName + '\'' +
                ", product=" + product +
                '}';
    }
}
