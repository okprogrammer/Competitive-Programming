package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConnectGraph {

	static ArrayList<Integer> visitConnected(int[][] edges, int start, boolean[] visited, ArrayList<Integer> list) {
		visited[start] = true;
		list.add(start);
		for (int i = 0; i < edges.length; i++) {
			if (edges[start][i] == 1 && !visited[i]) {
				visitConnected(edges, i, visited, list);
			}

		}
		return list;
	}

	static ArrayList<ArrayList<Integer>> visitConnected(int[][] edges) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		boolean[] visited = new boolean[edges.length];
		int k = 0;
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				ArrayList<Integer> list1 = new ArrayList<Integer>();
				list.add(k, visitConnected(edges, i, visited, list1));
				k++;
			}
		}
		return list;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] edges = new int[V][V];
		for (int i = 0; i < E; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}

		ArrayList<ArrayList<Integer>> list = visitConnected(edges);
		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
