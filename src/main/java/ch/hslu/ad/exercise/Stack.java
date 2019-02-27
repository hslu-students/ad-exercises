package ch.hslu.ad.exercise;


public class Stack {
  private String[] stack = new String[100];
  private int index = 0;

  public String pop() {
    if (index == 0) {
      return null;
    } else {
      return stack[index];
    }
  }

  public void push(String element) {

  }
}