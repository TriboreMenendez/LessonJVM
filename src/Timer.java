import java.util.Date;

public class Timer {

    //ежесекундный таймер
    public synchronized void oneSec () {
        System.out.println(Main.x);
        if (Main.x%5 == 0 || Main.x%7 == 0){
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        Main.x++;
        if (Main.x == Main.time) notify();
    }

    //таймер 7 секунд
    public synchronized void sevenSec () {
        if (Main.x%7 == 0) {
            System.out.println("Прошло 7 секунд");
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (Main.x == Main.time) notify();
    }

    //таймер 5 секунд
    public synchronized void fiveSec () {
        if (Main.x%5 == 0) {
            System.out.println("Прошло 5 секунд");
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (Main.x == Main.time) notify();
    }
}
