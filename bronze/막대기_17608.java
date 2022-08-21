import java.util.*;

public class 막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int count = 1,max;
		int[] arr = new int[x+1];
		for(int i = 1;i<=x;i++)
			arr[i] = sc.nextInt();
		max = arr[x];
		for(int i = x;i>0;i--)
		{
			if(max < arr[i])
			{
				count++;
				max = arr[i];
			}
		}
		System.out.println(count);
	}
}
