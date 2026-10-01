import java.util.Objects;

public class Human implements Comparable<Human> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Human other) {
        // Естественный порядок: по фамилии, затем по имени, затем по возрасту
        int cmp = lastName.compareTo(other.lastName);
        if (cmp != 0) return cmp;
        cmp = firstName.compareTo(other.firstName);
        if (cmp != 0) return cmp;
        return Integer.compare(age, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age
                && Objects.equals(firstName, human.firstName)
                && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }
}