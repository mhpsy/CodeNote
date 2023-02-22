package top.mhpsy.interface_;

public class interfaceRun {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.link(new Camera());
        computer.link(new Phone());
        /**
         * 相机开始工作
         * 电脑工作
         * 相机停止工作
         * 手机开始工作
         * 电脑工作
         * 手机停止工作
         */
    }
}
