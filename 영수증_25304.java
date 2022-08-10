package baekjoon;

import java.util.Scanner;

public class 영수증_25304 {
	public static void main(String[] args) {
		int total, result = 0, N, price, cnt;
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
		N = sc.nextInt();
		for (int i=0;i<N;i++)
		{
			price = sc.nextInt();
			cnt = sc.nextInt();
			result += price * cnt;
		}
		if (result == total)
			System.out.println("Yes");
		else {
			System.out.println("No");
		}
	}
}
