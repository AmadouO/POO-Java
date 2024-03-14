public abstract class Joueur {
    private int id;
    public Joueur(int _id){
        this.id = _id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public abstract Coup getCoup(Plateau _etatJeu);

}
