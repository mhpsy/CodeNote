package top.mhpsy.generic_.test;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("java", new MyDate(1999, 1, 1), 10000));
        list.add(new Employee("c", new MyDate(1999, 1, 3), 10000));
        list.add(new Employee("php", new MyDate(1999, 1, 2), 10000));
//        list.sort((Comparator.comparing(Employee::getBirthday)));
        list.sort(((o1, o2) -> {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }));
        System.out.println(list);

    }

}

class Employee {
    private String name;
    private MyDate birthday;
    private double salary;

    public Employee(String name, MyDate birthday, double salary) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}' + '\n';
    }
}

class MyDate implements Comparable<MyDate> {//懒得写getter和setter了
    public int Year;
    public int Month;
    public int Day;

    @Override
    public String toString() {
        return "MyDate{" +
                "Year=" + Year +
                ", Month=" + Month +
                ", Day=" + Day +
                '}';
    }

    public MyDate(int year, int month, int day) {
        Year = year;
        Month = month;
        Day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        if (this.Year != o.Year) {
            return this.Year - o.Year;
        } else if (this.Month != o.Month) {
            return this.Month - o.Month;
        } else {
            return this.Day - o.Day;
        }
    }
}
