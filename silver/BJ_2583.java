import java.util.*;
import java.io.*;
public class Main
{
    static int[][] arr;
    static int N, M, K;
    static int dx[] = {1, -1,0,0};
    static int count = 0;
    static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //y
		N = Integer.parseInt(st.nextToken()); //x
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for(int i=0;i< K;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    for(int j=y;j<y1;j++)
		    {
		        for(int k=x;k<x1;k++)
		            arr[j][k] = 1;
		    }
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<M;i++)
		{
		    for(int j=0;j<N;j++)
		  {
		      if (arr[i][j] == 0)
		      {
		        dfs(i, j); //i = Y , j = X
		        list.add(count);
		        count = 0;
		      }
		  }
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i : list)
		    System.out.print(i + " ");
	}
	static void dfs(int i, int j)
	{
	    arr[i][j] = 1;
	    count++;
	    for(int a=0;a<4;a++)
	    {
	        int x = dx[a] + i;
	        int y = dy[a] + j;
	        if (x < 0 || y < 0 || x >= M || y >= N) continue;
	        if (arr[x][y] == 0)
	           dfs(x, y);
	    }
	}
}
