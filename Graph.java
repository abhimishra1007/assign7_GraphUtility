package assign07;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This class represents a graph and performs sorts and searches using a linked list.
 *
 * @author Abhinav Mishra and Thakshbir Singh Dhillon
 * @version October 28, 2026
 */
public class Graph<Type> 
{
	private LinkedList<Vertex<Type>> vertices;
    /**
     * Makes an empty graph
     */
    public Graph() 
    {
    	vertices = new LinkedList<>();
    }
    /**
     * Adds directed weighted edge with srcData and if one does not exist, it creates one.
     * 
     * @param srcData - data of the source vertex
     * @param dstData - data of destination vertex
     * @param weight - weight of the edge
     */
    public void addEdge(Type srcData, Type dstData, double weight) 
    {
    	Vertex<Type> source = getOrCreateVertex(srcData);
    	Vertex<Type> destination = getOrCreateVertex(dstData);
    	source.addEdge(destination, weight);
    }
    /**
     * Adds directed unweighted edge and sets the default weight to 1.0
     * 
     * @param srcData - starting data
     * @param dstData - destination data
     */
    public void addEdge(Type srcData, Type dstData) 
    {
    	addEdge(srcData, dstData, 1.0);
    }
    
    /**
     * Gets vertex with the given data
     * 
     * @param data - data of the vertex
     * @return 	the vertex with given data
     * @throws IllegalArgumentException if no vertex with data exists in the graph
     */
    public Vertex<Type> getVertex(Type data) 
    {
    	for (Vertex<Type> vertex : vertices) 
    	{ 
    		if (vertex.getData().equals(data)) 
    		{ 
    			return vertex; 
    		}
    	}
    	throw new IllegalArgumentException( "No vertex with data " + data + " exists in the graph." );
    }
    
    /**
     *  Gets vertex if it exists, else creates the vertex
     *  
     *  @param data of the vertex being searched or created
     */
    public Vertex<Type> getOrCreateVertex(Type data) 
    {
    	for (Vertex<Type> vertex : vertices) 
    	{ 
    		if (vertex.getData().equals(data)) 
    		{ 
    			return vertex;
    		} 
    	}
    	Vertex<Type> vertex = new Vertex<>(data);
    	vertices.add(vertex); 
    	return vertex;
    }
    
    /**
	 * Resets the distance, previous, visited, and in-degree of every vertex 
	 */
	private void resetVertices() 
	{
		for (Vertex<Type> vertex : vertices) 
		{ 
			vertex.resetState(); 
		}
	}
    /**
     * porforms a breadthfirst search on the graph using a queue and a linked list.
     * @param source the source data of the vertex to start with
     * @param destination the distination data of the vertex to end with
     * @return a list of the shortest path performed by BFS
     */
    public List<Type> breadthFirstSearch(Type source, Type destination) 
    {
    	resetVertices();
    	Vertex<Type> startVertex = getVertex(source);
    	Vertex<Type> endVertex = getVertex(destination);
    	Queue<Vertex<Type>> queue = new LinkedList<Vertex<Type>>();
    	startVertex.setDistance(0);
    	queue.offer(startVertex);
    	while(!queue.isEmpty()) 
    	{
    		Vertex<Type> currentVertex = queue.poll();
    		if(currentVertex == endVertex) 
    		{
    			break;
    		}
    		for(Edge<Type> edge: currentVertex.getEdges()) 
    		{
    			Vertex<Type> neighbor = edge.getDestination();
    			if(neighbor.getDistance() == Double.POSITIVE_INFINITY) //if not visited
    			{
    				neighbor.setDistance(currentVertex.getDistance() + 1);
    				neighbor.setPrevious(currentVertex);
    				queue.offer(currentVertex);//putting neighbor to the queue
    			}
    		}
    	}
    	if (endVertex.getDistance() == Double.POSITIVE_INFINITY) 
    	{ 
    		throw new IllegalArgumentException( "No path exists between these vertices." ); 
    	}
    	//making the path from last to first
    	LinkedList<Type> path = new LinkedList<>(); 
    	Vertex<Type> current = endVertex;
    	while (current != null) 
    	{ 
    		path.addFirst(current.getData()); 
    		current = current.getPrevious(); 
    	}
    	return path;
    }
    /**
     * performs a dijkstras Algorithm alternative on the graph using a priority list and a linked list to make a path.
     * @param source  the source data of the vertex to start with
     * @param destination the distination data of the vertex to end with
     * @return a list of the shortest path performed by dijkstrasAlgorithm*
     */
    public List<Type> dijkstrasAlgorithm(Type source, Type destination) 
    {
    	resetVertices();
    	Vertex<Type> startVertex = getVertex(source);
    	Vertex<Type> endVertex = getVertex(destination);
    	LinkedList<Vertex<Type>> unvisitedList = new LinkedList<>();
    	startVertex.setDistance(0);
    	for (Vertex<Type> vertex : vertices) 
    	{ 
    		vertex.setDistance(Double.POSITIVE_INFINITY); 
    		unvisitedList.add(vertex); 
    	}
    	while(!unvisitedList.isEmpty()) 
    	{
    		//the compare sorts in descending order, will keep sorting until the priority queue ends
    		unvisitedList.sort((v1, v2) -> Double.compare(v2.getDistance(), v1.getDistance()) );
    		Vertex<Type> last = unvisitedList.getLast();
    		if(last == endVertex) 
    		{
    			break;
    		}
    		for(Edge<Type> edge: last.getEdges()) 
    		{
    			Vertex<Type> neighbor = edge.getDestination();
    			if((unvisitedList.contains(neighbor)))
    			{
    				double newDistance = last.getDistance() + edge.getWeight();
    				if (newDistance < neighbor.getDistance()) 
    				{ 
    					neighbor.setDistance(newDistance); 
    					neighbor.setPrevious(last); 
    				}
    			}
    			
    		}
    		unvisitedList.removeLast();
    	}
    	if (endVertex.getDistance() == Double.POSITIVE_INFINITY)
    	{ 
    		throw new IllegalArgumentException( "No path exists between these vertices." ); 
    	} 
    	LinkedList<Type> path = new LinkedList<>();
    	Vertex<Type> current = endVertex; 
    	while (current != null) 
    	{ 
    		path.addFirst(current.getData()); 
    		current = current.getPrevious(); 
    	} 
    	return path;
    }
    /**
     * performs a topological search on a graph using linked lists and queues.
     * @return a list of sorted vertexes in a graph
     */
    public List<Type> topoSort() 
    {
        resetVertices();
        for (Vertex<Type> vertex : vertices) 
        {
            for (Edge<Type> edge : vertex.getEdges()) 
            {
                edge.getDestination().incrementInDegree();
            }
        }
        Queue<Vertex<Type>> queue = new LinkedList<>();
        for (Vertex<Type> vertex : vertices) 
        {
            if (vertex.getDegree() == 0) 
            {
                queue.offer(vertex);
            }
        }
        LinkedList<Type> result = new LinkedList<>();
        while (!queue.isEmpty()) 
        {
            Vertex<Type> current = queue.poll();
            result.add(current.getData());
            for (Edge<Type> edge : current.getEdges()) 
            {
                Vertex<Type> neighbor = edge.getDestination();
                neighbor.decrementInDegree();
                if (neighbor.getDegree() == 0) 
                {
                    queue.offer(neighbor);
                }
            }
        }
        // If some vertices remain, the graph contains a cycle.
        if (result.size() != vertices.size()) 
        {
            throw new IllegalArgumentException("Graph contains a cycle." );
        }
        return result;
    }
 }
    



