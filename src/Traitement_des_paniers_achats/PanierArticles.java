package Traitement_des_paniers_achats;

// Importing required classes

import Traitement_Des_articles.Item;
import java.util.ArrayList;
import java.util.List;

public class PanierArticles {
    private List<Item> items = new ArrayList<Item>();
    private static int counter = 0;
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
    //testing in the main
    public static void main(String[] args) {
        Item item1 = new Item("corn flakes", 501, 1000);
        Item item2 = new Item("caviar", 50000, 500);
        Item item3 = new Item("water", 500, 5000);
        PanierArticles panier = new PanierArticles();
        panier.addItem(item1);
        panier.addItem(item2);
        panier.addItem(item3);
        panier.addItem(item3);     // lève java.lang.IllegalStateException
        panier.removeItem(new Item("eau", 500, 5000));
        panier.addItem(item3);     // lève java.lang.IllegalStateException
        panier.removeItem(new Item("water", 500, 5000));
        panier.addItem(item3);        // ajout possible!
        System.out.println(panier.itemCount());

    }
}
