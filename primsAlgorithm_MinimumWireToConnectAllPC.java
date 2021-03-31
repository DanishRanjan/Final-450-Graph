import java.io.*;
import java.util.*;

public class primsAlgorithm_MinimumWireToConnectAllPC {
	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	static class pair implements Comparable<pair> {
		int vertex;
		int acquirigVertex;
		int wt;

		pair(int vertex, int acquirigVertex, int wt) {
			this.vertex = vertex;
			this.acquirigVertex = acquirigVertex;
			this.wt = wt;
		}

		public int compareTo(pair o) {
			return this.wt - o.wt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		// write your code here
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.add(new pair(0, -1, 0));
		boolean[] visited = new boolean[vtces];
		while (pq.size() > 0) {
			pair remove = pq.remove(); //remove

			if (visited[remove.vertex] == true) {
				continue;
			}
			visited[remove.vertex] = true;//markStar
			
			if (remove.acquirigVertex != -1) {
				System.out.println("[" + remove.vertex + "-" + remove.acquirigVertex + "@" + remove.wt + "]");
			}//Work

			for (Edge e : graph[remove.vertex]) //addStar
			{
				if (visited[e.nbr] == false)
				{
					pq.add(new pair(e.nbr, remove.vertex, e.wt));
				}
			}
		}

	}

}