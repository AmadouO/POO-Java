import java.util.Scanner;
public class JoueurHumain extends Joueur{
    private Scanner scanner;
    public JoueurHumain(int _id){
        super(_id);
        scanner = new Scanner(System.in);
    }

    @Override
    public Coup getCoup(Plateau _etatJeu) {
        System.out.println("joueur"+getId()+"veuillez saisire les coordonnées de votre prochaine coup");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new Coup(x,y);
    }

}
