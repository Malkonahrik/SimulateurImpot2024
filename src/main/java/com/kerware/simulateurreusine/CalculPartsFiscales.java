public class CalculPartsFiscales {
    public static int calculer(RevenuInfos infos) {
        int parts = (infos.getSituation() == SituationFamiliale.CELIBATAIRE) ? 1 : 2;
        int enfants = infos.getNbEnfants();

        if (enfants <= 2) {
            parts += enfants * 0.5;
        } else {
            parts += (2 * 0.5) + (enfants - 2);
        }
        return parts;
    }
}