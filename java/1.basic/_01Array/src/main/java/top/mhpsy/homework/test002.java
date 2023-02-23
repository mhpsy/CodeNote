package top.mhpsy.homework;

public class test002 {
    public static void main(String[] args) {
        isAMan isAMan = new isAMan();
        isAMan.goHome();
        isAMan.drive();
        isAMan.fly();
        isAMan.drive();
        isAMan.fly();
    }

}

class isAMan {
    private final static vehicleFactory vehicleFactory = new vehicleFactory();
    private vehicle vehicle;

    public void goHome() {
        System.out.println("go home");
    }

    public void drive() {
        if (!(vehicle instanceof car)) {
            vehicle = vehicleFactory.getVehicle("car");
        }
        assert vehicle != null;//断言不会为空，因为如果为空vehicle instanceof plane也会getVehicle弄来一个新对象
        vehicle.run();
    }

    public void fly() {
        if (!(vehicle instanceof plane)) {
            vehicle = vehicleFactory.getVehicle("plane");
        }
        assert vehicle != null;//断言不会为空，因为如果为空vehicle instanceof plane也会getVehicle弄来一个新对象
        vehicle.run();
    }
}

class vehicleFactory {
    private static final car car = new car();//饿汉式单例模式

    public vehicleFactory() {
    }

    public vehicle getVehicle(String type) {
        if ("car".equals(type)) {
            return car;
        } else if ("plane".equals(type)) {
            return new plane();
        } else {
            return null;
        }
    }
}

interface vehicle {
    void run();
}

class car implements vehicle {
    @Override
    public void run() {
        System.out.println("car run");
    }
}

class plane implements vehicle {
    @Override
    public void run() {
        System.out.println("plane run");
    }
}
