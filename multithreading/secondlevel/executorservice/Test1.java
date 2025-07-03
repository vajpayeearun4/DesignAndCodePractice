package multithreading.secondlevel.executorservice;

import java.util.concurrent.*;

public class Test1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FileDownloadTask file1 = new FileDownloadTask("File1");
        FileDownloadTask file2 = new FileDownloadTask("File2");
        FileDownloadTask file3 = new FileDownloadTask("File3");
        Future<String> file1Future = executorService.submit(file1);
        Future<String> file2Future =executorService.submit(file2);
        Future<String> file3Future = executorService.submit(file3);
        System.out.println(file1Future.get());
        System.out.println(file2Future.get());
        System.out.println(file3Future.get());
        executorService.shutdown();
    }
}

class FileDownloadTask implements Callable<String> {
    String fileName;

    public FileDownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2300);
        return "Downloaded " + fileName;
    }
}
