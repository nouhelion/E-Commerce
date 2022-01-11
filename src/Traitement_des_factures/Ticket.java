package Traitement_des_factures;

public class Ticket implements Payable{
    private String reference;
    private long price;
    @Override
    public String label() {
        return this.getReference();
    }
    @Override
    public long cost() {
        return this.getPrice();
    }
    @Override
    public long taxRatePerTenThousand() {
        return 2500;
    }
    //present the tickets
    public String toString() {
        return reference +", " + price ;
    }

    //constructor with arguments
    public Ticket(String reference,long price) {
        this.reference = reference;
        this.price = price;
    }
    public String getReference() { return reference; }
    public long getPrice() { return price; }
    public static void main(String[] args){
        Payable payable = new Ticket("RGBY17032012 - Walles-France", 9000);
        System.out.println(payable.label()); // affiche: RGBY17032012 - Walles-France
        System.out.println(payable.cost()); // affiche: 9000
        System.out.println(payable.taxRatePerTenThousand());  // affiche: 2500

    }


}
