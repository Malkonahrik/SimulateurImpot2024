public class ValidationParametres {
    public static void valider(RevenuInfos infos) {
        if (infos.getRevenus() < 0) {
            throw new IllegalArgumentException("Les revenus doivent être positifs.");
        }
        if (infos.getNbEnfants() < 0) {
            throw new IllegalArgumentException("Le nombre d'enfants doit être positif.");
        }
    }
}