package Binary_Search_Tree;

class BSTNode<T> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;
    BSTNode(T data) {
        this.data = data;
    }
}

class BSTOperations {
    BSTNode<Integer> root;

    void buildTree() {
        root = insertNewNode(70, root);
        root = insertNewNode(14, root);
        root = insertNewNode(18, root);
        root = insertNewNode(80, root);
        root = insertNewNode(75, root);
        // and we can make as many nodes that will satisfy the binary search tree condition.
        print();
    }
    
    // Extra Operations

    // Max Value
    int maxValue(BSTNode<Integer> temp) {
        if (temp == null) {
            return Integer.MIN_VALUE;
        }
        if (temp.right == null) {
            return temp.data;
        }
        return maxValue(temp.right);
    }
    //Min Value
    int minValue(BSTNode<Integer> temp) {
        if (temp == null) {
            return Integer.MAX_VALUE;
        }
        if (temp.left == null) {
            return temp.data;
        }
        return maxValue(temp.left);
    }

    // Deletion of a Node in Binary Search Tree
    

    BSTNode<Integer> insertNewNode(int data, BSTNode<Integer> parent) {
        if (parent == null) {
            parent = new BSTNode<Integer>(data);
            return parent;
        }
        if (data < parent.data) {
            parent.left = insertNewNode(data, parent.left);
        }
        else if (data >= parent.data) { /*We can change the greater than -> greater than equal to for handling duplicates*/
            parent.right = insertNewNode(data, parent.right);
        }
        return parent;
    }

    void print() {
        System.out.println("Inorder traversal of the BST:");
        inorderTraversal(root);
    }

    private void inorderTraversal(BSTNode<Integer> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
}

public class BSTDemo {
    public static void main(String[] args) {
        BSTOperations bst = new BSTOperations();
        bst.buildTree();
        
        System.out.println("\nMax value in the BST: " + bst.maxValue(bst.root));
    }
}