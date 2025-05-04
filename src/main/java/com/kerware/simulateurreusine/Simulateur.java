public class Simulateur {
    public static double simuler(RevenuInfos infos) {
        ValidationParametres.valider(infos);
        int nbParts = CalculPartsFiscales.calculer(infos);
        infos.setNbParts(nbParts);
        double revenuImposable = CalculRevenuImposable.calculer(infos.getRevenus(), nbParts);
        double impotBrut = CalculImpotBrut.calculer(revenuImposable) * nbParts;
        double decote = CalculDecote.calculer(impotBrut, infos.getSituation());
        double cehr = CalculCEHR.calculer(infos.getRevenus(), infos.getSituation());

        return Math.max(0, impotBrut - decote + cehr);
    }
}