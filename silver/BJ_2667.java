import java.io.*;
import java.util.*;
public class Main
{
    static int N;
    static int[][] arr;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int count=0;
    static boolean[][] visited;
    static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		result = new int[N*N];
		for(int i=0;i<N;i++)
		{
		    String str = br.readLine();
		    for(int j=0;j<N;j++)
		        arr[i][j] = Character.getNumericValue(str.charAt(j));
		}
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        if (arr[i][j] == 1 && !visited[i][j])
		        {
		            count++;
		            dfs(i, j);
		        }
		    }
		}
		Arrays.sort(result);
		bw.write(count + "\n");
		for(int i=0;i<result.length;i++)
		{
		    if (result[i] == 0) continue;
		    bw.write(result[i] +"\n");
		}
		bw.flush();
	}
	static void dfs(int i, int j)
	{
	    visited[i][j] = true;
	    result[count]++;
	    for(int a= 0;a<4;a++)
	    {
	        int x = i + dx[a];
	        int y = j + dy[a];
	        if (x <0 || x>N || y < 0 || y > N)
	            continue;
	       if (arr[x][y] == 1 && !visited[x][y])
	           dfs(x, y);
	    }
	}
}
