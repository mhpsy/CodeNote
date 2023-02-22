package top.mhpsy.innerClass_;

public class localInnerClass {
    public static void main(String[] args) {
        outerClass outerClass = new outerClass();
        outerClass.runOuterClass();
        System.out.println("------------------------------");
        System.out.println(outerClass);
        System.out.println("可以很明显的发现outerClass跟下面在内部类中调用的outerClass.this是同一个对象");
    }
}

class outerClass {
    public int num = 10;
    private final int privateNum = 20;

    public void m1() {
        System.out.println("outerClass m1");
    }

    public void runOuterClass() {
        outerClass_innerClass innerClass = new outerClass_innerClass();
        innerClass.m3();
    }

    class outerClass_innerClass {//这个的本质依然是一个类不是什么很神奇的东西

        public void m2() {
            System.out.println("outerClass_innerClass m2");
        }

        public void m3() {
            m1();
            m2();
            System.out.println("outerClass_innerClass m3 可以直接访问外部类的属性：" + num);
            System.out.println("outerClass_innerClass m3 可以直接访问外部类的属性：privateNum" + privateNum);

            int num = 0;
            System.out.println("------------------------------");
            System.out.println("如果属性重名 " + num);
            System.out.println("如果属性重名 outerClass.this.num " + outerClass.this.num);
            System.out.println("outerClass.this " + outerClass.this);

        }
    }
}
