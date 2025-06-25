package NonLinearDataStructure.Graph;

public class TestGraph {
    public static void main(String[] args) {
        undirectedGraph<Character> gh=new undirectedGraph<>();
        gh.addVertex('a');
        gh.addVertex('b');
        gh.addVertex('c');
        gh.addEdge('a','c');
        gh.addEdge('a','b');
        gh.addEdge('c','b');
        gh.bfs('a');


    }
}
