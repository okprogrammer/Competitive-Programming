package Greedy;

import java.util.*;


class Job implements Comparable<Job>{
	String job;
	int deadline;
	int profit;
	public Job(String job, int deadline, int profit) {
		this.job = job;
		this.deadline = deadline;
		this.profit = profit;
	}

	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return this.profit - o.profit;
	}

}

public class JobSequencing {

	static void jobSequencing(Job[] arr,int n) {
		Arrays.sort(arr);
		int[] result = new int[n];
		boolean[] slot = new boolean[n];
		for(int i=0;i<n;i++) {
			for(int j=min(n,arr[i].deadline)-1;j>=0;j--) {
				if(slot[j]) {
					result[j] = i;
					slot[j] = true;
					break;
				}
			}
		}
		for(int i=0;i<n;i++) {
			if(slot[i]) {
				System.out.print(arr[result[i]].job);
			}
		}
	}

	private static int min(int a, int b) {
		if(a<b) {
			return a;
		}else {
			return b;
		}
	}

	public static void main(String[] args) {
		Job arr[] = new Job[4];
		arr[0] = new Job("job1", 2, 100);
		arr[1] = new Job("job2", 1, 100);
		arr[2] = new Job("job3", 2, 100);
		arr[3] = new Job("job4", 3, 100);
		jobSequencing(arr,4);
	}

}
