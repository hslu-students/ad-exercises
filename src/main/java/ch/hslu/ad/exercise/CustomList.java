package ch.hslu.ad.exercise;

import java.util.Iterator;

public class CustomList implements Iterable {
  private int size;
  private Node head;

  /**
   * Adds a new element to the list
   * @param element Element to insert into the list
   */
  public void add(final Object element) {
    final Node node = new Node(element);
    final Node old_head = head;
    if (size > 0) {
      // there is already a head, insert the new element
      // at the start of the list and link the list
      old_head.prev = node;
      node.next = old_head;
    }
    // insert the new node at the start
    head = node;
    size++;
  }

  /**
   * Returns whether a element is inside a list
   */
  public boolean contains(final Object element) {
    for (Object o : this) {
      if (element == o) {
        return true;
      }
    }
    return false;
  }

  /**
   * Gets the last object and returns it
   */
  public Object pop() {
    final Node node = head;
    head = node.next;
    head.prev = null;
    return node.element;
  }

  /**
   * Returns the size of the list
   */
  public int size() {
    return size;
  }

  public void remove(Object element) {
    // TODO
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

  @Override
  public Iterator iterator() {
    return new CustomListIterator(head);
  }

  private class CustomListIterator implements Iterator {
    private Node current;

    @Override
    public boolean hasNext() {
      return current != null;
    }
  
    @Override
    public Object next() {
      final Object element = current.element;
      current = current.next;
      return element;
    }

    public CustomListIterator(Node head) {
      this.current = head;
    }
  }
}