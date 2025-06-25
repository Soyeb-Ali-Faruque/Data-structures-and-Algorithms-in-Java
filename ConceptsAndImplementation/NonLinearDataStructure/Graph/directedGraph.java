package NonLinearDataStructure.Graph;

import java.util.*;

public class directedGraph<T>{
    private class Edge{
        T sourc;
        T dest;
        Edge(T sourc,T dest){
            this.sourc=sourc;
            this.dest=dest;
        }

    }
    private HashMap<T , List<Edge>> graph=new HashMap<>();
    private int countEdges=0;

    // Vertex-specific methods
    public void showVertices(){
        for(T vertex : graph.keySet()){
            System.out.print(vertex+"  ");}
    }
    public void addVertex(T vertex){
        graph.put(vertex,new ArrayList<>());}
    public void removeVertex(T vertex){
        if(hasVertex(vertex)){
            graph.remove(vertex);
        }else System.out.println("vertex not found");
    }
    public boolean hasVertex(T vertex){
        return graph.containsKey(vertex);
    }
    public int getVertexCount(){ return graph.size();}
    public int getDegree(T vertex){
     if(this.hasVertex(vertex)){
         return graph.get(vertex).size();
     }return -1;
    }
    public boolean isEmpty(){
        return graph.isEmpty();
    }
    public void showNeighbors(T vertex){
        if(this.hasVertex(vertex)){
            List<Edge> list=graph.get(vertex);
            for(Edge e : list) System.out.print(e.dest+" ");
        }else System.out.println("vertex not found");
    }

    // Edge operations
    public void addEdge(T sourc, T dest){
        if(hasVertex(sourc) && hasVertex(dest)){
            graph.get(sourc).add(new Edge(sourc,dest));
            countEdges++;
        }else System.out.println("vertex not found");
    }
    public void removeEdge(T sourc, T dest){
        if(hasVertex(sourc) && hasVertex(dest)){
            List<Edge> list = graph.get(sourc);
            if(hasEdge(sourc, dest)) {
                for (int i = 0; i < list.size(); i++) {
                    Edge e = list.get(i);
                    if(e.dest.equals(dest)){
                        list.remove(i);
                        return;
                    }
                }
            }//if there is no edge
            System.out.println("Edge not found");
        }else System.out.println("vertex not found");
    }
    public boolean hasEdge(T sourc, T dest){
        if(hasVertex(sourc) && hasVertex(dest)){
            List<Edge> list = graph.get(sourc);
            for(Edge e : list){
                if(e.dest.equals(dest)) return true;
            }

        }else System.out.println("vertex not found");
        return false;
    }
    public int getEdgeCount(){ return countEdges;}

    // Traversals
    public void bfs(T start){
        if(!hasVertex(start)) {
            System.out.println("vertex not found");
            return;
        }
        HashMap<T,Boolean> visited =new HashMap<>();
        for(T vertex : graph.keySet()){
            visited.put(vertex,false);
        }
        bfsTraversal(start,visited);

    }
    private void bfsTraversal(T vertex,HashMap<T,Boolean> visited){
        Queue<T> queue =new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            T currentVertex= queue.poll();
            visited.put(currentVertex,true);
            System.out.print(currentVertex+"  ");
            List<Edge> list = graph.get(currentVertex);
            for(Edge e: list){
                if(!visited.get(e.dest)){
                    queue.add(e.dest);
                    visited.put(e.dest,true);
                }
            }
        }
    }
    public void dfs(T start){}
    private void dfsTraversal(T vertex,HashMap<T,Boolean> visited){
        if(visited.get(vertex)) return;
        visited.put(vertex,true);
        System.out.print(vertex+"  ");
        List<Edge> list=graph.get(vertex);
        for(Edge e: list){
            dfsTraversal(e.dest,visited);
        }
    }


    //Cycle detection
    public boolean hasCycle(){
        HashMap<T,Boolean> visited = new HashMap<>();
        HashMap<T,Boolean> currentStack =new HashMap<>();
        for(T vertex : graph.keySet()){
            visited.put(vertex,false);
            currentStack.put(vertex,false);
        }
        for(T vertex : graph.keySet()){
            if(!visited.get(vertex) && checkCycle(vertex,visited,currentStack)) return true;
        }
        return false;

    }
    private boolean checkCycle(T vertex,HashMap<T,Boolean> visited,HashMap<T,Boolean> currentStack){
        //visited already and currentStack true return true;
        if(visited.get(vertex) && currentStack.get(vertex)) return true;
        if(visited.get(vertex)) return false;
        //set to currentStack
        currentStack.put(vertex,true);
        //mark as visited
        visited.put(vertex,true);
        //loop to all its neighbours
        List<Edge> list = graph.get(vertex);
        boolean value=false;
        for(Edge e : list){
            value=checkCycle(e.dest,visited,currentStack);
            if(value) break;
        }
        currentStack.put(vertex,false);
        return value;
    }


    // Utility methods
    public void clear(){
        graph = new HashMap<>();
    }



}
