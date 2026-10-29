package assign07;
/**
 * This class represents an edge between two vertices in a graph.
 *
 * @author Abhinav Mishra and Thakshbir Singh Dhillon
 * @version October 28, 2026
 */
class Edge<Type> 
{
    private Vertex<Type> destination;
    private double weight; //  for Dijkstra
    
    /**
     * Creates an edge to a given vertex with given weight
     * 
     * @param destination the vertex points to
     * @param weight of the edge
     */
    public Edge(Vertex<Type> destination, double weight) 
    {
    	this.destination = destination;
    	this.weight = weight;
    }
    /**
     * getter method for the vertex destination
     * 
     * @return a vertex that connects the edge
     */
    public Vertex<Type> getDestination() 
    {
    	return destination;
    }
    /**
     * Getter method for the edge weight
     * 
     * @return the weight of an edge represented by a double
     */
    public double getWeight() 
    {
    	return weight;
    }
    
    /**
     * Returns a string like B (2.0) using the destination's data
     * 
     * @return a string representation of the edge
     */
    @Override
    public String toString()
    {
    	return destination.getData() + " (" + weight + ")";
    }
}