import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    BlockingQueue<String> searchWord;

    public Consumer(BlockingQueue<String> searchWord) {
        this.searchWord = searchWord;
    }

    public void run() {
        int x = 0;
        try {
            while (!isInterrupted()) {
                    x++;
                    String value = searchWord.take();
                    System.out.println("Consumer получил слово: " + value + " "+ x + " раз");
            }
        }
        catch (InterruptedException e){
            System.out.println("Поток consumer остановлен");
        }
    }
}
