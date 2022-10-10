
package silver;

import java.io.*;
import java.util.*;


public class 연속합 {
	static Integer[] result;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		result = new Integer[N+1]; 
		for(int i =0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		result[0] = arr[0];
		max = arr[0];
		dp(N-1);
		bw.write(max+ "");
		bw.flush();
	}
	private static int dp(int N)
	{
		if (result[N] == null)
		{
			result[N] = Math.max(dp(N-1) + arr[N], arr[N]);
			max = Math.max(result[N], max);
		}
		return result[N];
	}
}
