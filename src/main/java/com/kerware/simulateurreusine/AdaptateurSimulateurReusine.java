package com.kerware.simulateurreusine;

import com.kerware.simulateur.ICalculateurImpot;
import com.kerware.simulateur.SituationFamiliale;

public class AdaptateurSimulateurReusine implements ICalculateurImpot {

    private int revenusNetDeclarant1;
    private int revenusNetDeclarant2;
    private SituationFamiliale situationFamiliale;
    private int nbEnfantsACharge;
    private int nbEnfantsSituationHandicap;
    private boolean parentIsole;
    private double impotSurRevenuNet;

    @Override
    public void setRevenusNetDeclarant1(int rn) {
        this.revenusNetDeclarant1 = rn;
    }

    @Override
    public void setRevenusNetDeclarant2(int rn) {
        this.revenusNetDeclarant2 = rn;
    }

    @Override
    public void setSituationFamiliale(SituationFamiliale sf) {
        this.situationFamiliale = sf;
    }

    @Override
    public void setNbEnfantsACharge(int nbe) {
        this.nbEnfantsACharge = nbe;
    }

    @Override
    public void setNbEnfantsSituationHandicap(int nbesh) {
        this.nbEnfantsSituationHandicap = nbesh;
    }

    @Override
    public void setParentIsole(boolean pi) {
        this.parentIsole = pi;
    }

    @Override
    public void calculImpotSurRevenuNet() {
        double revenusTotaux = revenusNetDeclarant1 + revenusNetDeclarant2;
        RevenuInfos infos = new RevenuInfos(revenusTotaux, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        this.impotSurRevenuNet = Simulateur.simuler(infos);
    }

    @Override
    public int getRevenuNetDeclatant1() {
        return revenusNetDeclarant1;
    }

    @Override
    public int getRevenuNetDeclatant2() {
        return revenusNetDeclarant2;
    }

    @Override
    public double getContribExceptionnelle() {
        double revenusTotaux = revenusNetDeclarant1 + revenusNetDeclarant2;
        return CalculCEHR.calculer(revenusTotaux, situationFamiliale);
    }

    @Override
    public int getRevenuFiscalReference() {
        return revenusNetDeclarant1 + revenusNetDeclarant2;
    }

    @Override
    public int getAbattement() {
        double revenusTotaux = revenusNetDeclarant1 + revenusNetDeclarant2;
        RevenuInfos infos = new RevenuInfos(revenusTotaux, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        return (int) CalculAbattement.calculer(infos);
    }

    @Override
    public double getNbPartsFoyerFiscal() {
        RevenuInfos infos = new RevenuInfos(revenusNetDeclarant1 + revenusNetDeclarant2, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        return CalculPartsFiscales.calculer(infos);
    }

    @Override
    public int getImpotAvantDecote() {
        double revenusTotaux = revenusNetDeclarant1 + revenusNetDeclarant2;
        RevenuInfos infos = new RevenuInfos(revenusTotaux, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        int nbParts = CalculPartsFiscales.calculer(infos);
        double abattement = CalculAbattement.calculer(infos);
        double revenuImposable = CalculRevenuImposable.calculer(revenusTotaux, nbParts, abattement);
        return (int) (CalculImpotBrut.calculer(revenuImposable) * nbParts);
    }

    @Override
    public int getDecote() {
        double revenusTotaux = revenusNetDeclarant1 + revenusNetDeclarant2;
        RevenuInfos infos = new RevenuInfos(revenusTotaux, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        int nbParts = CalculPartsFiscales.calculer(infos);
        double abattement = CalculAbattement.calculer(infos);
        double revenuImposable = CalculRevenuImposable.calculer(revenusTotaux, nbParts, abattement);
        double impotBrut = CalculImpotBrut.calculer(revenuImposable) * nbParts;
        return (int) CalculDecote.calculer(impotBrut, situationFamiliale);
    }

    @Override
    public int getImpotSurRevenuNet() {
        return (int) impotSurRevenuNet;
    }
}
