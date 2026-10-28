package assign07;

class Edge<Type> {
    Vertex<Type> destination;
    double weight;          // Dijkstra
    
    
    /*
     * Creates an edge to a given vertex with given weight
     * 
     * @param destination the vertex points to
     * @param weight of the edge
     */
    public Edge(Vertex<Type> destination, double weight) {
    	this.destination = destination;
    	this.weight = weight;
    }
    
    public Vertex<Type> getDestination() {
    	return destination;
    }
    
    public double getDouble() {
    	return weight;
    }
    
    /*
     * Returns a string like B (2.0) using the destination's data
     */
    @Override
    public String toString() {
    	return destination.getData() + " (" + weight + ")";
    }
}