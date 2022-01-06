package baltic;

import java.io.*;
import java.util.*;

public class emptyLikeMe {
	static int[] waterX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] waterY = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int r, c;

	public static void main(String[] args) throws FileNotFoundException {
		FastReader f = new FastReader();
		r = f.nextInt();
		c = f.nextInt();
		long[][] grid = new long[r][c];
		entry[][] depth = new entry[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				grid[i][j] = f.nextInt();

		int devRow = f.nextInt() - 1;
		int devCol = f.nextInt() - 1;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				depth[i][j] = new entry(i, j, 0);
		depth[devRow][devCol] = new entry(devRow, devCol, (int) grid[devRow][devCol]);
		long total = 0;
		PriorityQueue<entry> pq = new PriorityQueue<>();
		pq.offer(depth[devRow][devCol]);
		boolean[][] used = new boolean[r][c];
		// Start algorithm
		while (pq.size() > 0) {
			entry current = pq.poll();
			if (used[current.r][current.c])
				continue;
			if (grid[current.r][current.c] > 0)
				break;
			total -= current.d;
			used[current.r][current.c] = true;
			// Check if neighbors can be drained
			for (int i = 0; i < waterX.length; i++) {
				int checkX = current.r + waterX[i], checkY = current.c + waterY[i];
				if (!inBounds(checkX, checkY))
					continue;
				if (!used[checkX][checkY] && depth[checkX][checkY].d <= 0) {
					if (depth[checkX][checkY].d > current.d) {
						depth[checkX][checkY].d = Math.max(current.d, (int) grid[checkX][checkY]);
						pq.offer(depth[checkX][checkY]);
					}
				}
			}
		}

		System.out.println(total);
	}

	static boolean inBounds(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
}

class entry implements Comparable<entry> {
	int r, c, d;

	public entry(int row, int col, int dep) {
		r = row;
		c = col;
		d = dep;
	}

	public int compareTo(entry e) {
		return this.d - e.d;
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
