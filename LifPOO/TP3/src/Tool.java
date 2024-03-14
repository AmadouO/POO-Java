public class Tool {
    public Tool(){}
    public int monRandom(int max, int min){

        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
