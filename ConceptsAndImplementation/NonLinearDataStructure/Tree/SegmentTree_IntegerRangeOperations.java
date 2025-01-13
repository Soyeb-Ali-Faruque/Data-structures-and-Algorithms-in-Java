package NonLinearDataStructure.Tree;

public class SegmentTree_IntegerRangeOperations {
    private class Query{
        static final int  DEFAULT_VALUE_FOR_SUM=0;
        static final int DEFAULT_VALUE_FOR_MAX=Integer.MAX_VALUE;
        static final int DEFAULT_VALUE_FOR_MIN=Integer.MIN_VALUE;
        static final double DEFAULT_VALUE_FOR_AVG=0;


        static int join(int a,int b){
            return a+b;
        }
        static int max(int a,int b){
            return (a>b)?a:b;
        }
        static int min(int a,int b){
            return (a<b)?a:b;
        }
        static double avg(double a,double b){
            if(a == 0 || b == 0){
                return (a==0)?b:a;
            }
            return ((a+b)/2);
        }

    }
    private class Node{
        int rangeStart=-1;
        int rangeEnd=-1;
        int sum;
        int max;
        int min;
        double avg;
        Node left;
        Node right;
        private Node(int sum,int max,int min,double avg,int s,int e){
            this.sum=sum;
            this.max=max;
            this.min=min;
            this.avg=avg;
            this.rangeStart=s;
            this.rangeEnd=e;
        }
    }
    Node root;


    //creation of segment tree
    public void createSegmentTree(int[] array){
        root=create(array,0,array.length-1);
    }

    //recursive method for segment tree creation
    private Node create(int[] array,int s,int e){
        if(s == e){
            Node node=new Node(rangeSum(array, s, e),rangeMax(array, s, e),rangeMin(array, s, e),rangeAvg(array, s, e),s,e);
            return node;
        }
        int mid=s+(e-s)/2;
        Node node=new Node(rangeSum(array, s, e),rangeMax(array, s, e),rangeMin(array, s, e),rangeAvg(array, s, e),s,e);
        node.left=create(array,s,mid);
        node.right=create(array,mid+1,e);
        return node;
    }

    /** calculating interval results*/

    //Range sum
    private int rangeSum(int array[],int s,int e){
        int sum=0;
        for(int i=s;i<=e;i++){
            sum+=array[i];
        }
        return sum;
    }
    //Range Max
    private int rangeMax(int array[],int s,int e){
        int max=Integer.MIN_VALUE;
        for(int i=s;i<=e;i++){
            if(max<array[i]) max=array[i];
        }return max;
    }
    //Range Min
    private int rangeMin(int[] array,int s,int e){
        int min=Integer.MAX_VALUE;
        for(int i=s;i<=e;i++){
            if(min>array[i]) min=array[i];
        }return min;
    }
    //Range Avg
    private int rangeAvg(int[] array,int s,int e){
        return (rangeSum(array,s,e)/((e-s)+1));
    }




    //front methods
    public int findSum(){
        return root.sum;
    }public int findSumRangeOf(int s,int e){
        if(root == null) return -1;
        return findSumRangeOf(root,s,e);
    }

    public int findMax(){
        return root.max;
    }public int findMaxRangeOf(int s,int e){
        if(root == null) return -1;
        return findMaxRangeOf(root,s,e);
    }

    public int findMin(){
        return root.min;
    }public int findMinRangeOf(int s,int e){
        if(root == null) return -1;
        return findMinRangeOf(root,s,e);
    }

    public double findAvg(){
        return root.avg;
    }public double findAvgRangeOf(int s,int e){
        if(root == null) return -1;
        return findAvgRangeOf(root,s,e);
    }




    /** Make your Range query efficient */

    //efficient range sum
    private int findSumRangeOf(Node node,int s,int e){
         //outer bound:
        if(s > node.rangeEnd || e < node.rangeStart ) return Query.DEFAULT_VALUE_FOR_SUM;

        //inner bound:
        if (s <= node.rangeStart && e >= node.rangeEnd) return node.sum;

        //overlapping sum
        return  Query.join(findSumRangeOf(node.left,s,e),findSumRangeOf(node.right,s,e));
    }

    //efficient range max
    private int findMaxRangeOf(Node node,int s,int e){
        //outer bound:
        if(s > node.rangeEnd || e < node.rangeStart ) return Query.DEFAULT_VALUE_FOR_MIN;

        //inner bound:
        if (s <= node.rangeStart && e >= node.rangeEnd) return node.max;

        //overlapping sum
        return  Query.max(findMaxRangeOf(node.left,s,e),findMaxRangeOf(node.right,s,e));
    }

    //efficient range min
    private int findMinRangeOf(Node node,int s,int e){
        //outer bound:
        if(s > node.rangeEnd || e < node.rangeStart ) return Query.DEFAULT_VALUE_FOR_MAX;

        //inner bound:
        if (s <= node.rangeStart && e >= node.rangeEnd) return node.min;

        //overlapping sum
        return  Query.min(findMinRangeOf(node.left,s,e),findMinRangeOf(node.right,s,e));
    }

    //efficient range avg
    private double findAvgRangeOf(Node node,int s,int e){
        //outer bound:
        if(s > node.rangeEnd || e < node.rangeStart ) return Query.DEFAULT_VALUE_FOR_AVG;

        //inner bound:
        if (s <= node.rangeStart && e >= node.rangeEnd) return node.avg;

        //overlapping sum
        return  Query.avg(findAvgRangeOf(node.left,s,e),findAvgRangeOf(node.right,s,e));
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 2, 2, 5};
        SegmentTree_IntegerRangeOperations tree = new SegmentTree_IntegerRangeOperations();
        tree.createSegmentTree(array);
        System.out.println(tree.findAvgRangeOf(2, array.length - 1));
        double a=(2+5)/2;
        System.out.println(a);
    }


}
