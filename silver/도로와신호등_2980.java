import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int time = 0;
		int location = 0;
		for (int i=0;i<N;i++)
		{
		    int D = sc.nextInt();
		    int R = sc.nextInt();
		    int G = sc.nextInt();
		    
		    time += D - location;
		    location = D;
		    
		    int A = time % (R + G);
		    if (A < R) time += R - A;
        }
        time += L - location;
        System.out.print(time);
	}
}
