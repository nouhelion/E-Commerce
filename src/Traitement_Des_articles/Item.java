package Traitement_Des_articles;

public class Item {
private final String name;
private final long price;
//constructor  with arguments
    public Item(String name,long price) {
        this.price = price;
        this.name =name;
    }
//constructor of copy
    public Item(Item a) {
        this.price = a.price;
        this.name =a.name;
    }

//getter
//no setter since we dont wanna change anything
    public String getName() {
        return name;
    }
    public long getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Item item = new Item("corn flakes", 500);
        System.out.println(item.getPrice());        // affiche: 500
        System.out.println(item.getName());         // affiche: corn flakes

    }
}
