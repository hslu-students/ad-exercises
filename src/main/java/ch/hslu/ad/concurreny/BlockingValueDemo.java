package ch.hslu.ad.concurreny;

/**
 * BlockingValueDemo
 */
public class BlockingValueDemo {

    public static void main(String[] args) {

        var value = new SimpleBlockingValue();

        new Thread(() -> {
            try {
                int v = value.get();
                System.out.println("GOT: " + v);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("PUT: 1");
                value.put(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }
}