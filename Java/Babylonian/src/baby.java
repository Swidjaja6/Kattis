import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class baby {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(s.nextLine());
		while (cases-- > 0) {
			String[] arr = (s.nextLine() + " ").split(",");
			long num = 0;
			for (int x = arr.length - 1; x >= 0; x--) {
				arr[x] = arr[x].trim();
				if (!arr[x].equals(""))
					num += (long) Math.pow(60, arr.length - 1 - x) * Integer.parseInt(arr[x]);
			}
			System.out.println(num + "\n");
		}

	}
}
