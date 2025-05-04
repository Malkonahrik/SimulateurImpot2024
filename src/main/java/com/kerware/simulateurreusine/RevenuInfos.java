public class RevenuInfos {
    private double revenus;
    private int nbParts;
    private SituationFamiliale situation;
    private int nbEnfants;

    public RevenuInfos(double revenus, SituationFamiliale situation, int nbEnfants) {
        this.revenus = revenus;
        this.situation = situation;
        this.nbEnfants = nbEnfants;
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

    public void setNbParts(int nbParts) {
        this.nbParts = nbParts;
    }
}