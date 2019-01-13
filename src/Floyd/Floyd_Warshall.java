package Floyd;

public class Floyd_Warshall {
	
	private static final int INF = 9999;

	static void floyd(int[][] arr) {
		int n = arr.length;
		
		int[][] dist = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dist[i][j] = arr[i][j];
			}
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dist[i][j] = min(dist[i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
		
		print(dist);
		
	}

	private static void print(int[][] dist) {
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				if(dist[i][j]>INF) {
					System.out.print("Infinity"+" ");
				}else {
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println();
			
		}
		
	}

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i<j) {
			return i;
		}else {
			return j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{0,3,INF,7},
				{8,0,2,INF},
				{5,INF,0,1},
				{2,INF,0,1},
		};
		
		floyd(arr);

	}

}
