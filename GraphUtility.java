package assign07;
import java.util.List;
/**
 * This class provides ulities for a graph. This class contains only 
 * drivers for the grapg class
 *
 * @author Abhinav Mishra and Thakshbir Singh Dhillon
 * @version October 28, 2026
 */
public class GraphUtility<Type>
{
	/**
	 * uses BFS to find the shortest path from a source to a destination.
	 * @param <Type> the type of tha data a vertex holds
	 * @param sources different sources of edges
	 * @param destinations different destination of edges
	 * @param srcData the source of the BFS
	 * @param dstData the destination of the BFS
	 * @return a list of the shortest path of the vertexes from the src to the dst.
	 */
	public static <Type> List<Type> shortestPath(List<Type> sources, List<Type> destinations, Type srcData, Type dstData)
	{
		if (sources.size() != destinations.size()) 
		{ 
			throw new IllegalArgumentException( "Sources and destinations must have the same size." );
		}
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++) 
		{ 
			graph.addEdge(sources.get(i), destinations.get(i)); 
		}
		return graph.breadthFirstSearch(srcData, dstData);
	}
	/**
	 * uses dijkstras Algorithm to find the shortest weighted path from a source to a destination.
	 * @param <Type> the type of tha data a vertex holds
	 * @param sources different sources of edges
	 * @param destinations different destination of edges
	 * @param weights different weights of the edges
	 * @param srcData the source of the dijkstras Algorithm
	 * @param dstData the destination of the dijkstras Algorithm
	 * @return a list of the shortest weighted path of the vertexes from the src to the dst.
	 */
	public static <Type> List<Type> shortestWeightedPath(List<Type> sources, List<Type> destinations, List<Double> weights, Type srcData, Type dstData)
	{
		if (sources.size() != destinations.size()) 
		{ 
			throw new IllegalArgumentException( "Sources, destinations and weights must have the same size." );
		}
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++) 
		{ 
			graph.addEdge(sources.get(i), destinations.get(i),weights.get(i)); 
		}
		return graph.dijkstrasAlgorithm(srcData, dstData);
	}
	/**
	 * uses topological sort on a graph
	 * @param <Type> The type of the data held by a vertex
	 * @param sources different sources of edges
	 * @param destinations different destination of edges
	 * @throws IllegalArgumentException  if the graph contains a cycle
	 * @return a list of sorted vertexs of a grapg
	 */
	public static <Type> List<Type> sort(List<Type> sources, List<Type> destinations)
	{
		if (sources.size() != destinations.size()) 
		{ 
			throw new IllegalArgumentException( "Sources, destinations and weights must have the same size." );
		}
		Graph<Type> graph = new Graph<>();
		for (int i = 0; i < sources.size(); i++) 
		{ 
			graph.addEdge(sources.get(i), destinations.get(i)); 
		}
		return graph.topoSort();
	}
}
