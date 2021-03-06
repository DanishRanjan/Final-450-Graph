import java.util.*;
import java.util.*;
public class IntroductionToGraph {
	
static class Edge{
		int source;
		int neighbor;
		int weight;
		
		Edge(int source, int neighbor, int weight){
			this.source = source;
			this.neighbor = neighbor;
			this.weight = weight;
		}
		
	}
	
public static void main(String args[]) throws Exception {
	int vertices = 7; //0, 1, 2, 3, 4, 5, 6
	ArrayList<Edge>[] graph = new ArrayList[7];
	for(int i = 0 ; i<vertices;i++) {
		graph[i] = new ArrayList<Edge>(); //empty arrayList in front of every array 
	}
	
	graph[0].add(new Edge(0, 3, 40));
	graph[0].add(new Edge(0, 1, 10));
	
	graph[1].add(new Edge(1, 0, 10));
	graph[1].add(new Edge(1, 2, 10));
	
	graph[2].add(new Edge(2, 3, 40));
	graph[2].add(new Edge(2, 1, 40));
	
	graph[3].add(new Edge(3, 0, 40));
	graph[3].add(new Edge(3, 2, 10));
	graph[3].add(new Edge(3, 4, 2));
	
	graph[4].add(new Edge(4, 3, 2));
	graph[4].add(new Edge(4, 5, 3));
	graph[4].add(new Edge(4, 6, 3));
	
	graph[5].add(new Edge(5, 4, 3));
	graph[5].add(new Edge(5, 6, 3));
	
	graph[6].add(new Edge(6, 5, 3));
	graph[6].add(new Edge(6, 4, 8));
	
	
	
}
}
