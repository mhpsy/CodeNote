package top.mhpsy.enum_;

public enum Week {
    MON("星期一", 1),
    TUE("星期二", 2),
    WED("星期三", 3),
    THU("星期四", 4),
    FRI("星期五", 5),
    SAT("星期六", 6),
    SUN("星期日", 7);

    private final String name;
    private final int day;

    Week(String name, int day) {
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Week{" +
                "name='" + name + '\'' +
                ", day=" + day +
                '}';
    }
}
