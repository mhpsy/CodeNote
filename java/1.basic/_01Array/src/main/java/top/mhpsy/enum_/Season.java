package top.mhpsy.enum_;

public class Season {
    public static void main(String[] args) {
        System.out.println(SEA.SPRING);
        System.out.println(SEA.SUMMER);
        System.out.println(SEA.AUTUMN);
        System.out.println(SEA.WINTER);
    }
}

class SEA {
    private String name;
    private String desc;

    private SEA(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static final SEA SPRING = new SEA("春天", "春暖花开");
    public static final SEA SUMMER = new SEA("夏天", "夏日炎炎");
    public static final SEA AUTUMN = new SEA("秋天", "秋高气爽");
    public static final SEA WINTER = new SEA("冬天", "冰天雪地");

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SEA{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
