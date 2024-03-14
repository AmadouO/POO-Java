//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CreneauHoraire c1 = new CreneauHoraire(87, 10,00,1);
        CreneauHoraire c2 = new CreneauHoraire(87, 10,00,1);

        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2) );
        System.out.println(c1.equals(c2) );
        c2.affiche();
        c2.clone();

    }
}