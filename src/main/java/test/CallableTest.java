package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Call call = new Call();
        FutureTask<Integer> task = new FutureTask<Integer>(call);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(task.get());
    }

    static class Call implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 6;
        }
    }

}
