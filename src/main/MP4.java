package main;


import attribute.Tax;
import custom.CustomInvoice;
import custom.Payment;
import history.Asset;
import history.AssetOwnership;
import history.Company;
import ordered.Invoice;
import ordered.InvoiceEntry;
import ordered2.Dziennik;
import ordered2.OrderedStudent;
import subset.Board;
import subset.User;
import unique.Product;
import xor.Budget;
import xor.Project;
import xor.Team;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MP4 {
    public static void main(String[] args) {

        // attribute
        try {
            Tax vat23 = new Tax("VAT 23%", 23);
            vat23.setPercentage(120);
        } catch(Exception e) {
            System.out.println("Niepoprawny podatek: " + e.getMessage());
        }

        System.out.println("\n-----------------------\n");

        // unique
        try {
            Product headphones = new Product("Słuchawki Logitech", "001", 67.99);
            Product mouse = new Product("Myszka Razer", "002", 91.5);

            Product headphones2 = new Product("Logitech Słuchawki", "001", 31.55);
        } catch(Exception e) {
            System.out.println("Niepoprawny numer SKU: " + e.getMessage());
        }

        System.out.println("\n-----------------------\n");

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

        System.out.println("\n-----------------------\n");

        // ordered
        Invoice inv = new Invoice("01/2016");
        inv.addEntry(new InvoiceEntry("Papier A4", 20, 16.55));
        inv.addEntry(new InvoiceEntry("Zszywki, 20 szt.", 10, 6.55));

        System.out.println(inv.toString());

        System.out.println("\n-----------------------\n");

        // ordered2

        OrderedStudent st1 = new OrderedStudent("Kamil", "Kowalski");
        OrderedStudent st4 = new OrderedStudent("Adrian", "Zandberg");
        OrderedStudent st2 = new OrderedStudent("Lech", "Wałęsa");
        OrderedStudent st3 = new OrderedStudent("Andrzej", "Duda");

        Set<OrderedStudent> students = new HashSet<>();
        students.add(st1);
        students.add(st4);
        students.add(st2);
        students.add(st3);

        Dziennik dz = new Dziennik("3C", students);
        List<OrderedStudent> orderedStudents = dz.getOrderedStudents();

        for(int i=0; i < orderedStudents.size(); i++) {
            System.out.println("" + (i+1) + ". " + orderedStudents.get(i).toString());
        }

        System.out.println("\n-----------------------\n");

        // history
        Asset lodowka = new Asset("Lodówka Bosch", 1500, 15);
        Company firma = new Company("Prószyński", "Prószyński sp. z o. o.", "Warszawa", "Aleje Jerozolimskie 15");

        AssetOwnership ownership = new AssetOwnership(lodowka, firma, new Date(), new Date());

        System.out.println(ownership.toString());

        System.out.println("\n-----------------------\n");

        // xor
        Team team = new Team("Drużyna A");
        Project project = new Project("Project 1", new Date());
        Budget budget = new Budget(15000);

        try {
            budget.setProject(project);
            budget.setTeam(team);
        } catch(Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("\n-----------------------\n");

        // custom
        CustomInvoice faktura2 = new CustomInvoice("01/2016", 150);
        Payment platnosc1 = new Payment("Karta", 50);
        Payment platnosc2 = new Payment("Gotówka", 101);

        try {
            faktura2.addPayment(platnosc1);
            faktura2.addPayment(platnosc2);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
