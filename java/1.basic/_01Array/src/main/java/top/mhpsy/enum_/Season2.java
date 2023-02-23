package top.mhpsy.enum_;

public class Season2 {
    public static void main(String[] args) {
        System.out.println(SEA2.SPRING);
        System.out.println(SEA2.SUMMER);
        System.out.println(SEA2.AUTUMN);
        System.out.println(SEA2.WINTER);
    }
}

enum SEA2 {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");


    private String name;
    private String desc;

    private SEA2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

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
        return "SEA2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
