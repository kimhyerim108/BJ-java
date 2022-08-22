import java.util.*;
public class 에라토스테네스의체_2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] prime = new int[N+1];
		int result = 0, p = 0;
		for(int i = 2;i<=N;i++)
			prime[i] = 1;
		for(int i=2;i<=N;i++)
		{
			if (prime[i] == 0)
				continue ;
			for(int j=1;i*j<=N;j++)
			{
				if(prime[i * j] == 0) continue ;
				prime[i *j] = 0;
				result++;
				if (result == K) p = i * j;
			}
		}
		System.out.println(p);
	}
}
