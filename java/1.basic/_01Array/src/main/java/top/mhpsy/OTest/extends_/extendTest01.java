package top.mhpsy.OTest.extends_;

public class extendTest01 {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.name);
    }
}

class GrandFather {
    String name = "GrandFather";
}

class Father extends GrandFather {
    String name = "Father";
}

class Son extends Father {
    String name = "Son";
}
