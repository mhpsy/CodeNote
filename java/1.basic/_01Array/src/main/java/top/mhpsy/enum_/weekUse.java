package top.mhpsy.enum_;

public class weekUse {
    public static void main(String[] args) {
        for (Week value : Week.values()) {
            System.out.println(value);
            System.out.println(value.name());
            System.out.println(value.ordinal());
        }
    }
}
