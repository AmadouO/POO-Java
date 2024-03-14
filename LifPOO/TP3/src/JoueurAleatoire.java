import com.sun.jdi.ClassObjectReference;

public class JoueurAleatoire extends Joueur{
    public JoueurAleatoire(int _id){
        super(_id);

    }

    @Override
    public Coup getCoup(Plateau _etatJeu) {
        int longeur = _etatJeu.longeur;
        int largeur = _etatJeu.largeur;

        Tool tool = new Tool();

        while (true) {
            int x = tool.monRandom(0, longeur - 1);
            int y = tool.monRandom(0, largeur - 1);

            if (_etatJeu.etatIdPlateau[x][y] == 0) {
                return new Coup(x, y);
            }
        }
    }
}
