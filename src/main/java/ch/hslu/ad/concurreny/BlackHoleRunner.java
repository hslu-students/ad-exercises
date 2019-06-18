package ch.hslu.ad.concurreny;

public final class BlackHoleRunner {
    public static void main(final String[] args) {
        final BlackHole blackhole = new BlackHole();
        System.out.println("Thread starts...");

        new Thread(() -> {
            try {
                System.out.println(blackhole.get());  // acquires lock of blackhole
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }, "Blackhole 'getter' thread").start();

        new Thread(() -> {
            blackhole.put("Sonne, Licht, irgendetwas..."); // lock already acquired by getter thread
        }, "Blackhole 'putter' thread").start();
    }
}