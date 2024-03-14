import java.util.Scanner;

public class CreneauHoraire {
        private int num_jour;
        private int heur_debut;
        private int minute_debut;
        private int duree_munite;

        public CreneauHoraire(){}
        public  CreneauHoraire(int num_jour, int heure_debut, int minute_debut, int duree_munite){
            this.num_jour = num_jour;
            this.heur_debut = heure_debut;
            this.minute_debut = minute_debut;
            this.duree_munite = duree_munite;
        }
        public boolean equals(Object objet){
            if (this == objet) {
                return true;
            }
            if (objet == null ) {
                return false;
            }
            if((objet instanceof CreneauHoraire) &&  this.num_jour == ((CreneauHoraire) objet).num_jour
                                                    && this.heur_debut == ((CreneauHoraire) objet).heur_debut
                                                      && this.minute_debut == ((CreneauHoraire) objet).minute_debut
                                                        && this.duree_munite == ((CreneauHoraire) objet).duree_munite){
                return true;
            }
            return false;
        }

        public static CreneauHoraire affiche(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Donnez le numero du jour");
            int num_j = scanner.nextInt();
            System.out.println("Donnez l'heur de debut");
            int heur_d = scanner.nextInt();
            System.out.println("Donnez minute de de debut");
            int minute_d = scanner.nextInt();
            System.out.println("Donnez la durer du minute");
            int durer_m = scanner.nextInt();
            return new CreneauHoraire(num_j,heur_d,minute_d,durer_m);
        }

    @Override
    public CreneauHoraire clone() {
        return new CreneauHoraire(this.num_jour, this.heur_debut, this.minute_debut, this.duree_munite);
    }


}
