package Traitement_des_produits_frais;
// Importing required classes

import Traitement_Des_articles.Item;
import Traitement_des_factures.Payable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FreshItem extends Item  {
    private String bestBeforeDate;
    //constructor with arguments
    public FreshItem(String name, long price, int weight ,String bestBeforeDate ) {
        super(name, price, weight);
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-DD");
        try
        {
            Date javaDate = sdfrmt.parse(bestBeforeDate);
            this.bestBeforeDate=bestBeforeDate;
        }
        /* Date format is invalid */
        catch (ParseException e)
        {
            System.out.println(bestBeforeDate+" is Invalid Date format");
        }
    }
    //override the tax thing
    @Override
    public double taxRatePerTenThousand() {
       if(super.getWeight()<1000)
           return 1000;
       else
           return 990;
    }
//getter of the date
    public String getBestBeforeDate() { return bestBeforeDate; }
    //printing fresh product stuff
    public String toString() {
            System.out.println("BBD :"+bestBeforeDate+" "+super.toString());
        return "";
    }
    //testing main function
    public static void main(String[] args){
        Item item1 = new Item("corn flakes", 500, 1000);
        System.out.println(item1);     // affiche: corn flakes: 5.00MAD
        FreshItem fresh = new FreshItem("Salmon", 1450, 800, "2012-04-11");
        System.out.println(fresh);     // affiche: BBD:2012-04-11 Salmon: 14.50MAD

    }
}
