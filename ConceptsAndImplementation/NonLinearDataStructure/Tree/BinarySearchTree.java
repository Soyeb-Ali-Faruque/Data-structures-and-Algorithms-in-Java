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



        protected   Node getParent(Node parent,Node node){
             if(parent == null || parent == node) return null;
             if(parent.left == node || parent.right == node) return parent;
             Node foudnParent=getParent(parent.left,node);
             if(foudnParent == null) foudnParent=getParent(parent.right,node);
             return foudnParent;
    }

        public E delete(E data){
             Node current=search(root,data);
             Node parent=getParent(root,current);
            if( current == null) return null;
            boolean haveParent=(parent != null)? true: false;
            //if deleting node is a leaf node means has no childrens
            if(current.left == null && current.right == null){
                if(haveParent){
                    if(data.compareTo(parent.data) > 0) parent.right=null;
                    else parent.left=null;
                }
            }
            //if deleting node contains 2 childrens
            else if(current.left !=null && current.right != null){
                Node node=min(current.right,current);
                Node nodeParent=getParent(root,node);
                current.data=node.data;
                if(nodeParent == current){
                    current.right=null;
                }
                else if(node.right != null) nodeParent.left=node.right;
                else nodeParent.left=null;

            }
            //Deleting node have only left child
            else if(current.left != null){
                if(current.data.compareTo(parent.data) > 0) parent.right=current.left;
                else parent.left=current.left;
            }
            //Deleting node have only right child
            else{
                if(current.data.compareTo(parent.data) > 0) parent.right=current.right;
                else parent.left=current.right;

            }
            return data;

        }



    //searching data from the root boolean return
    public Boolean search(E data){
            return (search(root,data) != null)?true:false;
        }
         protected Node search(Node temp,E data){
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
        protected Node min(Node temp,Node prev){
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
            if(node ==null) return 0;
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



