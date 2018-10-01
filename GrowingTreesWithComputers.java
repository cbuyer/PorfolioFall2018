package growingtreeswithcomputers;

class Node<T extends Comparable<T>> {

    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GrowingTreesWithComputers<T extends Comparable<T>> {

    Node<T> root;

    GrowingTreesWithComputers() {
    }
    
    public void add(T item) {
         if (root == null) {
             Node newNode = new Node(item);
             root = newNode;
             
             return;
         }  
         Node <T> currNode = root;
         
         boolean addedItem = false;
         while (!addedItem) {
             if (currNode.data.compareTo(item) <=0) {
               if (currNode.right != null) {
                   currNode = currNode.right;
               }  else {
                   Node newNode = new Node(item);
                   currNode.right = newNode;
                   
                   addedItem = true;
               }
             }
             if (currNode.data.compareTo(item) >=0) {
               if (currNode.left != null) {
                   currNode = currNode.left;
               }  else {
                   Node newNode = new Node(item);
                   currNode.left = newNode;
                   
                   addedItem = true;
               }
             }
         }
    }

    public boolean findLeaves(T item){
      //Once you have add, this is pretty easy by comparison.      
        boolean inTree = false;
        if (root == null) {
            return inTree;
        }
        
        Node<T> currNode = root;
        Node<T> leftNode = root.left;
        Node<T> rightNode = root.right;
        
        while (currNode!= null && inTree == false) {
            if (currNode.data.compareTo(item) == 0) {
                inTree = true;
            } else {
                if (currNode.data.compareTo(item) < 0) {
                    currNode = currNode.right;
                } else {
                    currNode = currNode.left;
                }
            }
        }
        return inTree;
    }
    
        public void printTree(Node<T> weHere, int depth) {
    //Gives a little graphical view starting with node weHere.

        depth++;
        if (weHere != null) {
            printTree(weHere.right, depth);
        }
        {  //Print Current Node
            String nodeData;
            if (weHere != null) {
                nodeData = weHere.data.toString();
            } else {
                nodeData = "X";
            }
            int numSpaces = depth * 14 - nodeData.length();//adjust if needed
            for (int i = 0; i < numSpaces; i++) {
                System.out.print(" ");
            }
            System.out.println(nodeData);

        }

        if (weHere != null) {
            printTree(weHere.left, depth);
        }
    }
    
        public static void main(String[] args) {
        //generic code to test
        GrowingTreesWithComputers<Integer> myTree = new GrowingTreesWithComputers<Integer>();
        myTree.add(10);
        myTree.add(5);
        myTree.add(15);
        myTree.add(20);
        myTree.add(17);
        myTree.add(0);
        myTree.add(30);
        myTree.add(22);
        myTree.add(18);
        myTree.add(11);
        myTree.add(45);
        myTree.add(100);
        myTree.printTree(myTree.root, 0);
        System.out.println("Is 21 in the tree? " +myTree.findLeaves(21));
        System.out.println("Is 11 in the tree? " +myTree.findLeaves(11));
        
    }
    
}