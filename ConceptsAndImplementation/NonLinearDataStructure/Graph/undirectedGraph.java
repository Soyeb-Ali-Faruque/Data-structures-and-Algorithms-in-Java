package NonLinearDataStructure.Graph;

import java.util.*;

public class undirectedGraph<T>{
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


    //vertex specific methods
    public void showVertices(){
        for(T vertex : graph.keySet()){
            System.out.print(vertex+"  ");}
    }
    public void addVertex(T vertex){
        graph.put(vertex,new ArrayList<>());}
    public void removeVertex(T vertex){
        if(this.hasVertex(vertex)){
            List<Edge> list=graph.get(vertex);
            for(Edge e: list){
                removeEdge(e.sourc,e.dest);
            }
            graph.remove(vertex);

        }


    }
    public boolean hasVertex(T vertex){return graph.containsKey(vertex);}
    public int getVertexCount(){return graph.size();}
    //return number of neighbours of a vertex
    public int getDegree(T vertex){
        if(graph.containsKey(vertex)){
            return graph.get(vertex).size();
        }return -1;}
    //vertex specific methods
    public boolean isEmpty() {
        if(graph.size() == 0) return true;
        return false;}
    public void showNeighbors(T vertex){
        if(graph.containsKey(vertex)){
            List<Edge> list=graph.get(vertex);
            for(Edge e : list) System.out.print(e.dest + "  ");
        }else System.out.println("vertex not found");}





    //Edges oprations
    public void addEdge(T sourc,T dest){
        if(graph.containsKey(sourc) && graph.containsKey(dest)){
            graph.get(sourc).add(new Edge(sourc,dest));
            graph.get(dest).add(new Edge(dest,sourc));
            countEdges++;
        }else System.out.println("Vertex not found");
    }
    public void removeEdge(T sourc,T dest){
        if(graph.containsKey(sourc) && graph.containsKey(dest) && this.hasEdge(sourc,dest)){
            //vertext remove
            List<Edge> list1 =graph.get(sourc);
            List<Edge> list2=graph.get(dest);
            for(int i=0;i<list1.size();i++){
                if(list1.get(i).dest.equals(dest)){
                    list1.remove(i);
                    break;
                }
            }
            for(int i=0;i<list2.size();i++){
                if(list1.get(i).dest.equals(sourc)){
                    list1.remove(i);
                    break;
                }
            }
            countEdges--;

        }
    }
    public boolean hasEdge(T sourc,T dest){
        if(graph.containsKey(sourc) && graph.containsKey(dest)){
            List<Edge> list=graph.get(sourc);
            for(Edge e : list){
                if(e.dest.equals(dest)) return true;
            }
        }else System.out.println("vertex not found");
        return false;}
    public int getEdgeCount(){return countEdges;}


    //Traversals BFS and DFS
    public void bfs(T start){
        if(!hasVertex(start)){
            System.out.println("vertex not found");
            return;
        }
        HashMap<T,Boolean> visit=new HashMap<>();
        for(T key : graph.keySet()){
            visit.put(key,false);
        }
        bfsTraversal(start,visit);

    }
    private void bfsTraversal(T vertex,HashMap<T,Boolean> visit){
        if(visit.get(vertex)) return;
        Queue<T> queue=new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            T currentVertex= queue.poll();
            visit.put(currentVertex,true);
            //print
            System.out.print(currentVertex+" ");
            //add all its neighbour
            List<Edge> list = graph.get(currentVertex);
            for(Edge e: list){
                if(!visit.get(e.dest)){
                    queue.add(e.dest);
                    visit.put(e.dest,true);
                }
            }
        }
    }

    public void dfs(T start){
        if(!hasVertex(start)){
            System.out.println("vertex not found");
            return;
        }
        HashMap<T,Boolean> visit=new HashMap<>();
        for(T key : graph.keySet()){
            visit.put(key,false);
        }
        dfsTraversal(start,visit);
    }
    private void dfsTraversal(T vertex,HashMap<T,Boolean> visit){
        if(visit.get(vertex)) return;
        System.out.print(vertex + "  ");
        visit.put(vertex,true);
        List<Edge> list=graph.get(vertex);
        for(Edge e : list){
            dfsTraversal(e.dest,visit);
        }
    }


    //Cycle detection
    public boolean hasCycle(){
        HashMap<T,Boolean> visited =new HashMap<>();
        for(T vertex : graph.keySet()) visited.put(vertex,false);
        for(T vertex : graph.keySet()){
            boolean value = checkCycle(vertex,null,visited);
            if(value) return true;
        }
        return false;


    }
    private boolean checkCycle(T vertex,T parent,HashMap<T,Boolean> visited){
        if(visited.get(vertex)) return true;
        visited.put(vertex,true);
        boolean value=false;
        List<Edge> list = graph.get(vertex);
        for(Edge e : list){
            if(!e.dest.equals(parent)){
                value = checkCycle(e.dest,vertex,visited);
                if(value) break;
            }
        }
        return value;
    }


    //check bypartite graph or not
    public boolean isBipartite(){
        for(T startingVertex : graph.keySet()){
            if(!checkBipartite_BFS(startingVertex)) return false;

        }
        return true;

    }

    private boolean checkBipartite_BFS(T startingVertex){
        HashMap<T,Integer> map= new HashMap<>();//accept values (-1,0,1)
        for(T vertex : graph.keySet()) map.put(vertex,-1);
        Queue<T> queue =new LinkedList<>();
        queue.add(startingVertex);
        map.put(startingVertex,0);
        while(!queue.isEmpty()){
            T currentVertex = queue.poll();
            List<Edge> list = graph.get(currentVertex);
            for(Edge e : list){
                int value = map.get(e.dest);
                //it is colored already
                if(value >= 0 && value < 2){
                    //check if matched with its adjacent vertex
                    if(map.get(currentVertex).equals(map.get(e.dest))) return false;
                }else{
                    //set map as colored
                    map.put(e.dest,1-map.get(currentVertex));
                    queue.add(e.dest); // adding to the queue
                }
            }
        }
        return true;
    }



    //Utility methods
    public void clear() {
        graph=new HashMap<>();
    }






}
