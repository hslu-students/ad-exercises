package ch.hslu.ad.exercise;

import java.util.List;

public class BinaryTree<T> {
  private Node root;

  /**
   * Adds a new element to the tree
   */
  public void add(T value) {
    final Node node = new Node(value);
    if (root != null) {
      root.add(node);
    } else {
      root = node;
    }
  }

  public boolean search(T value) {
    return root.search(value);
  }


  public List<Object> traverse(BinaryTreeTraversal strategy) {
    return strategy.traverse(root);
  }

  /**
   * Simulate default param strategy
   * @return List of found nodes
   */
  public List<Object> traverse() {
    return traverse(new PreorderTraversal());
  }

  public class Node {
    Node left;
    Node right;
    T value;

    /**
     * Adds a new node at the end of the tree
     */
    public void add(Node node) {
      final int comparison = this.compare(node);
      if (comparison == 0) {
        // values are equal (not allowed in a binary tree)
        throw new IllegalArgumentException("Node is equal to already added node!");
      }
      else if (comparison > 0) {
        // bigger (right side)
        if (this.right != null) {
          this.right.add(node);
        } else {
          this.right = node;
        }
      } else {
        // smaller (left side)
        if (this.left != null) {
          this.left.add(node);
        } else {
          this.left = node;
        }
      }
    }

    /**
     * Search whether a given value is in the tree
     */
    public boolean search(T value) {
      if (value.hashCode() == this.value.hashCode()) {
        return true;
      }
      if (value.hashCode() > this.value.hashCode()) {
        return this.right.search(value);
      }
      if (value.hashCode() < this.value.hashCode()) {
        return this.left.search(value);
      }
      return false;
    }

    private int compare(Node compareTo) {
      if (compareTo.value.hashCode() > value.hashCode()) {
        return 1;
      } else if (value.hashCode() == compareTo.value.hashCode()) {
        return 0;
      } else {
        return -1;
      }
    }

    /**
     * Creates a new node
     */
    public Node(T value) {
      this.value = value;
    }
  }
}