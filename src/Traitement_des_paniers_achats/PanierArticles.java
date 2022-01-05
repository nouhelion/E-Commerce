package Traitement_des_paniers_achats;

// Importing required classes

import Traitement_Des_articles.Item;
import java.util.ArrayList;
import java.util.List;

public class PanierArticles {
    private List<Item> items = new ArrayList<Item>();
    private  int counter = 0;
    public static int ID;
    //default constructor
    public PanierArticles() {
        ID++;
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
    public int getID() { return this.ID; }
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
        int i=1;
        for (Item a : items){
           System.out.println(i+"/ "+a.toString());
           i++;
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

    }
}
