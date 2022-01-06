import java.util.Scanner;
class man {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        if(s.nextInt() % 2 == 0)
            System.out.println("Bob");
        else 
            System.out.println("Alice");
    }
}