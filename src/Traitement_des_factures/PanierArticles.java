package Traitement_des_factures;

// Importing required classes
import Traitement_Des_articles.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanierArticles {
   private List<Item> items = new ArrayList<Item>();
   private static int counter = 0;
   //add to the collection of itens to panierArticles
    public void addItem(Item item) {
        if(item.getWeight()<=1000){
            this.items.add(item);
            counter++;
        }
    }
    public boolean removeItem(Item item) {
            if(items.contains(item)) {
                this.items.remove(item);
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
}
