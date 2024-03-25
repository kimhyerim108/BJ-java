import java.util.*;
import java.io.*;
public class Main
{
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int[] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		
		cnt = new int[N+1];
		for(int i=0;i<=N;i++) list[i] = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    list[a].add(b);
		}
		for(int i=1;i<=N;i++){
		    visited = new boolean[N+1];
		    dfs(i);
		}
		int max = Arrays.stream(cnt).max().getAsInt();
		for(int i=1;i<=N;i++){
		    if (cnt[i] == max)
		        System.out.print(i + " ");
		}
	}
	static void dfs(int i)
	{
	    visited[i] = true;
	    for(int next : list[i])
	    {
	        if (visited[next]) continue;
	        visited[next] = true;
	        cnt[next]++;
	        dfs(next);
	    }
	}
}
