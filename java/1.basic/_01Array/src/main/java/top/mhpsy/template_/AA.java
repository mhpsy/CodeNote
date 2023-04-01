package top.mhpsy.template_;

public class AA extends Template {

    @Override
    public void doSomething() {
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println("AA: " + sum);
    }
}
