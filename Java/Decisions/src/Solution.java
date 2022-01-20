import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); // n is height of tree
		int[] jArr = new int[(int) Math.pow(2, n)], leaves = new int[jArr.length];
		for (int i = 0; i < jArr.length; i++)
			jArr[i] = s.nextInt();
		for(int i = 0; i < jArr.length; i++) {
			int j = i, l = 0;
			for(int k = 0; k < n; k++) {
				l <<= 1;
				l |= j & 1;
				j >>= 1;
			}
			leaves[l] = jArr[i];
		}
		int nodes = leaves.length * 2 - 1;
		nodes -= removeNodes(leaves, 0, leaves.length);
		System.out.println(nodes);
		s.close();
	}
	static boolean combined(int[] leaves, int start, int size) {
		int val = leaves[start];
		for(int l = start; l <= start + size - 1; l++) 
			if(leaves[l] != val)
				return false;
		return true;
	}
	static int removeNodes(int[] leaves, int start, int size) {
		if(combined(leaves, start, size))
			return size * 2 - 2;
		size /= 2;
		return (removeNodes(leaves, start, size) + removeNodes(leaves, start + size, size));
	}
}
