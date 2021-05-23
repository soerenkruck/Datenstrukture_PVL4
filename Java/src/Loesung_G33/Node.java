package Loesung_G33;

public class Node {

    private float probability = 0;

    private Node backNode;

    public byte b;
    public char v;

    public Node(float probability, byte b) {
        this.probability = probability;

        this.b = b;
    }

    public float getProbability() {
        return probability;
    }

    public Node getBackNode() {
        return backNode;
    }

    public void setBackNode(Node backNode) {
        this.backNode = backNode;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public char getV() {
        return v;
    }

    public void setV(char v) {
        this.v = v;
    }
}
