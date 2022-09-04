import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int A = sc.nextInt();
	    int B = sc.nextInt();
	    int N = sc.nextInt();
	    int result = A%B;
	    for(int i = 0;i<N -1;i++)
	    {
	        result *= 10;
	        result %= B;
	    }
	    result *= 10;
		System.out.println(result/B);
	}
}
