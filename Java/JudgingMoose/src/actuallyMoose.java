import java.util.Scanner;

public class actuallyMoose {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int left = s.nextInt(), right = s.nextInt();
		if (left == 0 && right == 0)
			System.out.println("Not a moose");
		else if (left == right)
			System.out.println("Even " + left * 2);
		else
			System.out.println(left > right ? "Odd " + left * 2 : "Odd " + right * 2);

	}
}
