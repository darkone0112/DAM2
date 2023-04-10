public class myRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(thread.currentThread().getName() + ": " + i + "\n");
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(thread.currentThread().getName() + " ha finalizado!" + "\n");
    }
}
