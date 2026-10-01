import java.util.*;

public class Task5 {

    public static <K, V> Map<V, K> invert(Map<K, V> source) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("один", 1);
        original.put("два", 2);
        original.put("три", 3);

        System.out.println("Исходная Map: " + original);

        Map<Integer, String> inverted = invert(original);
        System.out.println("Инвертированная Map: " + inverted);
    }
}