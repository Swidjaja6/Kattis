import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		int L = Integer.parseInt(s.nextLine());
		char[] arr = s.nextLine().toCharArray();
		for(int i = 0; i < L; i++) {
			if(arr[i] == ' ')
				continue;
			if(arr[i] == '(' || arr[i] == '{' || arr[i] == '[')
				st.push(arr[i]);
			else if((arr[i] == ')' || arr[i] == '}' || arr[i] == ']') && st.isEmpty()) {
				System.out.println(arr[i] + " " + i);
				return;
			}
			else if((arr[i] == ')' && st.peek() == '(') || (arr[i] == '}' && st.peek() == '{') 
					|| (arr[i] == ']' && st.peek() == '[')) 
				st.pop();
			else {
				System.out.println(arr[i] + " " + i);
				return;
			}
		}
		System.out.println("ok so far");
	}
}
