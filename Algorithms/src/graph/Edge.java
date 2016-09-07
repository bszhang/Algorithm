package graph;

import basic.StdOut;

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final double weight;
	
	/**
	 * Initialize an edge between vertices{@code v} and vertices{@code w} of the given 
	 * {@code weight}}} 
	 * 
	 * @param v one vertex
	 * @param w another vertex
	 * @param weight the weight of the edge
	 * @throws IndexOutOfBoundsException if either{@code v} or {@code w} is a negative integer}
	 * @throws IllegalArgumentException if {@code weight} is {@code NaN}}
	 * 
	 */
	
	public Edge(int v, int w, double weight){
		
		if(v<0) throw new  IndexOutOfBoundsException(" Vertex name must be a nonnegative integer");
		if(w<0) throw new  IndexOutOfBoundsException(" Vertex name must be a nonnegative integer");
		if(Double.isNaN(weight)) throw new IllegalArgumentException(" Weigth is not a number");
		this.v = v;
		this.w = w;
		this.weight = weight;
		
	}
	
	
	/**
	 * Returns the weight of this edge.
	 * 
	 * @return the weight of this edge
	 * 
	 * 
	 */
	public double weight(){
		return this.weight;
	}
	
	
	/**
	 *Returns either endpoint of this edge ;
	 * 
	 * @return either endpoint of this edge;
	 */
	
	public int either(){
		return v;
	}
	
	
	/**
	 *Return the endpoint of this edge that is diff from the given vertex 
	 * 
	 * @param one vertex of this edge
	 * @return the other vertex of this edge
	 * @throws IllegalArgumentException if the vertex is not one of the endpoints of this edge.
	 * 
	 */
	
	public int other (int vertex){
		if (vertex ==v) return w;
		if(vertex == w) return v;
		else throw new IllegalArgumentException("Illegal endpoint" + vertex);
		
	}
	
	
	/**
	 *Compare edge basic on their weight. 
	 * 
	 */
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
		
	}

	public String toString(){
		return String.format("%d-%d %.5f", v,w,weight);
	}
	
	/**
	 * Unit tests the {@code Edge} date type} 
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Edge e = new Edge(12,34,5.67);
		StdOut.println(e);
		
	}
	
	
}
