public class SimulateurDeMorpion {

    public static void main(String[] args) {
        Plateau plateau = new Plateau(3,3);
        plateau.initialiser();
        System.out.println(plateau.toString());

    }
}
