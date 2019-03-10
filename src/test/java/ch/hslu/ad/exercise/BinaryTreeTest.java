package ch.hslu.ad.exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class CustomListTest {

    @Test
    void testTreeCreation() {
        final var tree = new BinaryTree<Integer>();
        assertTrue(tree != null);
    }

    @Test
    void testRootNodeCreation() {
        final var tree = new BinaryTree<Integer>();
        tree.add(1);
        assertTrue(tree.search(1));
    }

    @Test
    void testMultipleElements() {
        final var tree = new BinaryTree<Integer>();
        tree.add(2);
        tree.add(3);
        tree.add(1);

        // test using reflection if the correct value is in
        // the correct spot of the tree
        try {
          var field = tree.getClass().getDeclaredField("root");
          field.setAccessible(true);
          Object o = field.get(tree);
          field = o.getClass().getDeclaredField("value");
          field.setAccessible(true);
          var i = (Integer)field.get(o);
          assertTrue(i == 2);
        } catch (Exception ex) {
          assertTrue(false);
        }
        
        assertTrue(tree.search(1));
    }
}
