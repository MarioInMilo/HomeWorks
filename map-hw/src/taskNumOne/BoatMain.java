package taskNumOne;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BoatMain {
    public static void main(String[] args) {
        HashMap<Integer, String> timeHashMap = new HashMap<>();
        timeHashMap.put(123, "f");
        timeHashMap.put(312, "t");
        timeHashMap.put(234, "s");
        timeHashMap.put(2432, "das");
        Set<Map.Entry<Integer, String>> entrySet = timeHashMap.entrySet();
        for (Map.Entry<Integer, String> entry:
                timeHashMap.entrySet()
             ) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }


    }
}
