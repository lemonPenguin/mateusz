package sample;

import com.company.Stack;

public class StackLinked implements Stack {

    private Node head;
    private int count;

    @Override
    public Node pop() {
        return null;
    }

    @Override
    public void push(Node node) {
        if(head == null){
            head = node;
        }
        else {
            Node current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    @Override
    public String toString() {
        return "StackLinked{" +
                "head=" + head +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
