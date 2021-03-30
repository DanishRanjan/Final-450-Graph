import java.io.*;
import java.util.*;

public class isCyclic_Graph {
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

	static class pair {
		int vertex;
		String psf;

		pair(int vertex, String psf) {
			this.vertex = vertex;
			this.psf = psf;
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
		boolean[] visited = new boolean[vtces];
		for (int v = 0; v < vtces; v++) {
			if (visited[v] == false) {
				// traversal
				boolean cycle = isCyclic(graph, v, visited);
				if (cycle) {
					System.out.println(true);
				} else {
					System.out.println(false);
				}
			}
		}

	}

	public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
		ArrayDeque<pair> queue = new ArrayDeque<>();
		queue.add(new pair(src, src + ""));

		while (queue.size() > 0) {
			// remove markStar Work AddStar
			pair rem = queue.remove();
			if (visited[rem.vertex] == true) {
				return true;
			}
			visited[rem.vertex] = true;

			for (Edge e : graph[rem.vertex]) {
				if (visited[e.nbr] == false) {
					queue.add(new pair(e.nbr, rem.psf + e.nbr));
				}
			}
		}
		return false;
	}

}