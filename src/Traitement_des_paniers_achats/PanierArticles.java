package Traitement_des_paniers_achats;
// Importing required classes

import Traitement_Des_articles.Item;
import Traitement_des_produits_frais.FreshItem;

import java.util.ArrayList;
import java.util.List;

public class PanierArticles {
    //creating a array to add items in it
    private List<Item> items = new ArrayList<Item>();
    //how many items they exist
    private  int counter = 0;
    //to give it to the ID
    public static int a=0;
    private int ID;
    //default constructor
    //creating a panier equals giving the id aka the number of the panier
    // and incrementing the number of panier that exists in the System
    public PanierArticles() {
        a++;
        ID=a;
    }
    //add to the collection of itens to panierArticles
    public void addItem(Item item) {
        if (item.getWeight()>1000)
            //if the weight is supperior we gonna throw an exception
            throw new IllegalStateException("Weight superior to 10 kgs");
        else {
            //unless its no so we just add it and increment the counter
            this.items.add(item);
            counter++;
        }
    }
    //getter ID
    public int getID() { return ID; }
    //removeItem
    //we using methodes that already exist in the collection of java objects
    //giving true or false to the remove method if true it means it got removed if not false
    public boolean removeItem(Item item) {
        if(items.contains(item)) {
            items.remove(item);
            counter--;
            return true;
        }
        return false;
    }
    //item count
    //displays the number of items
    public int itemCount() {
        return counter;
    }
    //price total
    //the price in total for the whole panierArticles
    public long totalPrice(){
        long sum=0;
        for (Item a : items){
            sum+=a.getPrice();
        }
        return sum;
    }
    //displaying the array of items
    public String toString() {
        System.out.println("Panier "+this.getID()+" : ["+this.itemCount()+ " Article(s)]");
        for (Item a : items){
           System.out.println(a.toString());
        }
       return "";
    }
    //testing in the main
    public static void main(String[] args) {
        Item tin = new Item("sardine", 500, 500);
        FreshItem fresh = new FreshItem("sardine", 500, 500, "2012-04-11");
        PanierArticles panier = new PanierArticles();
        panier.addItem(fresh);
        panier.removeItem(tin);
        System.out.println(panier); // affiche: panier 1 [1 article(s)]
        //         BBD: 2012-04-11 sardine: 5.00 MAD

    }
}
