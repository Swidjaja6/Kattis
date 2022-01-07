import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int exp = Integer.parseInt(scan.nextLine());
		int result = (2 + add(exp)) * (2 + add(exp));
		System.out.println(result);
	}
	static int add(int e) {
		if(e == 1)
			return 1;
		return (int) (Math.pow(2, e - 1))  + add(e - 1);
	}
}
