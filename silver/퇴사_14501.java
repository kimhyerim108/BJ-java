package baekjoon;

import java.util.Scanner;

public class 퇴사_14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int day[] = new int[N + 2];
		int price[] = new int[N + 2];
		int dp[] = new int[N + 2];
		int count = 0, sum = 0, j=0, max =0;
		for(int i = 1;i <= N; i++)
		{
			day[i] = sc.nextInt();
			price[i]= sc.nextInt(); 
		}
		for(int i = N;i > 0;i--)
		{
			int next = i + day[i];
			if(next > N + 1)
				dp[i] = dp[i + 1];
			else {
				dp[i] = Math.max(dp[i + 1], dp[next] + price[i]); 
			}
		}
		System.out.println(dp[1]);
	}
}
