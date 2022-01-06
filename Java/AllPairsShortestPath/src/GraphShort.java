import java.io.*;
import java.util.*;

public class GraphShort {
	private final static int INFINITY = 6999999; //Haha funny number
	public static void main(String[] args) {
		FastReader f = new FastReader();
		while(true) {
			int n = f.nextInt(), m = f.nextInt(), q = f.nextInt(); //n = node, m = edges, q = queries
			if(n == 0 && m == 0 && q == 0)
				break;
			int[][] distance = new int[n][n];
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < n; j++) 
					distance[i][j] = (i == j ? 0 : INFINITY);
			for(int i = 0; i < m; i++) {
				int u = f.nextInt(), v = f.nextInt(), w = f.nextInt();
				distance[u][v] = (w < distance[u][v] ? w : distance[u][v]);
			}
			//Floyd warshall, All-Pairs shortest Path
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < n; j++) 
					for(int k = 0; k < n; k++) 
						if(distance[j][k] > distance[j][i] + distance[i][k] && distance[j][i] < INFINITY && 
								distance[i][k] < INFINITY) 
							distance[j][k] = distance[j][i] + distance[i][k];
			//Negative paths
			for (int i=0;i<n;i++)
				for (int j=0;j<n;j++)
					for (int k=0;distance[i][j]!=-INFINITY && k<n;k++)
						if (distance[k][k]<0 && distance[i][k]!=INFINITY && distance[k][j]!=INFINITY)
							distance[i][j] = -INFINITY;
			//Queries
			for(int i = 0; i < q; i++) {
				int u = f.nextInt(), v = f.nextInt();
				if(distance[u][v] == INFINITY) 
					System.out.println("Impossible");
				else if(distance[u][v] == -INFINITY) 
					System.out.println("-Infinity");
				else {
					System.out.println(distance[u][v]);
				}
			}
			System.out.println();
		}
	}
}
class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
