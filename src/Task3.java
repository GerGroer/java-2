import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>(List.of(
                new Human("Иван", "Петров", 30),
                new Human("Анна", "Сидорова", 25),
                new Human("Пётр", "Иванов", 40),
                new Human("Мария", "Петров", 35),
                new Human("Иван", "Петров", 30) // дубликат
        ));

        // HashSet — порядок не гарантирован, дубликаты удаляются
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet:");
        hashSet.forEach(System.out::println);

        // LinkedHashSet — сохраняет порядок вставки, дубликаты удаляются
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\nLinkedHashSet:");
        linkedHashSet.forEach(System.out::println);

        // TreeSet — сортировка по Comparable (фамилия, имя, возраст)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("\nTreeSet (natural order):");
        treeSet.forEach(System.out::println);

        // TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("\nTreeSet (по фамилии):");
        treeSetByLastName.forEach(System.out::println);

        // TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("\nTreeSet (по возрасту):");
        treeSetByAge.forEach(System.out::println);

        /*
         * Различия:
         * - HashSet: не гарантирует порядок, основан на hashCode/equals.
         * - LinkedHashSet: сохраняет порядок вставки, тоже основан на hashCode/equals.
         * - TreeSet: хранит элементы отсортированными, использует Comparable или Comparator.
         *   Если компаратор считает два элемента равными, второй в множество не попадёт.
         */
    }
}