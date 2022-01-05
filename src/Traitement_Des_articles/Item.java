package Traitement_Des_articles;

public class Item {
private final String name;
private final long price;
private final int weight;
//constructor  with arguments
    public Item(String name, long price, int weight) {
        this.price = price;
        this.name =name;
        this.weight = weight;
    }
//constructor of copy
    public Item(Item a) {
        this.price = a.price;
        this.name =a.name;
        this.weight = a.weight;
    }
//override the println methode to print only objects we want
@Override
public String toString() {
       return name +" : "+price +" : "+weight;
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
        Item item = new Item("corn flakes", 500, 1000);
        System.out.println(item);           // affiche: corn flakes: 5.00 MAD
        Item chewingGum = new Item("chewing gum",403,500);
        System.out.println(chewingGum);    // affiche: chewing gum: 4.03 MAD
    }
}
