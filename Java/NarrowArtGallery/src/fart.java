import java.util.Arrays;
import java.util.Scanner;

public class fart {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int numBlock = s.nextInt();
		while (n != 0) {
			int[][] rooms = new int[n][2];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 2; j++)
					rooms[i][j] = s.nextInt();

			// Set up DP array - do[i][j][k] is max for row i with j blocked with k being
			// the mask for the
			// last row. k = 0 no block, k = 1 left blocked, k = 2, right blocked.
			int[][][] dp = new int[n][numBlock + 1][3];
			for (int i = 0; i < n; i++)
				for (int j = 0; j <= numBlock; j++)
					Arrays.fill(dp[i][j], -1);

			// Set up first row.
			dp[0][0][0] = rooms[0][0] + rooms[0][1];
			if (numBlock > 0) {
				dp[0][1][1] = rooms[0][1];
				dp[0][1][2] = rooms[0][0];
			}
			// Go through rows
			for (int i = 1; i < n; i++) {
				// go through # blocked rooms, each row can't have more than 1
				for (int j = 0; j <= i + 1 && j <= numBlock; j++) {
					// Take both rooms and build off best answer on previous row with same blocks.
					if (maxArr(dp[i - 1][j]) >= 0)
						dp[i][j][0] = rooms[i][0] + rooms[i][1] + maxArr(dp[i - 1][j]);
					// Have to build off no rooms blocked on prior row or the same room blocked.
					if (j > 0 && Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) >= 0)
						dp[i][j][1] = rooms[i][1] + Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]);
					if (j > 0 && Math.max(dp[i - 1][j - 1][2], dp[i - 1][j - 1][0]) >= 0)
						dp[i][j][2] = rooms[i][0] + Math.max(dp[i - 1][j - 1][2], dp[i - 1][j - 1][0]);
				}
			}

			// Print out best appropriate answer on last row.
			System.out.println(maxArr(dp[n - 1][numBlock]));

			// Get next case.
			n = s.nextInt();
			numBlock = s.nextInt();
		}
	}

	// Returns largest element in arr.
	public static int maxArr(int[] arr) {
		int res = arr[0];
		for (int i = 1; i < arr.length; i++)
			res = Math.max(res, arr[i]);
		return res;
	}
}