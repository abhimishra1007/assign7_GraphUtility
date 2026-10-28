package assign07;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Vertex<Type> implements Comparable<Vertex<Type>>{
	
    Type data;
    LinkedList<Edge<Type>> edges;
    double distance;        // BFS and Dijkstra
    Vertex<Type> previous;  // path reconstruction
    boolean visited;        // Dijkstra
    int inDegree;           // topoSort
    
    
    /*
     * Creates a vertex with given data
     * 
     * @param the data this vertex represents
     */
    public Vertex(Type data) {
    	this.data = data;
    	this.edges = new LinkedList<>();
    	resetState();
    	
    }
   
    public String toString() {	
    	return data + " -> " + edges;
    }
    
    /*
     * Adds a directed edge from the vertex to the destination
     * 
     * @param destination the vertex this edge points to
     * @param weight of the edge
     */
    public void addEdge(Vertex<Type> destination, double weight) {
    	edges.add(new Edge<>(destination, weight));
    }
    
    
    /*
     * Getters and setters 
     */
    public void resetState() {
    	distance = Double.POSITIVE_INFINITY;
    	previous = null;
    	visited = false;
    	inDegree = 0;
    }
    
    public Type getData() {
    	return data;
    }
    
    public List<Edge<Type>> getEdges() {
    	return Collections.unmodifiableList(edges);
    }
    
    public double getDistance() {
    	return distance;
    }
    
    public void setDistance(double distance) {
    	this.distance = distance;
    }
    
    public Vertex<Type> getPrevious() {
		return previous;
	}
    
    public void setPrevious(Vertex<Type> previous) {
		this.previous = previous;
	}
    
    public boolean isVisited() {
    	return visited;
    }
    
    public void setVisited(boolean visited) {
    	this.visited = visited;
    }
    
    public int getDegree() {
    	return inDegree;
    }
    
    public void incrementInDegree() {
    	inDegree++;
    }
   
    public void decrementInDegree() {
		inDegree--;
	}

    /*
     * Compares vertices by current distance so returns the closest in Dkjistra's algorithm
     */
	@Override
	public int compareTo(Vertex<Type> o1) {
		return Double.compare(this.distance, o1.distance);
	}
}

