package ch.hslu.ad.concurreny;

/**
 * RoundedBufferDemo
 */
public class RoundedBufferDemo {

    public static void main(String[] args) {

        RoundedBuffer buffer = new RoundedBuffer<Integer>(5);

        new Thread(() -> {
            try {
                System.out.println("GOT: " + buffer.get());
                System.out.println("GOT2: " + buffer.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                buffer.put(1);
                buffer.put(2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();

    }
}