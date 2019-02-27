package ch.hslu.ad.exercise;

import java.util.Iterator;

public class CustomList implements Iterator {
  private int index;
  private Node head;

  /**
   * Adds a new element to the list
   * @param element Element to insert into the list
   */
  public void add(final Object element) {
    final Node node = new Node(element);
    final Node old_head = head;
    if (old_head != null) {
      // there is already a head, insert the new element
      // at the start of the list and link the list
      old_head.prev = node;
      node.next = old_head;
    }
    // insert the new node at the start
    head = node;
  } 

  public void remove(Object element) {
    // TODO
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }

  class Node {
    Node prev;
    Node next;
    Object element;
    public Node(final Object element) {
      this.element = element;
      this.next = null;
      this.prev = null;   
    }
  }
}