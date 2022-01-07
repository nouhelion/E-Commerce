package Traitement_Des_articles;


import Traitement_des_factures.Payable;
import org.jetbrains.annotations.NotNull;

public class Item implements Payable {
private final String name;
private final long price;
private final int weight;
//override payable methods
    @Override
    public String label() {
        return this.getName();
    }
    @Override
    public long cost() {
        return this.getPrice();
    }
    @Override
    public double taxRatePerTenThousand() {
        long p= this.getPrice();
        return p*0.1;
    }
//constructor  with arguments
    public Item(String name, long price,int weight) {
        this.price = price;
        this.name =name;
        this.weight = weight;
    }
//constructor of copy
    public Item(@NotNull Item a) {
        this.price = a.price;
        this.name =a.name;
        this.weight = a.weight;
    }
//override the println methode to print only objects we want
@Override
public String toString() {
       double p;
       p=price/100.000;
        return name +" : "+p +"0 MAD "+" : "+weight +" Grammes ";
}
//getter
//no setter since we dont wanna change anything
    public String getName() {
        return name;
    }
    public long getPrice() {
        return price;
    }
    public int getWeight() { return weight;}
//testing in the main
    public static void main(String[] args) {
        Item item = new Item("corn flakes", 500,1000);
        System.out.println(item);           // affiche: corn flakes: 5.00 MAD
        Item chewingGum = new Item("chewing gum",403,500);
        System.out.println(chewingGum);    // affiche: chewing gum: 4.03 MAD
    }
}
