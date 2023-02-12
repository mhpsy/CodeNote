package top.mhpsy.OTest;

import java.util.Scanner;

public class guessFist {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Game game = new Game(computer, player);
        game.start();
    }
}

//猜拳游戏
class Game {
    Computer computer;
    Player player;
    String[] result = new String[3];

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        for (int i = 0; i < result.length; i++) {
            computer.random();
            player.guess();
            showSmallResult();
            result[i] = "第" + (i + 1) + "局：" +
                    "你出的是：" + translation(player.guess) +
                    "电脑出的是：" + translation(computer.random) +
                    "结果是：" + getResult();
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String translation(int num) {
        return switch (num) {
            case 1 -> "剪刀";
            case 2 -> "石头";
            case 3 -> "布";
            default -> "";
        };
    }

    public void showSmallResult() {
        System.out.print("电脑出的是：" + translation(computer.random) + '\t');
        System.out.print("你出的是：" + translation(player.guess) + '\t');
        System.out.print("结果是：" + getResult() + '\n');
    }

    public String getResult() {
        if (this.computer.random == this.player.guess) {
            return "平局";
        } else if (this.computer.random == 1 && this.player.guess == 2) {
            return "你赢了";
        } else if (this.computer.random == 2 && this.player.guess == 3) {
            return "你赢了";
        } else if (this.computer.random == 3 && this.player.guess == 1) {
            return "你赢了";
        }
        return "你输了";
    }

}

class Computer {
    int random;

    //生成随机数1~3
    public int random() {
        this.random = (int) (Math.random() * 3);
        return this.random;
    }
}

class Player {
    int guess;

    public int guess() {
        System.out.println("请输入你的猜拳结果：1.剪刀 2.石头 3.布");
        this.guess = new Scanner(System.in).nextInt();
        return this.guess;
    }
}
