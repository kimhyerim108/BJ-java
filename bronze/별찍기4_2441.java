package baekjoon;

import java.util.Scanner;

public class 별찍기4_2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i=N;i>0;i--)
		{
			for (int k=i; k<N;k++)
				System.out.print(" ");
			for(int j=i;j>0;j--)
				System.out.print("*");
			System.out.println();
		}
	}
}
