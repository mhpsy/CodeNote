package top.mhpsy.innerClass_;

public class innerClassNew {
    public static void main(String[] args) {
        outerClass01.innerClass01 innerClass01 = new outerClass01().new innerClass01();
        /**
         * 这里的innerClass01是一个对象，这个对象是outerClass01的一个内部类
         */
        innerClass01.m1();
        outerClass01.innerClass01 innerClass011 = new outerClass01().getInnerClass01();
        innerClass011.m1();

    }
}

class outerClass01 {
    private String name = "outerClass is name ";
    private int n = 1;

    public void m1() {
        System.out.println("outerClass m1 " + name + " " + n);
    }

    class innerClass01 {
        public void m1() {
            System.out.println("innerClass m1 " + name + " " + n);
        }
    }

    public innerClass01 getInnerClass01() {
        return new innerClass01();
    }

}
