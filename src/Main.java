import java.io.File;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    static int x = 1;
    static int time = 20;
    static BlockingQueue<String> word;
    static File file = new File("voyna.txt");
    static String searchWord = "страдание";

    public static void main(String[] args) {

        //таймер
        Timer timer = new Timer();
        Timer1sec sec1 = new Timer1sec(timer);
        Message5sec sec5 = new Message5sec(timer);
        Message7sec sec7 = new Message7sec(timer);
        sec1.start();
        sec5.start();
        sec7.start();
        try {
            sec1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //consumer и producer
        word = new LinkedBlockingDeque<String>();
        Scanner scanner = null;

        Producer producer = new Producer();
        Consumer consumer = new Consumer(word);
        producer.start();
        consumer.start();

        try {producer.join();}
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток producer остановлен");

        if (!producer.isInterrupted())
            consumer.interrupt();
    }
}
