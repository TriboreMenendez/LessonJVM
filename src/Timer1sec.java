public class Timer1sec extends Thread{

    Timer timer;
    Timer1sec (Timer timer) {
        this.timer = timer;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                timer.oneSec();
                if (Main.x == Main.time) {
                    Thread.interrupted();
                    throw new InterruptedException();
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("1 Поток остановлен");

        }
    }
}
