package top.mhpsy.generic_.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test3 {
    public static void main(String[] args) {


    }

    @Test
    public void testDAO() {
        DAO<Customer> customerDAO = new DAO<>();
        customerDAO.save("1001", new Customer("Tom", 18));
        customerDAO.save("1002", new Customer("Jerry", 19));
        customerDAO.save("1003", new Customer("Mike", 20));
        System.out.println(customerDAO.get("1001"));
        customerDAO.update("1001", new Customer("Tom", 20));
        System.out.println(customerDAO.get("1001"));
        customerDAO.delete("1002");
        System.out.println(customerDAO.list());
    }
}

class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }

}

class Customer {
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
