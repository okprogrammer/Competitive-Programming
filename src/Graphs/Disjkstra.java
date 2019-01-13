package Graphs;

import java.util.Scanner;

public class Disjkstra {

	private static int findMinVertex(int[] distance, boolean[] visited) {
		int minVertex = -1;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	private static void disjkstra(int[][] edges) {
		int v = edges.length;
		boolean[] visited = new boolean[v];
		int[] dist = new int[v];
		dist[0] = 0;
		int[] parent = new int[v];
		parent[0] = -1;
		for (int i = 1; i < v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < v; i++) {
			int minVertex = findMinVertex(dist, visited);
			visited[minVertex] = true;
			for (int j = 0; j < v; j++) {
				if (!visited[j] && edges[minVertex][j] != 0 && dist[minVertex]!=Integer.MAX_VALUE) {
					if (dist[minVertex] + edges[minVertex][j] < dist[j]) {
						parent[j] = minVertex;
						dist[j] = dist[minVertex] + edges[minVertex][j];
					}
				}

			}
		}
		for(int i=0;i<v;i++) {
				System.out.println(i+" "+dist[i]);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int V = s.nextInt();
		int E = s.nextInt();

		int[][] edges = new int[V][V];

		for (int i = 0; i < E; i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			int weight = s.nextInt();
			edges[fv][sv] = weight;
			edges[sv][fv] = weight;
		}

		disjkstra(edges);

	}

}
