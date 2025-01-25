package NonLinearDataStructure.Tree;

public class AVLTree<E extends Number & Comparable<E>> extends BinarySearchTree<E>  {
    //constructor


    @Override
    public void insert(E data) {
        super.root=insertAndBalceTree(root,data);

    }
    private Node insertAndBalceTree(Node node,E data){
        if(node == null){
            //create new node and add to the tree
            Node temp=new Node(data);
            temp.height=0;
            return temp;
        }
        if (data.compareTo(node.data) < 0) node.left=insertAndBalceTree(node.left,data);
        else node.right=insertAndBalceTree(node.right,data);
        node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right))+1;
        return balance(node);
    }

    @Override
    public void delete(E data) {
        root=delete(root,data);
    }

    private Node delete(Node node,E data){
        if(node == null ) return null;
        if(node.data.compareTo(data) == 0){
            //leaf node
            if(node.left == null  && node.right == null) return null;
                //Two child
            else if(node.left != null && node.right != null){
                E min=min(node.right,node).data;
                node.data=min;
                node.right=delete(node.right,min);
                node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right))+1;
                return node;
            }
            //Only left child
            else if (node.left != null ) {
                return node.left;
            }
            //Only right child
            else{
                return node.right;
            }
        }
        if(node.data.compareTo(data) > 0) node.left=delete(node.left,data);
        else node.right=delete(node.right,data);
        node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right))+1;
        return balance(node);
    }




    private Node balance(Node node){
        int factor=getBalanceFactor(node);
        if(factor>=-1 && factor <= 1) return node;
        //left heavy
        if (factor == 2){
            //left lefet case
            if(getBalanceFactor(node.left) > 0){
                node=rightRotate(node);
            }
            //left right
            else{
                node.left=leftRotate(node.left);
                node=rightRotate(node);
            }

        }else{
            //right left
            if(getBalanceFactor(node.right) > 0){
                node.right=rightRotate(node.right);
                node=leftRotate(node);
            }
            //right right
            else{
                node=leftRotate(node);
            }
        }
        return node;

    }
    private int getBalanceFactor(Node node){
        return (getNodeHeight(node.left) - getNodeHeight(node.right));
    }



    private Node rightRotate(Node node){
        Node child=node.left;
        node.left=child.right;
        child.right=node;
        //set height
        node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right)+1);
        child.height=Math.max(getNodeHeight(child.left),getNodeHeight(child.right)+1);
        return child;

    }
    private Node leftRotate(Node node){
        Node child=node.right;
        node.right=child.left;
        child.left=node;
        //set height
        node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right)+1);
        child.height=Math.max(getNodeHeight(child.left),getNodeHeight(child.right)+1);
        return child;
    }





}
