package Traitement_des_factures;

public interface Payable  {
     String label();
     long cost();
    double taxRatePerTenThousand();

}
