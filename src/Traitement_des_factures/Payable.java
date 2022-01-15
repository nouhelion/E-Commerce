package Traitement_des_factures;
//interface we going to use to charge people for the items they be using
//we created the interface so we can override the methods in the interface to the classes that they going to use it
public interface Payable  {
     String label();//name of the item
     long cost();//how much it costed
    long taxRatePerTenThousand();//taxe of each item

}
