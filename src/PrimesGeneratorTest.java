import java.util.ArrayList;
import java.util.List;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10;
        PrimesGenerator generator = new PrimesGenerator(N);

        List<Integer> primes = new ArrayList<>();
        for (Integer p : generator) {
            primes.add(p);
        }

        System.out.println("Прямой порядок:");
        for (Integer p : primes) {
            System.out.print(p + " ");
        }
        System.out.println();

        System.out.println("Обратный порядок:");
        for (int i = primes.size() - 1; i >= 0; i--) {
            System.out.print(primes.get(i) + " ");
        }
        System.out.println();
    }
}