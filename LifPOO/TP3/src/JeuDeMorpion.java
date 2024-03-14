public class JeuDeMorpion {
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;

    public JeuDeMorpion(Joueur _joueur1, Joueur _joueur2){
        this.plateau = new Plateau(3,3);
        this.joueur1 = _joueur1;
        this.joueur2 = _joueur2;

    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public boolean partiTerminer(){
        for (int i = 0; i < plateau.longeur; i++){
            for (int j = 0; j < plateau.largeur; j++){
                if (plateau.etatIdPlateau[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public Joueur getJoueurSuivant() {
        return joueur1;
    }
    private Joueur joueurSuivant(){
        if (getJoueurSuivant() == joueur1){
            return joueur1;
        }else {
            return joueur2;
        }
    }



    public boolean coupPossible(Coup coup){

        return plateau.etatIdPlateau[coup.x][coup.y] == 0;
    }

    public Joueur jouerPartie() {
        Joueur retour = null; // utilisé comme variable de parcours,et renvoyé comme étant
// le joueur gagnant
        while (!partiTerminer()) {
            retour = getJoueurSuivant();
            Coup c = retour.getCoup(plateau);
            if (coupPossible(c))
                plateau.appliquerCoup(c,retour.getId());
            else
                System.err.print("erreur ") ;
            System.exit(1) ;
        }
        return retour;
    }
}
