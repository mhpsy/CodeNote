package top.mhpsy.Collection_.Collections_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("all")
public class ListBubbling {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Car("BWM", 200000));
        list.add(new Car("Benz", 300000));
        list.add(new Car("Audi", 100000));
        list.add(new Car("RR", 40000000));
        System.out.println(list);
        bubbling(list);
        System.out.println(list);


    }

    public static void bubbling(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Car c1 = (Car) list.get(j);
                Car c2 = (Car) list.get(j + 1);
                if (c1.getPrice() > c2.getPrice()) {
                    list.set(j, c2);
                    list.set(j + 1, c1);
                }
            }
        }
    }
}

class Car {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
