package top.mhpsy.anonymousInnerClass;

public class anonymousInner1 {
    public static void main(String[] args) {
        Animal Anonymous = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat");
            }
        };
        Anonymous.eat();
        System.out.println(Anonymous.getClass());
        System.out.println(Anonymous.getClass().getName());
        //class top.mhpsy.anonymousInnerClass.anonymousInner1$1
        //top.mhpsy.anonymousInnerClass.anonymousInner1$1
        iron ironMan = new iron("iron") {
            @Override
            public void m1() {
                System.out.println("iron m1");
            }
        };
        System.out.println(ironMan.getName());
        ironMan.m1();
        System.out.println(ironMan.getClass());
        System.out.println(ironMan.getClass().getName());
        //class top.mhpsy.anonymousInnerClass.anonymousInner1$2
        //top.mhpsy.anonymousInnerClass.anonymousInner1$2
    }
}

interface Animal {
    public void eat();
}

class iron {
    private String name;

    public iron(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void m1() {
        System.out.println("iron m1");
    }
}
