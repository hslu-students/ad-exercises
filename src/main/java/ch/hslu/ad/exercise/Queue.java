package ch.hslu.ad.exercise;


public class Queue {
  private int length = 8;
  private int size = 0;
  private char[] queue = new char[length];
  private int head = 0;
  private int tail = 0;

  public void put(char element) {
    queue[head] = element;
    if (head == (length - 1)) {
      head = 0;
    } else {
      head++;
    }
    size++;
  }

  public char get() {
    char element = ' '; // TODO: find better defailt
    if (size > 0) {
      // be shure we don't take out more elements than there are
      // in the queue!
      element = queue[tail];
      if (tail == (length - 1)) {
        tail = 0;
      } else {
        tail++;
      }
      size--;
    } 
    return element;
  }
}