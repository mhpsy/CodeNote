package top.mhpsy.interface_;

public class Computer {
    public void link(usbInterface usb) {
        usb.start();
        System.out.println("电脑工作");
        usb.stop();
    }
}
