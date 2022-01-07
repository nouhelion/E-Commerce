package Traitement_des_factures;

import Traitement_Des_articles.Item;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List <Payable> facture = new ArrayList<Payable>();
    public Invoice() {
    }
    public void add(Payable p){
        this.facture.add(p);
    }
    @Override
    public String toString() {
        for (Payable a : facture){
            System.out.println(a.label()+", "+a.cost());
        }
        return "";
    }
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        Payable payable = new Ticket("RGBY20120317 - Walles-France", 9000);
        Ticket ticket = new Ticket("MUSI20120612 - RollingStones",12000);
        invoice.add(payable);
        invoice.add(ticket);
        Item item = new Item("corn flakes", 500, 1000);
        invoice.add(item);
        System.out.println(invoice);
    }
}
