package Graphs;

import java.util.Scanner;

public class Prims {

	private static void prims(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean[] visited = new boolean[v];
		int[] weight = new int[v];
		int[] parent = new int[v];
		weight[0] = 0;
		parent[0] = -1;
		for (int i = 1; i < v; i++) {
			weight[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < v; i++) {

			int minVertex = findMinVertex(weight, visited);
			visited[minVertex] = true;

			for (int j = 0; j < v; j++) {
				if (!visited[j] && adjacencyMatrix[minVertex][j] != 0) {
					if(adjacencyMatrix[minVertex][j]<weight[j]) {
						weight[j] = adjacencyMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		
		for(int i=1;i<v;i++) {
			if(parent[i]<i) {
				System.out.println(parent[i]+" "+i+" "+weight[i]);
			}else {
				System.out.println(i+" "+parent[i]+" "+weight[i]);
			}
		}

	}

	private static int findMinVertex(int[] weight, boolean[] visited) {
		int minVertex = -1;
		for (int i = 0; i < weight.length; i++) {
			if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] adjacencyMatrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			int weight = sc.nextInt();
			adjacencyMatrix[fv][sv] = weight;
			adjacencyMatrix[sv][fv] = weight;
		}

		prims(adjacencyMatrix);
	}

}
