package unique;

import main.ObjectPlus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Product extends ObjectPlus {
    private String name;
    private String sku;
    private double price;

    public Product(String name, String sku, double price) throws Exception {
        super();

        setName(name);
        setSku(sku);
        setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) throws Exception {
        checkUniquenessOf("sku", sku);
        this.sku = sku;
    }
}
