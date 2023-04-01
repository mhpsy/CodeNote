package top.mhpsy.homework;

public class test001 {
    public static void main(String[] args) {
        new cellPhone().work(new Cal() {
            @Override
            public void work() {
                System.out.println("cal work");
            }
        });
    }
}

interface Cal {
    void work();
}

class cellPhone {
    public void work(Cal cal) {
        cal.work();
        System.out.println("cellPhone work");
    }
}
