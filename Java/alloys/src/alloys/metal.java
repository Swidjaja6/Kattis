package alloys;

import java.util.Scanner;

public class metal {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double sek = s.nextDouble();
		if(sek >= 1)
			sek = 1;
		System.out.println(sek * sek / 4);
	}
}
