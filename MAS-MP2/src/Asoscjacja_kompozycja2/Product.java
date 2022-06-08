package Asoscjacja_kompozycja2;

/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product implements Serializable {

    String name;
    List<Part> partList = new ArrayList<>();
    static Set<Part> allParts = new HashSet<>();


    public Product(String name) {
        this.name = name;
    }

    public void addPart(Part part) throws Exception {
        if(!partList.contains(part)) {
            if(allParts.contains(part)) {
                throw new Exception("Part is already used by another product");
            }
            partList.add(part);
            allParts.add(part);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Whole: " + name + "\n");
        for(Part part : partList) {
            info.append(" ").append(part.partName).append("\n");
        }
        return info.toString();
    }
}