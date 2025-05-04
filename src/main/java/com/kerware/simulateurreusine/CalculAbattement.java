package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculAbattement {

    public static double calculer(RevenuInfos infos) {
        double abattement = 0;

        if (infos.getRevenus() < 50000) {
            abattement += 1000; 
        }

        switch (infos.getSituation()) {
            case MARIE:
            case PACSE:
                abattement += 1500;
                break;
            case CELIBATAIRE:
            case DIVORCE:
            case VEUF:
                abattement += 1000; 
                break;
            default:
                break;
        }

        abattement += infos.getNbEnfants() * 500;

        abattement += infos.getNbEnfantsHandicap() * 1000;

        if (infos.isParentIsole()) {
            abattement += 1200;
        }
        return Math.min(abattement, infos.getRevenus());
    }
}
