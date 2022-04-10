import java.util.ArrayList;

public class TaskOneMain {

    public static void main(String[] args) {
        ArrayList<TaskOne> t = new ArrayList<>();
        t.add(new TaskOne(182, 70));
        t.add(new TaskOne(192, 98));
        t.add(new TaskOne(180, 33));
        t.add(new TaskOne(164, 55));
        t.sort((TaskOne t1, TaskOne t2) -> {
            double div = 0.01;
            return Double.compare(t1.getWeight() / ((t1.getGrowth() * t1.getGrowth()) / div), t2.getWeight() / ((t2.getGrowth() * t2.getGrowth()) / div));
        });

        System.out.println(t);


    }
}
