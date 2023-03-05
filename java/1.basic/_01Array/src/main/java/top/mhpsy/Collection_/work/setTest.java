package top.mhpsy.Collection_.work;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class setTest {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Person a = new Person(1, "a");
        Person b = new Person(2, "b");
        people.add(a);
        people.add(b);
        a.setName("c");
        System.out.println(people.contains(a));//false
        System.out.println(people);//[Person{id=1, name='c'}, Person{id=2, name='b'}]
        people.remove(a);
        System.out.println(people);//[Person{id=1, name='c'}, Person{id=2, name='b'}]
        people.add(new Person(1, "c"));
        System.out.println(people);//[Person{id=1, name='c'}, Person{id=2, name='b'}, Person{id=1, name='c'}]
        people.add(new Person(1, "a"));
        System.out.println(people);//[Person{id=1, name='c'}, Person{id=2, name='b'}, Person{id=1, name='c'}, Person{id=1, name='a'}]
    }
}

class Person {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
