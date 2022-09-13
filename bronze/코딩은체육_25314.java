import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		N = N / 4;
		while (N != 0)
		{
		    System.out.print("long ");
		    N--;
		}
		System.out.println("int");
	}
}
