package com.kerware.simulateurreusine;

public class CalculImpotBrut {
    private static final double[] SEUILS = { 10777, 27478, 78570, 168994 };
    private static final double[] TAUXS = { 0.0, 0.11, 0.30, 0.41, 0.45 };

    public static double calculer(double revenuImposable) {
        double impot = 0;
        double revenuRestant = revenuImposable;

        for (int i = SEUILS.length; i >= 0; i--) {
            double seuil = (i == 0) ? 0 : SEUILS[i - 1];
            if (revenuImposable > seuil) {
                double montant = revenuRestant - seuil;
                impot += montant * TAUXS[i];
                revenuRestant = seuil;
            }
        }
        return impot;
    }
}