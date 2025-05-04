package com.kerware.simulateurreusine;

public class Simulateur {
    public static double simuler(RevenuInfos infos) {
        ValidationParametres.valider(infos);
        int nbParts = CalculPartsFiscales.calculer(infos);
        infos.setNbParts(nbParts);

        double abattement = CalculAbattement.calculer(infos);
        double revenuImposable = CalculRevenuImposable.calculer(infos.getRevenus(), nbParts, abattement);

        double impotBrut = CalculImpotBrut.calculer(revenuImposable) * nbParts;
        double decote = CalculDecote.calculer(impotBrut, infos.getSituation());
        double cehr = CalculCEHR.calculer(infos.getRevenus(), infos.getSituation());

        return Math.max(0, impotBrut - decote + cehr);
    }
}
