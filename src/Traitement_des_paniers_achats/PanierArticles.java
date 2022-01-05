package Traitement_des_paniers_achats;

// Importing required classes

import Traitement_Des_articles.Item;
import java.util.ArrayList;
import java.util.List;

public class PanierArticles {
    private List<Item> items = new ArrayList<Item>();
    private  int counter = 0;
    //add to the collection of itens to panierArticles
    public void addItem(Item item) {
        if (item.getWeight()>1000)
            throw new IllegalStateException("Weight superior to 10 kgs");
        else {
            this.items.add(item);
            counter++;
        }
    }
    public boolean removeItem(Item item) {
        if(items.contains(item)) {
            items.remove(item);
            counter--;
            return true;
        }
        return false;
    }
    public int itemCount() {
        return counter;
    }
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
        PanierArticles panier = new PanierArticles();
        Item item = new Item("corn flakes", 500,1000);
        panier.addItem(item);
        System.out.println(panier);
        panier.removeItem(item);
        System.out.println(panier.itemCount());       // affiche: 0
    }
}
