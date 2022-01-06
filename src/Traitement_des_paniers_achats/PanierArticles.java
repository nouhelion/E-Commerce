package Traitement_des_paniers_achats;

// Importing required classes

import Traitement_Des_articles.Item;
import java.util.ArrayList;
import java.util.List;

public class PanierArticles {
    private List<Item> items = new ArrayList<Item>();
    private  int counter = 0;
    public static int a=0;
    private int ID;
    //default constructor
    public PanierArticles() {
        a++;
        ID=a;
    }
    //add to the collection of itens to panierArticles
    public void addItem(Item item) {
        if (item.getWeight()>1000)
            throw new IllegalStateException("Weight superior to 10 kgs");
        else {
            this.items.add(item);
            counter++;
        }
    }
    //getter ID
    public int getID() { return ID; }
    //removeItem
    public boolean removeItem(Item item) {
        if(items.contains(item)) {
            items.remove(item);
            counter--;
            return true;
        }
        return false;
    }
    //item count
    public int itemCount() {
        return counter;
    }
    //price total
    public long totalPrice(){
        long sum=0;
        for (Item a : items){
            sum+=a.getPrice();
        }
        return sum;
    }
    //printing the array of items
    public String toString() {
        System.out.println("Panier "+this.getID()+" : ["+this.itemCount()+ " Article(s)]");
        for (Item a : items){
           System.out.println(a.toString());
        }
       return "";
    }
    //testing in the main
    public static void main(String[] args) {
        PanierArticles c1 = new PanierArticles();
        System.out.println(c1.getID());         // affiche: 1
        Item item1 = new Item("corn flakes", 501, 1000);
        c1.addItem(item1);
        Item item2 = new Item("caviar", 50000, 500);
        c1.addItem(item2);
        System.out.println(c1.getID());         // affiche: 1
        PanierArticles c2 = new PanierArticles();
        PanierArticles c3 = new PanierArticles();
        Item item3 = new Item("water", 500, 500);
        c3.addItem(item3);
        System.out.println(c2.getID());         // affiche: 2 => it doesnt show 2
        System.out.println(c3.getID());         // affiche: 3
        System.out.println(c1); // affiche: panier 1 [2 article(s)]
        //            corn flakes: 5.01 MAD
        //            caviar: 500.00 MAD

        System.out.println(c2); // affiche: panier 2 [0 article(s)]

        System.out.println(c3); // affiche: panier 3 [1 article(s)]
        //            water: 5.00 MAD

    }
}
