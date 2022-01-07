import java.io.*;
import java.util.*;

public class EvenUp {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(in.readLine());
        Stack<Integer> cards = new Stack<Integer>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(cards.size() != 0 && (card + cards.peek()) % 2 == 0) {
                cards.pop();
            }
            else cards.push(card);
        }
        System.out.println(cards.size());
    }
}
/*
public class EvenUp {
	public static void main(String[] args) throws FileNotFoundException {
		FastReader s = new FastReader();
		int cardNum = s.nextInt();
		String line = s.nextLine();
		String[] list = line.split(" ");
		int[] arr = new int[list.length];
		int i;
		for (i = 0; i < list.length; i++) {
			arr[i] = Integer.parseInt(list[i]);
		}
		LinkedList<Integer> array = new LinkedList<>();
		for (i = 0; i < arr.length; i++) {
			array.add(arr[i]);
		}
		Iterator iter = array.iterator();
		boolean done = false;
		while (!done) {
			while(iter.hasNext()) {
				done = true;
				if (((Integer) iter.next() + (Integer) iter.next()) % 2 == 0) {
					iter.remove();
					iter.remove();
					cardNum -= 2;
					done = false;
				}
			}
		}
		System.out.println(cardNum);
	}
}
*/

