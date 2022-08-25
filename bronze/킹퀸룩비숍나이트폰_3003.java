package baekjoon;

import java.util.Scanner;

public class 킹퀸룩비숍나이트폰_3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,1,2,2,2,8};
		for(int i =0;i<arr.length;i++)
		{
			int x = sc.nextInt();
			System.out.print(arr[i] - x + " ");
		}
	}
}
