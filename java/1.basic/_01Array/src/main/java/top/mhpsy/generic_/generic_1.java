package top.mhpsy.generic_;

public class generic_1 {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>(new String[10], 10);
        list.setByIndex(0, "java");
        list.setByIndex(1, "c");
        System.out.println(list.getByIndex(0));
        System.out.println(list.getByIndex(1));


        myList1<String> list1 = new myList1<>(new String[10], 10);
        list1.setByIndex(0, "java");
        list1.setByIndex(1, "c");
        System.out.println(list1.getByIndex(0));
        System.out.println(list1.getByIndex(1));


    }
}

class MyList<T> {
    private T[] t;
    private int size;

    public MyList(T[] t, int size) {
        this.t = t;
        this.size = size;
    }

    public T getByIndex(int index) {
        return t[index];
    }

    public void setByIndex(int index, T t) {
        this.t[index] = t;
    }
}

class myList1<T> {
    private T[] t;
    private int size;

    public myList1(T[] t, int size) {
        this.size = size;
        this.t = (T[]) new Object[size];
    }

    public T getByIndex(int index) {
        return t[index];
    }

    public void setByIndex(int index, T t) {
        this.t[index] = t;
    }
}


//class myList<T> {
//    private T[] t;
//    private int size;
//
//    public myList() {
//        t = new T[10];// error 因为T是一个类型，而不是一个对象，所以不能new
//    }
//}