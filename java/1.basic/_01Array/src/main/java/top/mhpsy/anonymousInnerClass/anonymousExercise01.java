package top.mhpsy.anonymousInnerClass;

public class anonymousExercise01 {
    public static void main(String[] args) {

        f1(new Iron2() {
            @Override
            public void m1() {
                System.out.println("iron m1");
            }
        });

    }

    public static void f1(Iron2 iron) {
        iron.m1();
    }
}

interface Iron2 {
    public void m1();
}