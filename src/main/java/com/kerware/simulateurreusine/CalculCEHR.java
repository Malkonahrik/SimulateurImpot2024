public class CalculCEHR {
    public static double calculer(double revenus, SituationFamiliale situation) {
        double seuil = (situation == SituationFamiliale.CELIBATAIRE) ? 250000 : 500000;
        double taux = (revenus > seuil) ? 0.03 : 0.0;
        return revenus * taux;
    }
}