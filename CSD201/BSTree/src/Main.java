public class Main {
    
    
    //Điểm cộng: 1
    
    public static void main(String[] args) {
        int [] x = {44, 17, 78, 32, 50, 88, 48, 62, 54};
        BSTree tree = new BSTree();
        for(int i = 0; i < x.length; i++) 
            tree.insert(x[i]);
        
        // Write some test cases for your functions    
        // Begin your code here
        //tree.BFT(tree.root);
        tree.BFT(tree.root);
        tree.deleteByCopy(44);
        
        tree.BFT(tree.root);
        //tree.BFT(tree.root);

    //    tree.visit(tree.search(tree.root, 78));

        

        
        
        
        
        // End your code here

    }
}