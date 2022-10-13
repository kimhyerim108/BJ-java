import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int K;
    static Queue<Integer> q = new LinkedList<>();
    static int[] arr;
    static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N >= K) bw.write(N - K +"");
		else    bw.write(bfs() + "");
		bw.flush();
	}
	static int bfs()
	{
	    arr = new int[100001];
	    visited = new boolean[200001];
	    q.add(N);
	    arr[N] = 1;
	    while (!q.isEmpty())
	    {
	        int temp = q.poll();
	        int dx[] = {temp -1, temp+1, temp*2};
	        for(int i=0;i<3;i++)
	        {
	            int n;
	            n = dx[i];
	            if (n == K) return arr[temp];
	            if (n >= 0 && !visited[n] && n < 100001)
	            {
	                visited[n] = true;
	                arr[n] = arr[temp] + 1;
	                q.add(n);
	            }
	        }
	    }
	    return (0);
	}
}
