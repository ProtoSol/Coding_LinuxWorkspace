package Stack;
class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
    }
}

class StackL<T>{
    Node<T> top;
    int size;

    void push(/*T data, */Node<T> newNode){
        // if(top == null){
        //     top = newNode;
        // }
        // else{
        //     Node<T> temp = top;
        //     while(temp != null){
        //         temp = temp.next;
        //     }
        //     temp.next = newNode;
        // }

        // This Approach can be replaced by reversing the Logic
        newNode.next = top;
        top = newNode;
        size++;
    }

    void peek(){
        if(top == null){
            System.out.println("Stack is Empty ...");
            return;
        }
        System.out.println(top.data);
    }

    T pop(){
        if(top == null){
            throw new RuntimeException("Stack is Empty ...");
        }
        T data = top.data;
        top = top.next;
        size --;
        return data;
    }

    void print(){
        if(top == null){
            System.out.println("Stack is Empty ...");
            return;
        }
        Node<T> temp = top;
        while(temp.next != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}

public class StackWithLinkedList {
    public static void main(String[] args) {
        StackL<Integer> stack = new StackL<Integer>();
        stack.push(new Node<Integer>(100));
        stack.push(new Node<Integer>(200));
        stack.push(new Node<Integer>(300));
        stack.peek();
        stack.print();
        System.out.println(".................");
        System.out.println("Removed : " + stack.pop());
        System.out.println(".................");
        stack.peek();
    }
}
