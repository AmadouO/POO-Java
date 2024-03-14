public class Somme {
    public Somme() {
    }

    public int som(int x) {
        int res = 0;
        for (int i = 0; i <= x; i++) {
            res += i;
        }
        return res;
    }
}
