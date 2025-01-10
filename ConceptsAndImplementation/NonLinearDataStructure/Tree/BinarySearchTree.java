package NonLinearDataStructure.Tree;

public class BinarySearchTree<E extends Number & Comparable<E>> {
    //Node class structure
    class Node {
        E data;
        Node left = null;
        Node right = null;
        int height=-1;


        //Node class constructors
        Node(){};
        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }

    Node root;


    //insertion
    public void insert(E data){
            root=insertElement(root,data);

        }
        /* recursively traversing the node
        and inserting new node
        and recalculating the heights of each node */
         private Node insertElement(Node temp,E data){
            if(temp == null ) {
                Node node =new Node(data);
                node.height=0;
                return node;
            }
            if(data.compareTo(temp.data) < 0) temp.left = insertElement(temp.left,data);
            else temp.right = insertElement(temp.right,data);
            temp.height = (getNodeHeight(temp.left) > getNodeHeight(temp.right))?getNodeHeight(temp.left)+1:getNodeHeight(temp.right)+1;
            return temp;
        }


    //searching data from the root boolean return
    public Boolean search(E data){
            return (search(root,data) != null)?true:false;
        }
        private Node search(Node temp,E data){
             if(temp == null) return null;
            if(data.equals(temp.data)) return temp;
            if(data.compareTo(temp.data) < 0 ) return search(temp.left,data);
            return search(temp.right,data);
        }



        //Traversal
        //(left,root,right)
        public void inorderTraversal(){
            inorderTraversal(root);
        }
        private void inorderTraversal(Node temp){
            if(temp == null) return;
            inorderTraversal(temp.left);
            System.out.print(temp+"  ");
            inorderTraversal(temp.right);
        }
        //((root,left,right)
        public void preorderTraversal(){
            preorderTraversal(root);
        }
        private void preorderTraversal(Node temp){
            if(temp == null ) return;
            System.out.print(temp+"  ");
            preorderTraversal(temp.left);
            preorderTraversal(temp.right);

        }
        //(left,right,root)
        public void postorderTraversal(){
            postorderTraversal(root);
        }
        private void postorderTraversal(Node temp){
            if(temp == null ) return;
            postorderTraversal(temp.left);
            postorderTraversal(temp.right);
            System.out.print(temp+"  ");
        }



        //Min
        public Node findMin(){
            if(root.left == null ) return root;
            return min(root.left,root);
        }
        private Node min(Node temp,Node prev){
            if(temp == null ) return prev;
            return min(temp.left,temp);
        }


        //searching the node and returning its heights else -1
        public int searchNodeHeight(E data){
        return getNodeHeight(search(root,data));
    }

        //Returning tree's overall height
        public int getTreeheight(){
            return root.height;
        }

        //Specified node height
        public int getNodeHeight(Node node){
            if(node ==null) return -1;
            return node.height;
        }


       //Boolean tree is balanced or not
        public boolean isTreeBalanced(){
            return checkBalanced(root);
        }
        //Recursive implementation of checking tree is balanced or not and returns boolean values
        private boolean checkBalanced(Node node){
            if(node == null) return true;
            return (checkSubTreeHeightDifference(node.left,node.right) && checkBalanced(node.left) && checkBalanced(node.right));
        }
        //Calculating balancing difference
        private boolean checkSubTreeHeightDifference(Node left,Node right){
            int heightDiff= getNodeHeight(left) - getNodeHeight(right);
            return (heightDiff >=-1 && heightDiff <=1)?true:false;
        }

    }



