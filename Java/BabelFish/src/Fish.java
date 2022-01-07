import java.io.*;
import java.util.*;

public class Fish {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean dic = true;
		HashMap<String, String> nonsense = new HashMap<>();
		while(s.hasNextLine()) {
			String st = s.nextLine();
			if(st.isEmpty()) {
				dic = false;
				continue;
			}
			else if(dic) {
				int index = st.indexOf(" ");
				String key = st.substring(0, index); //E.g. Dog
				String def = st.substring(index + 1); //E.g. Ogday
				nonsense.put(def, key);
			}
			else {
				if(nonsense.containsKey(st)) 
					System.out.println(nonsense.get(st));
				else 
					System.out.println("eh");
			}
		}
	}
}
