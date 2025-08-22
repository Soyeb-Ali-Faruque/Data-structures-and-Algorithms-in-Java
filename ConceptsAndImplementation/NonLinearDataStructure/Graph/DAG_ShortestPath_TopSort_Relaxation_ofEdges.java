package NonLinearDataStructure.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DAG_ShortestPath_TopSort_Relaxation_ofEdges {
    public int[] findShortestPath(List<List<Pair>> list,int source){
        Stack<Integer> stack =new Stack<>();
        //topo sort
        topoSort(list,source,stack,new boolean[list.size()]);

        int[] distanceArray =new  int[list.size()];
        Arrays.fill(distanceArray,Integer.MAX_VALUE);
        distanceArray[source] = 0;


        //relaxations of edges
        while (!stack.isEmpty()){
            int node = stack.pop();
            List<Pair> nodes = list.get(node);
            for(Pair currentNode : nodes){
                int calculatedDistance = distanceArray[node] + currentNode.getWeight();
                if(calculatedDistance < distanceArray[currentNode.getNodeIndex()]){
                    distanceArray[currentNode.getNodeIndex()] = calculatedDistance;
                }

            }
        }
        return distanceArray;

    }
    private static void  topoSort(List<List<Pair>> list,int node,Stack<Integer> stack,boolean[] visited){
        if(visited[node]) return;
        //mark AS visited
        visited[node] = true;
        List<Pair> nodes = list.get(node);
        for(Pair currentNode : nodes){
            DAG_ShortestPath_TopSort_Relaxation_ofEdges.topoSort(list, currentNode.getNodeIndex(), stack,visited);
        }
        stack.push(node);
    }
}
