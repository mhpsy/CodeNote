package top.mhpsy.ref;

public class Cat {
    private static final String TAG = "Cat";
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    public void eat() {
        System.out.println("Cat eat");
    }

    private void eat(int i) {
        System.out.println("Cat eat" + i);
    }

    private void eat(String food) {
        System.out.println("Cat eat " + food);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
