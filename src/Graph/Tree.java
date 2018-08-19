package Graph;

public class Tree {

    private int data;
    private Tree left;
    private Tree right;

    public Tree(final int data) {
        this(data, null, null);
    }

    public Tree(final int data, final Tree left, final Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
