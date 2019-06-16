package ch.hslu.ad.exercise;

import java.util.ArrayList;
import java.util.List;

import ch.hslu.ad.exercise.BinaryTree.Node;

public class PreorderTraversal implements BinaryTreeTraversal {

    @Override
    public List<Object> traverse(Node root) {
        return getPreorder(root);
    }

    private List<Object> getPreorder(Node node) {
        List<Object> elements = new ArrayList<Object>();

        if (node.left != null) {
            elements.addAll(getPreorder(node.left));
        }
        if (node.right != null) {
            elements.addAll(getPreorder(node.right));
        }
        elements.add(node.value);

        return elements;
    }
}