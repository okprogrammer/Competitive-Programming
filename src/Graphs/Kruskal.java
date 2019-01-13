package Graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int source;
	int dest;
	int weight;

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

}

public class Kruskal {

	private static void kruskal(Edge[] edges, int n) {
		Arrays.sort(edges);

		Edge[] output = new Edge[n - 1];

		int parent[] = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int count = 0;
		int i = 0;
		while (count != n - 1) {
			Edge currentEdge = edges[i];

			int sourceParent = findParent(currentEdge.source, parent);
			int destParent = findParent(currentEdge.dest, parent);

			if (sourceParent != destParent) {
				output[count] = currentEdge;
				parent[sourceParent] = destParent;
				count++;
			}
			i++;
		}
		
		for (int j = 0; j < output.length; j++) {
			if(output[j].source<output[j].dest) {
				System.out.println(output[j].source+" "+output[j].dest+" "+output[j].weight);
			}else {
				System.out.println(output[j].dest+" "+output[j].source+" "+output[j].weight);
			}
		}

	}

	private static int findParent(int v, int[] parent) {
		if(parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			edges[i] = new Edge();
			edges[i].source = sc.nextInt();
			edges[i].dest = sc.nextInt();
			edges[i].weight = sc.nextInt();
		}

		kruskal(edges, V);
	}

}
