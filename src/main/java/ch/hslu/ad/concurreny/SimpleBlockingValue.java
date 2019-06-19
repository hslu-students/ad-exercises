package ch.hslu.ad.concurreny;

/**
 * SimpleBlockingValue
 */
public class SimpleBlockingValue {

  private int value;
  private boolean valueSet = false;

  public synchronized int get() throws InterruptedException {

    if (!valueSet) {
      this.wait();
    }

    valueSet = false;
    this.notify();
    return value;
  }

  public synchronized void put(final int value) throws InterruptedException {

    if (valueSet) {
      this.wait();
    }

    this.value = value;
    valueSet = true;
    this.notify();
  }
}