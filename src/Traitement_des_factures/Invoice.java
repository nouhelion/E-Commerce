package Traitement_des_factures;

import Traitement_Des_articles.Item;
import Traitement_des_produits_frais.FreshItem;

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
    public long totalAmount(){
        long sum=0;
        for (Payable a : facture){
            sum+=a.cost();
        }
        return sum;
    }
    public long totalTax(){
        long tax=0;
        for (Payable a : facture){
          tax+=(a.taxRatePerTenThousand()/100)*a.cost();
        }
        return tax;
    }
    public static void main(String[] args) {
//        Invoice invoice = new Invoice();
//        Payable payable = new Ticket("RGBY20120317 - Walles-France", 9000);
//        Ticket ticket = new Ticket("MUSI20120612 - RollingStones",12000);
//        invoice.add(payable);
//        invoice.add(ticket);
//        Item item = new Item("corn flakes", 500, 1000);
//        invoice.add(item);
//        System.out.println(invoice);
        Item tin = new Item("sardine", 500, 500);
        FreshItem fresh = new FreshItem("sardine", 500, 500, "2012-04-11");
        FreshItem fresh2 = new FreshItem("sardine x3", 1500, 1500, "2012-04-11");
        System.out.println(tin.taxRatePerTenThousand());     // affiche: 1000
        System.out.println(fresh.taxRatePerTenThousand());   // affiche: 1000
        System.out.println(fresh2.taxRatePerTenThousand());  // affiche:  990
        Invoice invoice = new Invoice();
        invoice.add(tin);
        invoice.add(fresh);
        invoice.add(fresh2);
        System.out.println(invoice.totalAmount());  // affiche: 2500
        System.out.println(invoice.totalTax());     // affiche:  248


    }
}
