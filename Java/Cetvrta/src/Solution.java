import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        int x3 = s.nextInt();
        int y3 = s.nextInt();
        int x4 = 0, y4 = 0;
        if(x1 == x2) 
            x4 = x3;
        else if(x1 == x3)
            x4 = x2;
        else 
            x4 = x1;
            
        if(y1 == y2) 
            y4 = y3;
        else if(y1 == y3)
            y4 = y2;
        else 
            y4 = y1;
        
        System.out.println(x4 + " " + y4);    
    }
}
