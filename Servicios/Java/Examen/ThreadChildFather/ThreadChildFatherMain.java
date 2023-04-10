/**
 * main
 */
public class ThreadChildFatherMain{
    public static void main(String[] args){
        myRunnable runnable1 = new myRunnable();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        threadResta thread2 = new threadResta();
        thread2.start();
    }
}