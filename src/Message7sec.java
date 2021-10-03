public class Message7sec extends Thread{

    Timer timer;
    Message7sec (Timer timer) {
        this.timer = timer;
    }

    public void run (){
        try {
            while (!isInterrupted()) {
                timer.sevenSec();
                if (Main.x == Main.time) {
                    Thread.interrupted();
                    throw new InterruptedException();
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("3 Поток остановлен");
        }
    }
}
