package silver;

import java.util.*;

public class 성적통계_5800 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max,min,gap;
		for(int i=0;i<N;i++)
		{
			int K = sc.nextInt();
			int[] arr = new int[K]; 
			for(int j=0;j<K;j++)
				arr[j] = sc.nextInt();
			Arrays.sort(arr);
			max = arr[K - 1];
			min = arr[0];
			int result = 0;
			for(int j=K-1;j>0;j--)
			{
				int equl = arr[j] - arr[j-1];
				if (result < equl)
					result = equl;
			}
			System.out.println("Class " + (i+1));
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + result);
		}
	}
}
