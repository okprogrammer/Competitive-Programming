package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

	private static Scanner s;
	// DFS Traversal

	public static void printHelper(int edges[][], int sv, boolean[] visited) {
		System.out.println(sv);

		int n = edges.length;
		visited[sv] = true;
		for (int i = 0; i < n; i++) {
			if (edges[sv][i] == 1 && !visited[i]) {
				printHelper(edges, i, visited);
			}
		}
	}
	
	static void print(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				printHelper(edges, i, visited);
			}

		}

	}

	

	static boolean hasPath(int[][] edges, int start, int end, boolean[] visited) {
		if (start == end) {
			return true;
		}
		visited[start] = true;
		for (int i = 0; i < edges.length; i++) {
			if (edges[start][i] == 1 && !visited[i]) {
				return hasPath(edges, i, end, visited);
			}
		}
		return false;
	}

	static boolean hasPathHelper(int[][] edges, int start, int end) {
		boolean[] visited = new boolean[edges.length];
		if (start == end) {
			return true;
		} else {
			return hasPath(edges, start, end, visited);
		}

	}

	private static void printHelperBFS(int[][] edges, int sv, boolean[] visited) {

		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(sv);
		visited[sv] = true;
		while (!queue.isEmpty()) {
			int front;
			try {
				front = queue.removeFirst();
			} catch (Exception e) {
				return;
			}

			System.out.println(front);
			for (int i = 0; i < edges.length; i++) {
				if (edges[front][i] == 1 && !visited[i]) {
					queue.addLast(i);
					visited[i] = true;
				}
			}

		}

	}
	
	static void printBFS(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				printHelperBFS(edges, i, visited);
			}

		}

	}

	

	static ArrayList<Integer> getDFSHelper(int[][] edges, int fv, int ev, ArrayList<Integer> list, boolean[] visited) {
		list.add(fv);
		if (fv == ev) {
			return list;
		}

		visited[fv] = true;
		for (int i = 0; i < edges.length; i++) {
			if (edges[fv][i] == 1 && !visited[i]) {
				return getDFSHelper(edges, i, ev, list, visited);
			}
		}
		return new ArrayList<>();
	}

	static ArrayList<Integer> getDFS(int[][] edges, int fv, int ev) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[edges.length];
		return getDFSHelper(edges, fv, ev, list, visited);

	}

	static LinkedList<Integer> getBFS(int[][] edges, int fv, int ev) {
		boolean[] visited = new boolean[edges.length];
		return getBFSHelper(edges, fv, ev, visited);

	}

	private static LinkedList<Integer> getBFSHelper(int[][] edges, int fv, int ev, boolean[] visited) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(fv);
		visited[fv] = true;
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean done = false;
		while (!queue.isEmpty() && !done) {
			int front = queue.removeFirst();
			for (int i = 0; i < edges.length; i++) {
				if (edges[front][i] == 1 && !visited[i]) {
					map.put(i, front);
					queue.addLast(i);
					visited[i] = true;
					if (i == ev) {
						done = true;
						break;
					}
				}

			}
		}
		if (!done) {
			return new LinkedList<>();
		} else {
			LinkedList<Integer> output = new LinkedList<Integer>();
			int current = ev;
			output.addLast(ev);
			while (current != fv) {
				current = map.get(current);
				output.addLast(current);

			}
			return output;
		}

	}

	public static void main(String[] args) {

		s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int[][] edges = new int[n][n];

		for (int i = 0; i < e; i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		int start = s.nextInt();
		int end = s.nextInt();
		/*
		 * print(edges); System.out.println(); printBFS(edges);
		 * System.out.println(hasPathHelper(edges,start,end)); System.out.println();
		 * ArrayList<Integer> list = getDFS(edges,start,end); Collections.reverse(list);
		 * for(int i:list) { System.out.print(i+" "); }
		 */
		LinkedList<Integer> list = getBFS(edges, start, end);
		if (!list.isEmpty()) {
			for (int i : list) {
				System.out.print(i + " ");
			}
		}

	}

}
