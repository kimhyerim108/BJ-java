package baekjoon;

import java.util.*;
import java.lang.Math;
public class 통계학_2108
{
    static int[] arr;
    static int N;
    static int max =-1,result = 0,mod =0;
    static boolean check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		int aver = 0;
		for(int i=0;i<N;i++)
		    arr[i] = sc.nextInt();
		Arrays.sort(arr,0,N);
		for(int i=0;i<N;i++)
		    aver += arr[i];
		bin();
		System.out.println((int)Math.round(aver / (double)N));
		System.out.println(arr[N/2]);
		System.out.println(mod);
		System.out.println(arr[N - 1]-arr[0]);
	}
	private static void bin()
	{
		for(int i=0;i<N;i++)
		{
			if (arr[i] == arr[i+1]) result++;
			else result=0;
			if(max < result)
			{
				max = result;
				mod = arr[i];
				check = true;
			}
			else if(max==result && check ==true)
			{
				mod = arr[i];
				check = false;
			}
		}
	}
}
