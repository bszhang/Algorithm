package minimalSpanningTree;

import graph.Edge;
import basic.Bag;
import basic.In;
import basic.Stack;
import basic.StdOut;
import basic.StdRandom;

public class EdgeWeightedGraph{
	
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;
	private int E;
	private Bag<Edge>[] adj;
	
	
	/**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
	public EdgeWeightedGraph(int V){
		if(V<0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[V];
		for(int v=0;v<V;v++){
			adj[v]=new Bag<Edge>();
		}
	
	}
	
	  /**
     * Initializes a random edge-weighted graph with {@code V} vertices and <em>E</em> edges.
     *
     * @param  V the number of vertices
     * @param  E the number of edges
     * @throws IllegalArgumentException if {@code V < 0}
     * @throws IllegalArgumentException if {@code E < 0}
     */
    public EdgeWeightedGraph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    
    

    /**  
     * Initializes an edge-weighted graph from an input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices and edge weights,
     * with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IndexOutOfBoundsException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     */
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }
    
    
    
    
    /**
     * Initializes a new edge-weighted graph that is a deep copy of {@code G}.
     *
     * @param  G the edge-weighted graph to copy
     */
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }
	
    
    
	private void addEdge(Edge e) {
	
		int v = e.either();
		int w = e.other(v);
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	 private void validateVertex(int v) {
		 if (v < 0 || v >= V)
	            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	    }
		
	

	public int V() {
	        return V;
	    }
	 
	 public int E() {
	        return E;
	    }

	 
	 
	 
	 public Iterable<Edge> adj(int v){
		 validateVertex(v);
		 return adj[v];
 
	 }
	 
	 
	 
	 public int degree(int v){
		 validateVertex(v);
		 return adj[v].size();
	 }
	 
	 
	 
	 public Iterable<Edge> edges(){
		 Bag<Edge> list = new Bag<Edge>();
		 for(int v=0;v<V;v++){
			 int selfLoops = 0;
			 for(Edge e : adj[v]){
				 if(e.other(v)>v){
					 list.add(e);
				 }
				 else if(e.other(v)==v){
					 if(selfLoops%2==0){
						 list.add(e);
						 selfLoops++;
					 } 
				 }
			 } 
		 }
		 return list;
	 }
	 
	 
	 
	 /**
	     * Returns a string representation of the edge-weighted graph.
	     * This method takes time proportional to <em>E</em> + <em>V</em>.
	     *
	     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
	     *         followed by the <em>V</em> adjacency lists of edges
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " " + E + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (Edge e : adj[v]) {
	                s.append(e + "  ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	 
	 
	 
	 
	 
	 
	  /**
	     * Unit tests the {@code EdgeWeightedGraph} data type.
	     *
	     * @param args the command-line arguments
	     */
	    public static void main(String[] args) {
	        int in = 3;
	        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	        StdOut.println(G);
	    }
	
	
}