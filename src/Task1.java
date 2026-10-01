import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int N = 20;
        Random random = new Random();

        // 1. Массив из N случайных чисел от 0 до 100
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("1. Массив: " + Arrays.toString(array));

        // 2. Список на основе массива
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("2. Список: " + list);

        // 3. Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("3. По возрастанию: " + list);

        // 4. Сортировка в обратном порядке
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("4. По убыванию: " + list);

        // 5. Перемешивание
        Collections.shuffle(list);
        System.out.println("5. Перемешанный: " + list);

        // 6. Циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. Сдвиг на 1: " + list);

        // 7. Только уникальные элементы
        Set<Integer> unique = new LinkedHashSet<>(list);
        System.out.println("7. Уникальные: " + unique);

        // 8. Только дублирующиеся элементы
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer x : list) {
            counts.merge(x, 1, Integer::sum);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue() > 1) {
                duplicates.add(e.getKey());
            }
        }
        System.out.println("8. Дублирующиеся: " + duplicates);

        // 9. Массив из списка
        Integer[] backToArray = list.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(backToArray));

        // 10. Количество вхождений каждого числа
        System.out.println("10. Частота вхождений:");
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            System.out.println("   " + e.getKey() + " -> " + e.getValue());
        }
    }
}