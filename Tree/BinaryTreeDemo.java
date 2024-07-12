package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNode<T>{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode(T data){
        this.data = data;
    }
}
class BinaryTreeOperations{
    String nodeName = "parent";
    Scanner scanner = new Scanner(System.in);
    BinaryTreeNode<Integer> add(){
        System.out.println("Enter the node data in a tree for "+nodeName);
        // Get the Data
        int data = scanner.nextInt();
        // Base Case
        if(data == -1){
            return null;
        }
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
        // Get the Left
        nodeName = "left";
        newNode.left = add();
        // Get the Right
        nodeName = "right";
        newNode.right = add();
        nodeName = "parent";
        // Go Back
        return newNode;

    }

    void print(BinaryTreeNode<Integer> root){
        // Base Case
        if(root == null){
            return ;
        }
        String result = "";

        // Traverse the parent
        int parent = root.data;
        result += "P => "+parent;
        // Traverse in Left
        if(root.left!=null){
            int leftData = root.left.data;
            result += " L => "+leftData;
        }
        // Traverse in Right
        if(root.right!=null){
            int rightData = root.right.data;
            result += " R => "+rightData;
        }
        System.out.println(result);
        print(root.left);
        print(root.right);
    }

    // There are three type of Depth First Search Traversal
        // preOrder (PLR)
        // inOrder (LPR)
        // PostOrder (LRP)

    void preOrderPrint(BinaryTreeNode<Integer> parent){
        // Base Case
        if(parent == null){
            return;
        }
        // Print Parent
        System.out.println(parent.data + " ");
        // Move to left
        preOrderPrint(parent.left);
        // Move to Right
        preOrderPrint(parent.right);
    }

    void inOrderPrint(BinaryTreeNode<Integer> parent){
        // Base Case
        if(parent == null){
            return;
        }
        // Move to left
        inOrderPrint(parent.left);
        // Print Parent
        System.out.println(parent.data + " ");
        // Move to Right
        inOrderPrint(parent.right);
    }

    void postOrderPrint(BinaryTreeNode<Integer> parent){
        // Base Case
        if(parent == null){
            return;
        }
        // Move to Left
        postOrderPrint(parent.left);
        // Move to Right
        postOrderPrint(parent.right);
        // Print Parent
        System.out.println(parent.data + " ");
    }

    void levelOrderPrint(BinaryTreeNode<Integer> parent){
        // We maintain a Queue for Traversal that is similar to Stack Operation.
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(parent);
        int level = 0; // To print this level wise
        while(!queue.isEmpty()){
            int size = queue.size();
                // We maintain the size of the queue 
                // and make it inside a for loop for level wise printing
            System.out.print("Level " + level + " : ");
            for(int  i = 0; i < size; i++){
                BinaryTreeNode<Integer> node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                level++;
            }
            System.out.println();
        } 
    }
}
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeOperations opr = new BinaryTreeOperations();
        BinaryTreeNode<Integer> root = opr.add();
        opr.print(root);
        System.out.println();
        opr.levelOrderPrint(root);
    }
}
