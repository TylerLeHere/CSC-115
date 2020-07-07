/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree {
  private static final int CAPACITY = 100;
  protected Integer[] data;
  protected int root;
  protected int size;

  public ArrayBasedBinaryTree() {
    data = new Integer[CAPACITY];
    root = 0;
    size = 0;
  }

  /*
   * Purpose: inserts the given value into data at next available
   *  position in a level-order traversal
   *  The tree remains complete after insertion.
   * Parameters: Integer value - value to insert
   * Returns: nothing
   */
  public void insert(Integer value) {
    data[size] = value;
    size++;
  }

  /*
   * Purpose: calculates and returns the index of t's left child
   * Parameters: int t - index of current element in this ArrayBasedBinaryTree
   * Returns: int - index of left child
   */
  protected int getLeft(int t) {
    return 2 * t + 1;
  }

  /*
   * Purpose: calculates and returns the index of t's right child
   * Parameters: int t - index of current element in this ArrayBasedBinaryTree
   * Returns: int - index of right child
   */
  protected int getRight(int t) {
    return 2 * t + 2;
  }

  public void inOrder() {
    inOrderRecursive(root);
    System.out.println();
  }

  private void inOrderRecursive(int t) {
    if (data[t] == null || t >= CAPACITY) {
      return;
    }
    inOrderRecursive(getLeft(t));
    System.out.print(data[t] + " ");
    inOrderRecursive(getRight(t));
  }

  public void preOrder() {
    preOrderRecursive(root);
    System.out.println();
  }

  private void preOrderRecursive(int t) {
    if (data[t] == null || t >= CAPACITY) {
      return;
    }
    System.out.print(data[t] + " ");
    preOrderRecursive(getLeft(t));
    preOrderRecursive(getRight(t));
  }

  public void postOrder() {
    postOrderRecursive(root);
    System.out.println();
  }

  private void postOrderRecursive(int t) {
    if (data[t] == null || t >= CAPACITY) {
      return;
    }
    postOrderRecursive(getLeft(t));
    postOrderRecursive(getRight(t));
    System.out.print(data[t] + " ");
  }

  public String toString() {
    // TODO...
    return toStringRecursive(root);
  }

  private String toStringRecursive(int t) {
    String str = "";

    if (data[t] == null) {
      return "";
    }
    str += toStringRecursive(getLeft(t));
    str += data[t] + " ";
    str += toStringRecursive(getRight(t));
    return str;
  }

  public static void main(String[] args) {
    ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();

    for (int i = 2; i < 8; i++) {
      myTree.insert(i);
    }
    System.out.println("in");
    myTree.inOrder();
    System.out.println("pre");
    myTree.preOrder();
    System.out.println("post");
    myTree.postOrder();

    System.out.println("toString\n" + myTree);
  }
}
