package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculCEHR {
	public static double calculer(double revenus, SituationFamiliale situation) {
        if (revenus < 0) {
            throw new IllegalArgumentException("Les revenus ne peuvent pas être négatifs.");
        }

        double seuil;
        switch (situation) {
            case CELIBATAIRE:
            case DIVORCE:
            case VEUF:
                seuil = 250000;
                break;
            case PACSE:
            case MARIE:
                seuil = 500000;
                break;
            default:
                throw new IllegalArgumentException("Situation familiale inconnue : " + situation);
        }

        double taux = (revenus > seuil) ? 0.03 : 0.0;
        return revenus * taux;
    }
}