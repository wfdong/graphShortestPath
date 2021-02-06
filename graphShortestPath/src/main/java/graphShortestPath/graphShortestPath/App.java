package graphShortestPath.graphShortestPath;

import java.util.HashMap;
import java.util.Map;

/**
 * use dijkstra algorithm to calculate the shortest path
 *
 */
public class App 
{
	public static final int M = Integer.MAX_VALUE >> 1; // means can't be reachable directly

	public static void main(String[] args) {
		// Every line is the distance values from A,B,C,D,E,F,G to A,B,C,D,E,F,G,
		// e.g A -> A distance is 0, A -> B distance is 3, G -> E distance is 2, M means
		// can't be reachable directly
		int[][] weight = {
			   // A  B  C  D  E  F  G
				{ 0, 3, 1, M, 2, M, M }, // A
				{ 3, 0, M, 6, 4, 3, M }, // B
				{ 1, M, 0, M, 5, M, M }, // C
				{ M, 6, M, 0, M, 2, M }, // D
				{ 2, 4, 5, M, 0, M, 2 }, // E
				{ M, 3, M, 2, M, 0, 1 }, // F
				{ M, M, M, M, 2, 1, 0 } // G
		};
		int start = 0;
		Map<Integer, String> indexMap = new HashMap<Integer, String>();
		indexMap.put(0, "A");
		indexMap.put(1, "B");
		indexMap.put(2, "C");
		indexMap.put(3, "D");
		indexMap.put(4, "E");
		indexMap.put(5, "F");
		indexMap.put(6, "G");

		dijkstraCalculate(indexMap, weight, start);
	}

	/*
	 * @Parameter indexMap : a map used to map index to Node names, make it easier
	 * to read
	 * 
	 * @Parameter weight : the distances matrix
	 * 
	 * @Parameter start : the node we start to search(0 means start from A, 1 means
	 * start from B, 2->C, 3->D, 4->E, 5->F, 6->G)
	 * 
	 * @Return int[] shortestPath : store the shortest values from start node to all
	 * the other nodes we calculated
	 */
	public static void dijkstraCalculate(Map<Integer, String> indexMap, int[][] weight, int start) {
		int n = weight.length; // total node number
		int[] shortestPath = new int[n]; // store the shortest values from start node to all the other nodes we
											// calculated
		String[] path = new String[n]; // store the nodes we calculated(to make the result easier to read)
		for (int i = 0; i < n; i++) {
			path[i] = indexMap.get(start) + "-->" + indexMap.get(i);
		}
		int[] visited = new int[n]; // to identify whether a specific node's shortest path have been calculated or
									// nor, 1->yes, 0->not yet

		// initialize, we know the first element's shortest path(it's to itself)
		shortestPath[start] = 0;
		visited[start] = 1;
		for (int count = 1; count < n; count++) { // to calculate the left n-1 nodes
			// to select a node that has the shortest path to the already known(already
			// calculated nodes), this time it's node A
			int k = -1;
			int minDistance = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][i] < minDistance) {
					minDistance = weight[start][i];
					k = i;
				}
			}

			// this calculated distance is the shortest path to start node A, and put it
			// into result shortestPath
			shortestPath[k] = minDistance;
			visited[k] = 1;

			// according to node k, modify/update the results from start to all other nodes
			// which not being visited
			for (int i = 0; i < n; i++) {
				// e.g if distance(A->B) + distance(B->C) < distance(A->C), then need to update
				// the results
				if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
					weight[start][i] = weight[start][k] + weight[k][i];
					path[i] = path[k] + "-->" + indexMap.get(i);
				}
			}
		}

		// print out the results
		for (int i = 0; i < n; i++) {
			System.out.println(
					"From " + indexMap.get(start) + " to " + indexMap.get(i) + ", the shortest path is: " + path[i]);
		}
		System.out.println("*****************************************************************************");
		for (int i = 0; i < shortestPath.length; i++) {
			System.out.println("From " + indexMap.get(start) + " to " + indexMap.get(i)
					+ ", the shortest path value is：" + shortestPath[i]);
		}
	}
}
