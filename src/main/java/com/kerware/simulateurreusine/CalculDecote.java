package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculDecote {
    public static double calculer(double impot, SituationFamiliale situation) {
        double seuil;
        double maxDecote;
        
        switch (situation) {
	        case CELIBATAIRE:
	        case DIVORCE:
	        case VEUF:
	            seuil = 1852;
	            maxDecote = 833;
	            break;
	        case PACSE:
	        case MARIE:
	            seuil = 3059;
	            maxDecote = 1386;
	            break;
	        default:
	            throw new IllegalArgumentException("Situation familiale inconnue : " + situation);
	    }

        if (impot <= seuil) {
            return Math.min(maxDecote, seuil - impot);
        }
        return 0;
    }
}