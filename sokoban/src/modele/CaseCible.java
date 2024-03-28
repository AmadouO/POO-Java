package modele;

public class CaseCible extends Case{

    public CaseCible(Jeu _jeu){
        super(_jeu);
    }
    @Override
    public boolean peutEtreParcouru() {
        return e == null;
    }


}
