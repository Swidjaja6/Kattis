import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int statues = s.nextInt(), min = Integer.MAX_VALUE, pToAdd = 0;
		for (int i = 0; i < statues; i++) {
			int printer = 1, days = 0, pStatues = 0;
			printer += Math.pow(2, pToAdd) - 1;
			days += pToAdd;
			while (pStatues < statues) {
				days++;
				pStatues += printer;
			}
			if (days < min)
				min = days;
			else
				break;
			pToAdd++;
		}
		System.out.println(min);
	}
}
