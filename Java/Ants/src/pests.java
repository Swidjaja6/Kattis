import java.util.*;
public class pests {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while(--cases >= 0) {
			int length = s.nextInt(), ants = s.nextInt(), min = 0;
			int[] numb = new int[ants];
			for(int i = 0; i < numb.length; i++) {
				numb[i] = s.nextInt();
				min = Math.max(Math.min(numb[i], length - numb[i]), min);
			}
			Arrays.sort(numb);
			int[] max = {numb[0], numb[ants - 1], length - numb[0], length - numb[ants - 1] };
			Arrays.sort(max);
			System.out.println(min + " " + max[3]);
		}
	}
}
