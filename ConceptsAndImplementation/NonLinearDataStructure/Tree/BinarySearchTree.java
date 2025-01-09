package NonLinearDataStructure.Tree;

public class BinarySearchTree<E extends Number & Comparable<E>> {
    //Node class
    class Node {
        E data;
        Node left = null;
        Node right = null;

        Node(E data) {
            this.data = data;
        }
        public String toString(){
            return String.valueOf(data);
        }
    }

        Node root;

        //methods
        public void insert(E data){
            root=insertElement(root,data);

        }
         private Node insertElement(Node temp,E data){
            if(temp == null ) {
                Node node =new Node(data);
                return node;
            }
            if(data.compareTo(temp.data) < 0) temp.left = insertElement(temp.left,data);
            else temp.right = insertElement(temp.right,data);
            return temp;
        }


        //searching element
        public boolean search(E data){
            return search(root,data);
        }
        private boolean search(Node temp,E data){
            if(temp == null) return false;
            if(data.equals(temp.data)) return true;
            if(data.compareTo(temp.data) < 0 ) return search(temp.left,data);
            return search(temp.right,data);
        }

        //Traversal
        public void inorderTraversal(){
            inorderTraversal(root);
        }
        private void inorderTraversal(Node temp){
            if(temp == null) return;
            inorderTraversal(temp.left);
            System.out.print(temp+"  ");
            inorderTraversal(temp.right);
        }

        public void preorderTraversal(){
            preorderTraversal(root);
        }
        private void preorderTraversal(Node temp){
            if(temp == null ) return;
            System.out.print(temp+"  ");
            preorderTraversal(temp.left);
            preorderTraversal(temp.right);

        }

        public void postorderTraversal(){
            postorderTraversal(root);
        }
        private void postorderTraversal(Node temp){
            if(temp == null ) return;
            postorderTraversal(temp.left);
            postorderTraversal(temp.right);
            System.out.print(temp+"  ");
        }


        //Min Max
        public Node findMin(){
            if(root.left == null ) return root;
            return min(root.left,root);
        }
        private Node min(Node temp,Node prev){
            if(temp == null ) return prev;
            return min(temp.left,temp);
        }

        public int getTreeheight(){
            return findTreeHeight(root);
        }
        private int findTreeHeight(Node temp){
            if(temp == null) return -1;
            int leftSubTreeHeight=findTreeHeight(temp.left)+1;
            int rightSubTreeHeight=findTreeHeight(temp.right) + 1;
            return (leftSubTreeHeight > rightSubTreeHeight)? leftSubTreeHeight : rightSubTreeHeight;
        }

        public boolean checkBalanced(){
            return isBalanced(root);
        }
        private boolean isBalanced(Node temp){


        }

    }



