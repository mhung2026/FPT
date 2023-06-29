public class Node {
    
    int info, height;
    Node left, right;

    public Node(int info, int height, Node left, Node right) {
        this.info = info;
        this. height = height;
        this.left = left;
        this.right = right;
    }
    
    public Node(int info) {
        this.info = info;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
      public void printNode(){
        System.out.print(this.info);
        if (this.left != null)
        System.out.print("/" + this.left.info); else System.out.print("/..");
        if (this.right != null)
            System.out.print("/" + this.right.info); else System.out.print("/..");
        System.out.println("/" + this.height);
    }
    
    public boolean lessThan(int x){
        return x > this.info;
    }
    
    public boolean geaterThan(int x){
        return x < this.info;
    }
    
    public boolean equals(int x){
        return this.info == x;
    }
}