package assign07;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * This class represents a vertex in a graph.
 *
 * @author Abhinav Mishra and Thakshbir Singh Dhillon
 * @version October 28, 2026
 */
class Vertex<Type> implements Comparable<Vertex<Type>>
{
    private Type data; // the data of the vertex
    private LinkedList<Edge<Type>> edges; // edges from the vertex
    private double distance; //the distance between vertexes
    private Vertex<Type> previous;// the previous vertex to this vertex
    private boolean visited;
    private int inDegree; //the total number of edges coming in a vertex
    
    /**
     * Creates a vertex with given data
     * 
     * @param the data this vertex represents
     */
    public Vertex(Type data) 
    {
    	this.data = data;
    	this.edges = new LinkedList<>();
    	resetState();
    	
    }
   /**
    * Returns a string like A -> B using data and edges.
    */
    public String toString() 
    {	
    	return this.data + " -> " + this.edges;
    }
    
    /**
     * Adds a directed edge from the vertex to the destination
     * 
     * @param destination the vertex this edge points to
     * @param weight of the edge
     */
    public void addEdge(Vertex<Type> destination, double weight) 
    {
    	this.edges.add(new Edge<>(destination, weight));
    }
    /**
     * resets the state of the vertex by giving its distance as infinity and using the defaults for all the others.
     */
    public void resetState() 
    {
    	this.distance = Double.POSITIVE_INFINITY; // for unknown distance
    	this.previous = null;
    	this.visited = false;
    	this.inDegree = 0;
    }
    /**
     * getter method for data
     * @return the data
     */
    public Type getData() 
    {
    	return this.data;
    }
    /**
     * returns a copy list of the edges.
     * @return A list containing all the edges
     */
    public List<Edge<Type>> getEdges() 
    {
        List<Edge<Type>> copy = new ArrayList<>();
        for (Edge<Type> edge : this.edges) 
        {
            copy.add(edge);
        }
        return copy;
    }
    /**
     * the distance from one vertex to the other
     * @return a double representing the distance
     */
    public double getDistance() 
    {
    	return this.distance;
    }
    /**
     * sets the distance from a vertex to another
     * @param distance a double reperesnting the distnace
     */
    public void setDistance(double distance) 
    {
    	this.distance = distance;
    }
    /**
     * return the previous vertex
     * @return the previous vertex
     */
    public Vertex<Type> getPrevious() 
    {
		return this.previous;
	}
    /**
     * sets the previous index
     */
    public void setPrevious(Vertex<Type> previous) 
    {
		this.previous = previous;
	}
    /**
     * checks whether a vertex has been visited or not 
     * @return true if visted, false otherwise.
     */
    public boolean isVisited() 
    {
    	return  this.visited;
    }
    /**
     * granted the value for visited vertex
     */
    public void setVisited(boolean visited) 
    {
    	this.visited = visited;
    }
    /**
     * getter for the indegrees(number of degrees coming in the vertex)
     * @return an int representing the inDegrees of a vertex
     */
    public int getDegree() 
    {
    	return this.inDegree;
    }
    /**
     * increments the in degree of a vertex
     */
    public void incrementInDegree() 
    {
    	this.inDegree++;
    }
    /**
     * decrements the in degree of a vertex
     */
    public void decrementInDegree() 
    {
		this.inDegree--;
	}
    /**
     * Compares vertices by current distance so returns the closest in Dkjistra's algorithm. Uses descending order.
     */
    @Override
    public int compareTo(Vertex<Type> other) 
    {
        return Double.compare(other.distance, this.distance);
    }
}

