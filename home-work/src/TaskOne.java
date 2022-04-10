public class TaskOne {

    private int growth;
    private int weight;

    public TaskOne(int growth, int weight) {
        this.growth = growth;
        this.weight = weight;
    }


    public int getGrowth() {
        return growth;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "[growth=" + growth +
                ", weight=" + weight +
                ']';
    }
}
