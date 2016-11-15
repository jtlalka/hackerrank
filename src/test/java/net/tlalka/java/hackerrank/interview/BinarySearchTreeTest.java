package net.tlalka.java.hackerrank.interview;

import net.tlalka.java.hackerrank.interview.BinarySearchTree.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    private BinarySearchTree tree = new BinarySearchTree();

    @Test
    public void testEmptyTree() {

        // given
        Node node = new Node(100, null, null);

        // when
        boolean result = tree.checkBST(node);

        // then
        assertTrue(result);
    }

    @Test
    public void testTreeWithLeftNode() {

        // given
        Node leftNode = new Node(5, null, null);
        Node rootNode = new Node(100, leftNode, null);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertTrue(result);
    }

    @Test
    public void testTreeWithInvalidLeftNode() {

        // given
        Node leftNode = new Node(200, null, null);
        Node rootNode = new Node(100, leftNode, null);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(false, result);
    }

    @Test
    public void testTreeWithRightNode() {

        // given
        Node rightNode = new Node(200, null, null);
        Node rootNode = new Node(100, null, rightNode);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(true, result);
    }

    @Test
    public void testTreeWithInvalidRightNode() {

        // given
        Node rightNode = new Node(1, null, null);
        Node rootNode = new Node(100, null, rightNode);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(false, result);
    }

    @Test
    public void testComplexValidTree() {

        // given
        Node rNode3 = new Node(55, null, null);
        Node lNode3 = new Node(52, null, null);
        Node lNode2 = new Node(55, lNode3, rNode3);
        Node rNode2 = new Node(80, null, null);
        Node lNode1 = new Node(40, null, null);
        Node rNode1 = new Node(60, lNode2, rNode2);
        Node rootNode = new Node(50, lNode1, rNode1);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(true, result);
    }

    @Test
    public void testComplexGeneratedTree() {

        // given
        Node root = new Node(50);
        root.insert(40);
        root.insert(52);
        root.insert(55);
        root.insert(55);
        root.insert(60);
        root.insert(80);

        // when
        boolean result = tree.checkBST(root);

        // then
        assertEquals(true, result);
    }

    @Test
    public void testComplexInvalidTree() {

        // given
        Node rNode2 = new Node(70, null, null);
        Node lNode2 = new Node(1, null, null);
        Node lNode1 = new Node(50, lNode2, rNode2);
        Node rNode1 = new Node(70, null, null);
        Node rootNode = new Node(60, lNode1, rNode1);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(false, result);
    }

    @Test
    public void testWrongDuplicatedValueTree() {

        // given
        Node rNode2 = new Node(11, null, null);
        Node lNode2 = new Node(8, null, null);
        Node lNode1 = new Node(9, lNode2, rNode2);
        Node rNode1 = new Node(11, null, null);
        Node rootNode = new Node(10, lNode1, rNode1);

        // when
        boolean result = tree.checkBST(rootNode);

        // then
        assertEquals(false, result);
    }

    @Test
    public void testTraversingInOrder() {

        // given
        Node tree1 = new Node(50);
        tree1.insert(40);
        tree1.insert(60);
        tree1.insert(60);
        tree1.insert(80);

        Node tree2 = new Node(50);
        tree2.insert(60);
        tree2.insert(40);
        tree2.insert(60);
        tree2.insert(80);

        // when
        List<Integer> inOrder1 = tree1.getValuesInOrder();
        List<Integer> inOrder2 = tree2.getValuesInOrder();

        assertNotNull(inOrder1);
        assertNotNull(inOrder2);
        assertEquals(inOrder1, inOrder2);
    }
}
