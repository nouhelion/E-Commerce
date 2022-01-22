package Traitement_des_factures;

import Traitement_Des_articles.Item;
import Traitement_des_produits_frais.FreshItem;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class Invoice {
    //private array to add facture for all items
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
    public long  totalTax(){
        long tax=0;
        for (Payable a : facture){
            //algorithm
          tax+=(((a.taxRatePerTenThousand()/10)*a.cost())/1000);
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
//       System.out.println(invoice);
        Item tin = new Item("sardine", 500, 500); //1000=>10% =>50
        FreshItem fresh = new FreshItem("sardine", 500, 500, "2012-04-11");//1000=>10% => 50
        FreshItem fresh2 = new FreshItem("sardine x3", 1500, 1500, "2012-04-11");//990=>9.9% =148
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
