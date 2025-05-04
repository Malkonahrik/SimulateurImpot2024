public class CalculDecote {
    public static double calculer(double impot, SituationFamiliale situation) {
        double seuil = (situation == SituationFamiliale.CELIBATAIRE) ? 1852 : 3059;
        double maxDecote = (situation == SituationFamiliale.CELIBATAIRE) ? 833 : 1386;

        if (impot <= seuil) {
            return Math.min(maxDecote, seuil - impot);
        }
        return 0;
    }
}