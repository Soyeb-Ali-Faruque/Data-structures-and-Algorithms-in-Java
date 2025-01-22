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

    @Override
    public E delete(E data) {
        return  null;
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
