import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. " +
                "The dog barks, and the fox runs away. Fox, fox!";

        // Приводим к нижнему регистру и разбиваем по не-буквам
        String[] words = text.toLowerCase().split("[^a-z]+");

        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            frequency.merge(word, 1, Integer::sum);
        }

        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> e : frequency.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}