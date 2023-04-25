import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Aarav R. Gupta
 * @version: 4/21/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     *
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size() - 1));
    }

    /**
     * A function that searches for a value in the tree
     *
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return helpSearch(val, root);
    }

    // Helper method for the search method
    public boolean helpSearch(int val, BSTNode node) {
        // Checks if node is null to determine leaves
        // Represents Base Case
        if (node == null)
        {
            return false;
        }

        // Represents Base Case
        if (node.getVal() == val)
        {
            return true;
        }

        // Goes right in the binary tree
        if (node.getVal() < val)
        {
            return helpSearch(val, node.getRight());
        }

        // Goes left in the binary tree
        if (node.getVal() > val)
        {
            return helpSearch(val, node.getLeft());
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        inOrder(root, nodes);
        return nodes;
    }

    // Helper method for the getInorder method
    public void inOrder(BSTNode node, ArrayList<BSTNode> nodes) {
        // Traverses to a left node if one exists
        if (node.getLeft() != null)
        {
            inOrder(node.getLeft(), nodes);
        }

        // Adds the root node
        nodes.add(node);

        // Traverses to a right node if one exists
        if (node.getRight() != null)
        {
             inOrder(node.getRight(), nodes);
        }
        return;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        preOrder(root, nodes);
        return nodes;
    }

    // Helper method for the getPreorder method
    public void preOrder(BSTNode node, ArrayList<BSTNode> nodes) {
        // Starts by adding root node
        nodes.add(node);

        // Traverses to a left node if one exists
        if (node.getLeft() != null)
        {
            preOrder(node.getLeft(), nodes);
        }

        // Traverses to a right node if one exists
        if (node.getRight() != null)
        {
            preOrder(node.getRight(), nodes);
        }
        return;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        postOrder(root, nodes);
        return nodes;
    }

    // Helper method for getPostorder method
    public void postOrder(BSTNode node, ArrayList<BSTNode> nodes) {
        // Traverses to a left node if one exists
        if (node.getLeft() != null)
        {
            postOrder(node.getLeft(), nodes);
        }

        // Traverses to a right node if one exists
        if (node.getRight() != null)
        {
            postOrder(node.getRight(), nodes);
        }

        // Adds the root node
        nodes.add(node);
        return;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        BSTNode node = new BSTNode(val);
        helpInsert(val, root, node);
    }

    public void helpInsert(int val, BSTNode current, BSTNode finalNode) {
        // Goes left if the inserted value is less than the value of the current node
        if (val < current.getVal())
        {
            // Places the node in the left if the left child node does not exist
            if (current.getLeft() == null)
            {
                current.setLeft(finalNode);
            }
            helpInsert(val, current.getLeft(), finalNode);
        }
        // Goes right if the inserted value is greater than the value of the current node
        if (val > current.getVal())
        {
            // Places the node in the right if the right child node does not exist
            if (current.getRight() == null)
            {
                current.setRight(finalNode);
            }
            helpInsert(val, current.getRight(), finalNode);
        }
        return;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
