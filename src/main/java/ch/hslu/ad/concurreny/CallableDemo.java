package ch.hslu.ad.concurreny;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CallableDemo
 */
public class CallableDemo {

    public static void main(String[] args) {

        final ExecutorService worker = Executors.newFixedThreadPool(3);

        Callable<Integer> adder = () -> {
            return 1 + 2;
        };

        Future<Integer> future = worker.submit(adder);
        try {
            System.out.println("Got future " + future.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        worker.shutdown();
    }
}