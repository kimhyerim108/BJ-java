import java.io.*;
import java.util.Arrays;

public class Main {
	static boolean[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new boolean[1005000];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		for(int i=2;i<arr.length;i++)
		{
			if (!arr[i]) continue;
			for(int j=i+i;j<arr.length;j+=i)
				arr[j]=false;
		}
		for(int i=N;i<arr.length;i++)
		{
			if(arr[i])
			{
				int n= i;
				int temp = 0;
				while(n!=0)
				{
					temp = 10 * temp + (n% 10);
					n/=10;
				}
				if(temp == i)
				{
					System.out.println(i);
					break;
				}
			}
		}
	}
}
