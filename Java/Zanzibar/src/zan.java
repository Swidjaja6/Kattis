import java.util.*;
import java.io.*;

public class zan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while(cases-- > 0) {
			int imp = 0;
			int current = 0;
			while(true) {
				int prev = current;
				current = s.nextInt();
				if(current == 0)
					break;
				else if(current > prev * 2) 
					imp += current - prev * 2;
			}
			System.out.println(imp - 1);
		}
	}
}
