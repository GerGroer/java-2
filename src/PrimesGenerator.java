import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int found = 0;
            private int current = 1;

            @Override
            public boolean hasNext() {
                return found < count;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                while (true) {
                    current++;
                    if (isPrime(current)) {
                        found++;
                        return current;
                    }
                }
            }

            private boolean isPrime(int n) {
                if (n < 2) return false;
                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0) return false;
                }
                return true;
            }
        };
    }
}