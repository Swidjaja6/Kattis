import java.io.*;
import java.util.*;

public class minionz {
	public static void main(String[] args) {
		FastReader f = new FastReader();
		ArrayList<minion> workers = new ArrayList<>();
		int m = f.nextInt();
		for(int i = 0; i < m; i++) 
			workers.add(new minion(f.nextInt(), f.nextInt()));
		int count = 1; //Number of rooms
		Collections.sort(workers);//Sorted in order of the highs of each
		minion mi = workers.get(0);//Get first minion
		for(int i = 0; i < workers.size(); i++) {
			if(workers.get(i).low > mi.high) {
				count++;
				mi = workers.get(i);
			}
		}
		System.out.println(count);
		
	}
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader() 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

