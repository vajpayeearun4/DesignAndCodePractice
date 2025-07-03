package multithreading.secondlevel;

public class ExceptionHandler {

    public static void main(String[] args) {
        Thread t1= new Thread(()->{
            System.out.println("Running..");
            throw new RuntimeException("Error thrown");
        });
        t1.setUncaughtExceptionHandler((t, e)->{
            System.out.println("Error thrown by Thread: "+t.getName());
        });
        t1.start();
    }
}
