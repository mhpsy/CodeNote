package top.mhpsy.generic_;

public class generic_2 {
    public static void main(String[] args) {
        OneMan<String, Integer> oneMan = new OneMan<String, Integer>("name", 120);
        System.out.println(oneMan);
    }
}

class OneMan<T, V> {
    private T t;
    private V v;

    public OneMan(T t, V v) {
        this.t = t;
        this.v = v;
    }

    @Override
    public String toString() {
        return "OneMan{" +
                "t=" + t +
                ", v=" + v +
                '}';
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
