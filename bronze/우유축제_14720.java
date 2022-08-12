package baekjoon;

import java.util.Scanner;

public class 우유축제_14720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int count = 0, next =0;
		int[] arr = new int[x];
		for(int i = 0;i < x;i++)
			arr[i] = sc.nextInt();
		for (int i = 0;i < x;i++)
		{
			if (next == arr[i])
			{
				count++;
				next++;
			}
			if (next > 2)
				next = 0;
		}
		System.out.println(count);
	}
}
