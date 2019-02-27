package ch.hslu.ad.exercise;


public class Stack {
  private String[] stack;
  private int index = 0;

  /**
   * Returns the last element from the stack
   */
  public String pop() {
    if (index == 0) {
      return null;
    } else {
      return stack[--index];
    }
  }

  /**
   * Adds a new element to the stack
   */
  public void push(String element) {
    stack[index++] = element;
  }

  /**
   * Gets the number of elements
   */
  public int size() {
    return index;
  }

  public Boolean isFull() {
    return stack.length >= index;
  }

  public Stack(int size) {
    this.stack = new String[size];
  }
}