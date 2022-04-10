import java.util.*;

public class TaskTwoMain {

    public static void main(String[] args) {

        List<TaskTwo> people = new ArrayList<>();

        HashMap<String, Integer> frst = new HashMap<>();
        frst.put("eqw", 6);
        frst.put("rew", 5);
        HashMap<String, Integer> two = new HashMap<>();
        two.put("sfd", 10);
        two.put("dsa", 9);
        HashMap<String, Integer> three = new HashMap<>();
        three.put("gfd", 6);
        three.put("das", 7);
        HashMap<String, Integer> four = new HashMap<>();
        four.put("qwe", 9);
        four.put("dsa", 9);


        people.add(new TaskTwo("John J", new HashMap<>(frst)));
        people.add(new TaskTwo("Set J", new HashMap<>(two)));
        people.add(new TaskTwo("Ket J", new HashMap<>(three)));
        people.add(new TaskTwo("Rob J", new HashMap<>(four)));
        people.sort((o1, o2) -> {
            int first = 0, second = 0, countFirst = 0, countSecond = 0;
            Set<Map.Entry<String, Integer>> entrySet = o1.getMarks().entrySet();
            for (Map.Entry<String, Integer> pair :
                    entrySet) {
                ++countFirst;
                first += pair.getValue();
            }
            Set<Map.Entry<String, Integer>> entrySet2 = o2.getMarks().entrySet();
            for (Map.Entry<String, Integer> pair :
                    entrySet2) {
                ++countSecond;
                second += pair.getValue();
            }
            return Integer.compare(second / countSecond, first / countFirst);
        });

        System.out.println(people);


    }
}
