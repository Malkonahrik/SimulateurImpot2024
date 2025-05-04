package com.kerware.simulateurreusine;

import com.kerware.simulateur.SituationFamiliale;

public class RevenuInfos {
    private double revenus;
    private int nbParts;
    private SituationFamiliale situation;
    private int nbEnfants;
    private int nbEnfantsHandicap;
    private boolean parentIsole;

    public RevenuInfos(double revenus, SituationFamiliale situation, int nbEnfants, int nbEnfantsHandicap, boolean parentIsole) {
        this.revenus = revenus;
        this.situation = situation;
        this.nbEnfants = nbEnfants;
        this.nbEnfantsHandicap = nbEnfantsHandicap;
        this.parentIsole = parentIsole;
    }

    public double getRevenus() {
        return revenus;
    }

    public int getNbParts() {
        return nbParts;
    }

    public SituationFamiliale getSituation() {
        return situation;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public int getNbEnfantsHandicap() {
        return nbEnfantsHandicap;
    }

    public boolean isParentIsole() {
        return parentIsole;
    }

    public void setNbParts(int nbParts) {
        this.nbParts = nbParts;
    }
}
