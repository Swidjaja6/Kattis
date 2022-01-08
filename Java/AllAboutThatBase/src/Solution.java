import java.util.Scanner;

public class Solution {
	//First is a filler to not get confused
	 static char[] bases = {'\0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0'};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		while(cases-- > 0) {
			String answer = "";
			String exp = s.nextLine();
			String[] exps = exp.split(" ");
			String first = exps[0], second = exps[2], ans = exps[4];
			char op = exps[1].charAt(0);
			int sb = Math.max(Math.max(least(first), least(second)), least(ans)); //Starting base to know where to start for each case
			for(int i = sb; i < 37; i++) {
				if(equal(convertBase(first, i), convertBase(second, i), convertBase(ans, i), op)) {
					answer += bases[i];
				}
			}
			System.out.println(answer.isEmpty() ? "invalid" : answer); 
		} 
	}
	static int convertBase(String num, int base) {
		if(base == 1)
			return num.length();
		int total = 0, product = 1, i = num.length() - 1;
		while(i >= 0) {
			total += product * charVal(num.charAt(i));
			i--;
			product *= base;
		}
		return total;
	}
	static boolean equal(int a, int b, int c, char op) {
		return op == '+' ? a + b == c : op == '-' ? a - b == c : 
			op == '*' ? a * b == c : a / b == c && a % b == 0;
	}
	static int least(String s) {
		boolean zero = false;
		int min = 1;
		for(int i = 0; i < s.length(); i++) {
			int b = charVal(s.charAt(i)) + 1;
			if (b == 1)
				zero = true;
			if (b > min)
				min = b;
		}
		return min == 2 && !zero ? 1 : min;
	}
	static int charVal(char c) {
		return c < 60 ? c - '0' : 10 + c - 'a';
	}
}
