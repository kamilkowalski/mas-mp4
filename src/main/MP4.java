package main;


import attribute.Tax;
import ordered.Invoice;
import ordered.InvoiceEntry;
import subset.Board;
import subset.User;
import unique.Product;

public class MP4 {
    public static void main(String[] args) {

        // attribute
        try {
            Tax vat23 = new Tax("VAT 23%", 23);
            vat23.setPercentage(120);
        } catch(Exception e) {
            System.out.println("Niepoprawny podatek: " + e.getMessage());
        }

        // unique
        try {
            Product headphones = new Product("Słuchawki Logitech", "001", 67.99);
            Product mouse = new Product("Myszka Razer", "002", 91.5);

            Product headphones2 = new Product("Logitech Słuchawki", "001", 31.55);
        } catch(Exception e) {
            System.out.println("Niepoprawny numer SKU: " + e.getMessage());
        }

        // subset
        try {
            Board motocykle = new Board("Motocykle");
            Board zegluga = new Board("Zegluga");

            User kamil = new User("Kamil Kowalski");
            User seba = new User("Sebastian Nowak");

            motocykle.addUser(kamil);
            motocykle.addAdmin(kamil);

            zegluga.addAdmin(seba);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // ordered
        Invoice inv = new Invoice("01/2016");
        inv.addEntry(new InvoiceEntry("Papier A4", 20, 16.55));
        inv.addEntry(new InvoiceEntry("Zszywki, 20 szt.", 10, 6.55));

        System.out.println(inv.toString());
    }
}
