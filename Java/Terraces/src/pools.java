import java.util.*;
import java.io.*;

public class pools {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		int col = s.nextInt(), row = s.nextInt();
		Node[][] yard = new Node[row][col];
		for (int i = 0; i < yard.length; i++)
			for (int j = 0; j < yard[0].length; j++)
				yard[i][j] = new Node(i, j, s.nextInt());
		int pool = BFS(yard);
		System.out.println(pool);
	}

	private static int BFS(Node[][] yard) {
		int pools = 0;
		int[] R = { -1, 1, 0, 0 };
		int[] C = { 0, 0, -1, 1 };
		HashSet<Node> visited = new HashSet<>();
		for (int i = 0; i < yard.length; i++) {
			 for (int j = 0; j < yard[0].length; j++) {
				if(visited.contains(yard[i][j]))
					continue;
				ArrayList<Node> q = new ArrayList<>();
				int adjac = 0;
				boolean pool = true;
				q.add(yard[i][j]);
				visited.add(yard[i][j]);
				while(!q.isEmpty()) {
					Node n = q.remove(0);
					adjac++;
					for(int k = 0; k < 4; k++) {
						int rr = n.r + R[k], cc = n.c + C[k];
						if(inBounds(yard, rr, cc)) {
							if(yard[rr][cc].value == yard[i][j].value && !visited.contains(yard[rr][cc])) {
								q.add(yard[rr][cc]);
								visited.add(yard[rr][cc]);
							}
							if(yard[rr][cc].value < yard[i][j].value) 
								pool = false;
						}
					}
				}
				if(pool)
					pools += adjac;
			}
		}
		return pools;
	}

	private static boolean inBounds(Node[][] yard, int r, int c) {
		return r >= 0 && r < yard.length && c >= 0 && c < yard[0].length;
	}
}

class Node {
	int r, c, value;
	boolean flow, visited;

	public Node(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
}
