import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no {
	static boolean last = true;
	public static void main(String[] args) throws FileNotFoundException {
		FastReader f = new FastReader();
		int amount = f.nextInt();
		int[] stops = new int[amount];
		for (int i = 0; i < amount; i++)
			stops[i] = f.nextInt();
		Arrays.sort(stops);
		//Iterate through array
			for (int i = 0; i < amount - 1; i++) {
				//If two numbers are not sequential by 2 or more
				if(stops[i] + 1 != stops[i + 1]) {
					System.out.print(stops[i] + " ");
				}
				//If list is sequential by 2 or more
				else {
					int end = sequential(stops, i + 1);
					//List is sequential by 3 or more
					if(end > 1) {
						int start = stops[i];
						i += end;
						end += stops[i - end];
						System.out.print(start + "-" + end + " ");
					}
					else {
						System.out.print(stops[i] + " ");
					}
				}
			}
			if(last)
				System.out.println(stops[stops.length - 1]);
//		}
	}
	//Recursion to check if list is sequential by 3 or more
	public static int sequential(int[] arr, int start) {
		if(arr[start] == arr[arr.length - 1] && arr[start - 1] == arr[start] - 1) 
			return 1;
		if(arr[start] == arr[arr.length - 1]) {
			last = false;
			return 1;
		}
		if(arr[start] + 1 == arr[start + 1]) {
			return 1 + sequential(arr, start + 1);
		}
		return 1;
	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() throws FileNotFoundException {
		br = new BufferedReader(new FileReader("sample-busnumbers.in"));//new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}