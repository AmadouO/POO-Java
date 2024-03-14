public  class Plateau {
    public int longeur;
    public int largeur;
    public int[][] etatIdPlateau;

    public Plateau(int _longeur, int _largeur){
        this.longeur = _longeur;
        this.largeur = _largeur;
        this.etatIdPlateau = new int[longeur][largeur];
    }
    public void initialiser(){
        for(int i = 0; i < longeur; i++){
            for (int j = 0; j < largeur; j++){
                etatIdPlateau[i][j] = 0;
            }
        }

    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongeur() {
        return longeur;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }

    public void appliquerCoup(Coup coup, int id){
        try {
            etatIdPlateau[coup.x][coup.y] = id;
        }catch (Exception e){
            System.out.println("erreur");
        }

    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < longeur; i++){
            for (int j = 0; j < largeur; j++){
                res.append(etatIdPlateau[i][j]).append(" ");
            }
            res.append("\n");
        }
        return res.toString();

    }
}
