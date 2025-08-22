package NonLinearDataStructure.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    private int nodeIndex;
    private int weight;

    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    Pair(int node, int weight){
        this.nodeIndex =node;
        this.weight = weight;
    }
    @Override
    public int compareTo(Pair other){
        return this.weight - other.weight;
    }
}

//shortest path calculation from source to all nodes.
//works for positive weight.

public class DijkstrasAlgorithm {


    //priority queue
    public int[] algorithmImplementation(List<List<Pair>> list,int source){
        int[] distanceArray = new int[list.size()];
        Arrays.fill(distanceArray,Integer.MAX_VALUE);
        distanceArray[source] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(source,0));
        while(!queue.isEmpty()){
            Pair currentNodePairObject = queue.poll();
            int distance = distanceArray[currentNodePairObject.getNodeIndex()];
            List<Pair> nodes = list.get(currentNodePairObject.getNodeIndex());
            for(Pair node : nodes){
                int calculatedDistance = distance + node.getWeight();
                if(calculatedDistance < distanceArray[node.getNodeIndex()]){
                    distanceArray[node.getNodeIndex()] = calculatedDistance;
                    queue.add(new Pair(node.getNodeIndex(), calculatedDistance));
                }
            }
        }
        return distanceArray;

        }
    }


