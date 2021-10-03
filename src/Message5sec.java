public class Message5sec extends Thread {

    Timer timer;
    Message5sec (Timer timer) {
        this.timer = timer;
    }

    public void run () {
        try {
            while (!isInterrupted()) {
                timer.fiveSec();
                if (Main.x == Main.time) {
                    Thread.interrupted();
                    throw new InterruptedException();
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("2 Поток остановлен");
        }
    }
}
