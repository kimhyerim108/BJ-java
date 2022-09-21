import java.io.*;
import java.util.*;

public class 차이를최대로_10819 {
	static int N;
	static int[] arr;
	static int result;
	static boolean[] visited;
	static int[] checked;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		checked = new int[N + 1];
		visited = new boolean[N + 1];
		result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dfs(0);
		System.out.println(result);
	}
	public static void dfs(int cnt)
	{
		if (cnt == N)
		{
			result = Math.max(sum(), result);
			return ;
		}
		for(int i=0;i<N;i++)
		{
			if (!visited[i])
			{
				visited[i] = true;
				checked[cnt] = arr[i];
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}
	public static int sum()
	{
		int s = 0;
		for(int i=0;i<N - 1;i++)
			s += Math.abs(checked[i]-checked[i+1]);
		return s;
	}
}
