
import java.util.ArrayList;

public class BSTree {

    Node root;
    MyQueue queue = new MyQueue();

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.println (p.info + "  " + p.height);
    }

    private int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    ////////////////////////////////////////////////////////////

    // Q1. Return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        // Begin your code here
        if (p == null) {
            return null;
        }

        if (p.equals(key)) {
            return p;
        } else if (p.geaterThan(key)) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }

        // End your code here
    }
    private Node AVLinsert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }

        if (node.equals(x)) {
            return node;
        }

        if (node.lessThan(x)) {
            node.right = AVLinsert(node.right, x);
        } else {
            node.left = AVLinsert(node.left, x);
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1) {
            if (node.left.lessThan(x)) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        } else if (balance < -1) {
            if (node.right.geaterThan(x)) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }


    ////////////////////////////////////////////////////////////
    // Q2. Insert a key x to the tree
    public void insert(int x) {
        root = AVLinsert(root, x);
        // End your code here
    }

    //preorder a tree
    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    //postorder a tree
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //inorder a tree
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    ////////////////////////////////////////////////////////////
    // Q3. Breadth first traversal
    public void BFT(Node z) {
        // Begin your code here
        if (z == null) {
            return;
        }
        queue.enqueue(root);
        Node p;
        while (!queue.isEmpty()) {
            p = (Node) queue.dequeue();
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
            visit(p);
        }

        // End your code here
    }

    ////////////////////////////////////////////////////////////
    // Q4. Compute the height of tree
    
    int height(Node p) {
        // Begin your code here
        if (p == null) return 0;
        return max(height(p.left),height(p.right))+1;
        // End your code here
    }
    private int getHeight(Node p){
        return (p == null) ? 0: p.height;
    }
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    ////////////////////////////////////////////////////////////
    // Q5. Delete a node on BST
    private Node searchFa(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.left != null) {
            if (p.left.info == x) {
                return p;
            }
        }
        if (p.right != null) {
            if (p.right.info == x) {
                return p;
            }
        }

        if (p.info < x) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    public Node searchFa(int x) {
        if (root == null) {
            return null;
        }
        if (root.info == x) {
            return null;
        }
        return search(this.root, x);
    }
    
    public void deleteByCopy(int x) {
        // Begin your code here
        Node p = search(root,x);
        boolean boolR = true;

        if (p == null) {
            System.out.println("Don't have " + x + " in tree!");
            return;
        }
        if ((p.left != null) && (p.right != null)) {
            if (p == root) {
                boolR = true;
            }
            System.out.println("");
            Node maxRight = p.left;
            while (true) {
                if (maxRight.right != null) {
                    maxRight = maxRight.right;
                } else {
                    break;
                }
            }
            maxRight.right = p.right;
            p = p.left;
            if (boolR) {
                root = p;
            }

        } else if ((p.left != null) || (p.right != null)) {
            Node faX;
            faX = searchFa(p, x);
            if (faX == root) {
                boolR = true;
            }
            if (faX.left != null) {
                faX = faX.left;
            } else {
                faX = faX.right;
            }
            if (boolR) {
                root = faX;
            }
            p = null;
        } else {
            if (p == root) {
                root = null;
            } else {
                p = null;
            }
        }
        // End your code here
    }

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    //balancing a BST
    //inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //insert all items from an array to a new BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        insert(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int l = a.size(), f = 0;
        //create a new tree and insert all items from a to the BST
        BSTree t = new BSTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    ////////////////////////////////////////////////////////////
    // Q6. Left rotation
    public Node rotateLeft(Node p) {

        // Begin your code here
        if (p == null) {
            return null;
        }

        Node returnNode = p.right;
        p.right = returnNode.left;
        returnNode.left = p;

        p.height = max(getHeight(p.left), getHeight(p.right)) + 1;
        returnNode.height = max(getHeight(returnNode.left), getHeight(returnNode.right)) + 1;

        return returnNode;

        // End your code here
    }

    ////////////////////////////////////////////////////////////
    // Q7. Right rotation   
    public Node rotateRight(Node p) {
        // Begin your code here
        if (p == null) {
            return null;
        }

        Node returnNode = p.left;
        p.left = returnNode.right;
        returnNode.right = p;
        
        p.height = max(getHeight(p.left), getHeight(p.right)) + 1;
        returnNode.height = max(getHeight(returnNode.left), getHeight(returnNode.right)) + 1;

        return returnNode;
        // End your code here
    }
}
