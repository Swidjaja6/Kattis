package tenKinds;

import java.io.*;
import java.util.*;

public class mainly {
	static int[] R = { 1, -1, 0, 0 };
	static int[] C = { 0, 0, 1, -1 };

	public static void bfs(Point start, char[][] map, int[][] group, int fill) {
		ArrayList<Point> queue = new ArrayList<>();
		queue.add(start);
		group[start.r][start.c] = fill;
		while (!queue.isEmpty()) {
			Point current = queue.remove(0);
			int r = current.r;
			int c = current.c;
			for (int i = 0; i < 4; i++) {
				int tryR = r + R[i];
				int tryC = c + C[i];
				if(tryR >= 0 && tryR < map.length && tryC >= 0 && tryC < map[0].length) {
					if(map[tryR][tryC] == map[r][c] && group[tryR][tryC] != fill) {
						group[tryR][tryC] = fill;
						queue.add(new Point(tryR, tryC));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		FastReader f = new FastReader();
		int rows = f.nextInt();
		int col = f.nextInt();
		char[][] map = new char[rows][col];
		for (int i = 0; i < rows; i++)
			map[i] = f.next().toCharArray();
		int[][] group = new int[map.length][map[0].length];
		int fill = 2;
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < col; j++) 
				if (group[i][j] == 0) {
					bfs(new Point(i, j), map, group, fill);
					fill++;
				}
		int queries = f.nextInt();
		for(int i = 0; i < queries; i++) {
			int r1 = f.nextInt() - 1;
			int c1 = f.nextInt() - 1;
			int r2 = f.nextInt() - 1;
			int c2 = f.nextInt() - 1;
			if(group[r1][c1] == group[r2][c2])
				System.out.println(map[r1][c1] == '1' ? "decimal" : "binary");
			else 
				System.out.println("neither");
		}
	}
}

class Point {
	int r, c;

	public Point(int a, int b) {
		r = a;
		c = b;
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
