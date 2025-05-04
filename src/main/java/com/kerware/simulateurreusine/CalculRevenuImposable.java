package com.kerware.simulateurreusine;

public class CalculRevenuImposable {
    public static double calculer(double revenus, int nbParts, double abattement) {
        double revenuApresAbattement = revenus - abattement;
        return revenuApresAbattement / nbParts;
    }
}
