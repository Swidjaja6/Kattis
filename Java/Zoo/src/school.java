import java.util.*;

public class school {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int c = 0;
		while(true) {
			int cases = Integer.parseInt(s.nextLine());
			if(cases == 0)
				break;
			System.out.println("List " + ++c + ":");
			ArrayList<String> animals = new ArrayList<>();
			for(int i = 0; i < cases; i++) {
				String[] word = s.nextLine().split(" ");
				animals.add(word[word.length - 1].toLowerCase());
			}
			Collections.sort(animals);
			while(animals.size() > 0) {
				String name = animals.get(0);
				int counter = animals.lastIndexOf(name) + 1;
				for(int i = 0; i < counter; i++) 
					animals.remove(0);
				System.out.println(name + " | " + counter);
			}
		}
	}
}
