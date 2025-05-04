package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class CalculPartsFiscales {
    public static int calculer(RevenuInfos infos) {
        if (infos == null) {
            throw new IllegalArgumentException("Les informations de revenu ne peuvent pas être nulles.");
        }

        int parts;
        switch (infos.getSituation()) {
            case CELIBATAIRE:
            case DIVORCE:
            case VEUF:
                parts = 1;
                break;
            case PACSE:
            case MARIE:
                parts = 2;
                break;
            default:
                throw new IllegalArgumentException("Situation familiale inconnue : " + infos.getSituation());
        }

        int enfants = infos.getNbEnfants();
        if (enfants < 0) {
            throw new IllegalArgumentException("Le nombre d'enfants ne peut pas être négatif.");
        }

        if (enfants <= 2) {
            parts += enfants * 0.5;
        } else {
            parts += (2 * 0.5) + (enfants - 2);
        }

        parts += infos.getNbEnfantsHandicap();

        if (infos.isParentIsole()) {
            parts += 1;
        }

        return parts;
    }
}
