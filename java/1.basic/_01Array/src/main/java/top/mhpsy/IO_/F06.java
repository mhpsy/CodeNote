package top.mhpsy.IO_;

import java.io.*;

public class F06 {
    public static void main(String[] args) {
        F06_1 f06_1 = new F06_1();
        f06_1.m1();
        f06_1.m2();

    }
}

class F06_1 {
    public void m1() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\IO\\dog.dat"));
            objectOutputStream.writeObject(new Dog("旺财", 3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\IO\\dog.dat"));
            Dog dog = (Dog) objectInputStream.readObject();
            System.out.println(dog);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Dog implements java.io.Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


