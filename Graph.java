package assign07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Graph<Type> {
    private HashMap<Type, Vertex<Type>> vertices;
   
    
    /*
     * Makes an empty graph
     */
    public Graph() {
    	vertices = new HashMap<>();
    }
    /*
     * Adds directed weighted edge with srcData and if one does not exist, it creates one.
     * 
     * @param srcData - data of the source vertex
     * @param dstData - data of destination vertex
     * @param weight - weight of the edge
     */
    public void addEdge(Type srcData, Type dstData, double weight) {
    	Vertex<Type> source = getOrCreateVertex(srcData);
    	Vertex<Type> destination = getOrCreateVertex(dstData);
    	
    	source.addEdge(destination, weight);
    }
    
    /*
     * Adds directed unweighted edge and sets the default weight to 1.0
     * 
     * @param srcData - starting data
     * @param dstData - destination data
     */
    public void addEdge(Type srcData, Type dstData) {
    	addEdge(srcData, dstData, 1.0);
    }
    
    /*
     * Gets vertex with the given data
     * 
     * @param data - data of the vertex
     * @return 	the vertex with given data
     * @throws IllegalArgumentException if no vertex with data exists in the graph
     */
    public Vertex<Type> getVertex(Type data) {
    	if (!vertices.containsKey(data)) {
			throw new IllegalArgumentException("No vertex with data " + data + " exists in the graph.");
		}
		return vertices.get(data);
    }
    
    /*
     *  Gets vertex if it exists, else creates the vertex
     *  
     *  @param data of the vertex being searched or created
     */
    public Vertex<Type> getOrCreateVertex(Type data) {
    	if (!vertices.containsKey(data)) {
			vertices.put(data, new Vertex<Type>(data));
		}
		return vertices.get(data);
    }
    
    /**
	 * Resets the distance, previous, visited, and in-degree of every vertex 
	 */
	private void resetVertices() {
		for (Vertex<Type> vertex : vertices.values()) {
			vertex.resetState();
		}
	}
    
    
    
    public List<Type> breadthFirstSearch(Type source, Type destination) {
		return null; 
    	
    }
    public List<Type> dijkstrasAlgorithm(Type source, Type destination) {
		return null; 
    	
    }
    public List<Type> topoSort() {
		return null; 
    	
    }

    
}


