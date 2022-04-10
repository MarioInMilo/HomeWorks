import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class TaskTwo {
    private String fio;
    private Map<String, Integer> marks;

    public TaskTwo(String fio, Map<String, Integer> marks) {
        this.fio = fio;
        this.marks = marks;
    }

    public String getFio() {
        return fio;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "TaskTwo{" +
                "fio='" + fio + '\'' +
                ", marks=" + marks +
                '}';
    }

}
