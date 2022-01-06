import java.util.*;
import java.io.*;
public class character {
	public static void main(String[] args) {
		FastReader s = new FastReader();
		int players = s.nextInt(10), feats = s.nextInt(10);
		boolean[] visited = new boolean[(int) Math.pow(2, feats)];
		Queue<Integer> q = new LinkedList<>();
		int ans = 0;
		for(int i = 0; i < players; i++) 
			q.add(s.nextInt(2));
		while(!q.isEmpty()) {
			int current = q.poll();
			if(!visited[current]) {
				ans = current;
				visited[current] = true;
				int mask = 1;
				for(int j = 0; j < feats; j++) {
					int num = current ^ mask;
					if(!visited[num])
						q.add(num);
					mask <<= 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int mask = 1;
		for(int i = 0; i < feats; i++) {
			if((mask & ans) != 0) {
				sb.append(1);
			}
			else 
				sb.append(0);
			mask <<= 1;
		}
		System.out.println(sb.reverse().toString());
	}
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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

    int nextInt(int base)
    {
        return Integer.parseInt(next(), base);
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
