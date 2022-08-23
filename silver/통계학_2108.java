import java.util.*;
import java.lang.Math;
public class Main
{
    static int[] arr;
    static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		int aver = 0;
		for(int i=0;i<N;i++)
		    arr[i] = sc.nextInt();
		sort();
		for(int i=0;i<N;i++)
		    aver += arr[i];
		mode();
		System.out.println((int)Math.round(aver / (double)N));
		System.out.println(arr[N/2]);
		System.out.println();
		System.out.println(arr[N - 1]-arr[0]);
	}
	private static void mode()
	{
	    for(int i=0;i<N;i++)
	    {
	        arr[i]++;
	    }
	}
	private static void sort()
	{
	    for(int i=0;i<N;i++)
	    {
	        for(int j=i + 1;j<N;j++)
	        {
	            if (arr[i] > arr[j])
	            {
	                int tmp = arr[j];
	                arr[j] = arr[i];
	                arr[i] = tmp;
	            }
	        }
	    }
	}
}
