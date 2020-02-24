package sample;



public class Node {
    private Node next;
    private String x;

    public Node(Node next, String x) {
        this.next = next;
        this.x = x;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "s "+ next.toString();
    }
}