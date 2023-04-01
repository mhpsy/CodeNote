package top.mhpsy.homework;

public class test003 {
    public static void main(String[] args) {
        Car1 car = new Car1(20);
        car.getAir().flow();
        new Car1(18).getAir().flow();
        new Car1(22).getAir().flow();
    }
}

class Car1 {
    private final double temperature;

    public Car1(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 20) {
                System.out.println("冷气");
            } else if (temperature < 20) {
                System.out.println("暖气");
            } else {
                System.out.println("关机");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}
