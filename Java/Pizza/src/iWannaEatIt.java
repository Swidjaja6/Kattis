import java.io.*;
import java.util.*;

public class iWannaEatIt {
	public static void main(String[] args) throws FileNotFoundException {
		FastReader f = new FastReader();
		int tc = f.nextInt();
		while (tc-- > 0) {
			int deliveries = 0;
			int y = f.nextInt(), x = f.nextInt();
			int[][] grid = new int[x][y];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					grid[i][j] = f.nextInt();
					deliveries += grid[i][j];
				} 
			}// Reading is finished here
			int centerRow = getCenterRow(x, y, deliveries, grid);
			int centerCol = getCenterCol(x, y, deliveries, grid);
			int cost = 0;
			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++) {
					int dist = Math.abs(centerRow - i) + Math.abs(centerCol - j);
					cost += (dist * grid[i][j]);
				}
			System.out.println(cost + " blocks");
		}
	}

	private static int getCenterCol(int rows, int cols, int numDel, int[][] grid) {
		int cSum = 0;
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				cSum += grid[i][j];
				if (cSum >= numDel / 2) {
					return j;
				}
			}
		}
		return 0;
	}

	public static int getCenterRow(int rows, int cols, int numDel, int[][] grid) {
		int rSum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				rSum += grid[i][j];
				if (rSum >= numDel / 2) {
					return i;
				}
			}
		}
		return 0;
	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() throws FileNotFoundException {
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
