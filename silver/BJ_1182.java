import java.io.*;
import java.util.*;

public class 부분수열의합_1182 {
	static int[] arr;
	static int count = 0;
	static boolean[] visited;
	static int S;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		visited = new boolean[N+1];
		arr = new int[N+1];
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		go(0 , 0);
		if (S==0)
			count--;
		bw.write(count + "");
		bw.flush();
	}
	static void go(int num, int sum)
	{
		if (num == N)
		{
			if(sum == S)
				count++;
			return ;
		}
		go(num + 1, sum + arr[num]);
		go(num+1, sum);
	}
}
