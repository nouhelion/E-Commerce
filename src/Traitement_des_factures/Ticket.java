package Traitement_des_factures;

public class Ticket implements Payable{
    private String reference;
    private long price;
    //default constructor
    public Ticket() {
    }
    @Override
    public String label() {
        return this.getReference();
    }
    @Override
    public long cost() {
        return this.getPrice();
    }
    @Override
    public double taxRatePerTenThousand() {
        long p= this.getPrice();
        return p*0.25;
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
