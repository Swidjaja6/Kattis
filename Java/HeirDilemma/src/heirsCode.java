import java.util.Scanner;

public class heirsCode {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int pos = 0;
		int low = s.nextInt();
		int high = s.nextInt();
		for(int i = low; i <= high; i++) {
			if(uniqueDigits(i) && divisible(i)) {
				pos++;
			}
		}
		System.out.println(pos);
	}

	static boolean divisible(int n) {
		float orig = n;
		while(n > 0) {
			int num = n % 10;
			if((orig/num) % 1 != 0)
				return false;
			n /= 10;
		}
		return true;
	}

	static boolean uniqueDigits(int n) {
		boolean arr[]=new boolean[10]; 
        for (int i = 0; i < 10; i++) 
            arr[i] = false; 
      
        // Traverse through all digits  
        // of given number 
        while (n > 0) 
        { 
            // Find the last digit 
            int digit = n % 10; 
      
            // If digit is already seen,  
            // return false 
            if (arr[digit]) 
            	return false;              
      
            // Mark this digit as seen 
            arr[digit] = true; 
      
            // Remove the last digit from number 
            n = n / 10; 
        } 
        return true; 
	}
}
