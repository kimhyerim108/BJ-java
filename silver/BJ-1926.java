import java.io.*;
import java.util.*;

public class Main
{
    static int[][] arr;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int w;
    static int h;
    static int count = 0;
    static boolean[][] visited;
    static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		visited = new boolean[h][w];
		result = new int[h * w];
		for (int i = 0;i<h;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0;j<w;j++)
		        arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0;i<h;i++)
		{
		    for(int j = 0;j<w;j++)
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
		bw.write(result[h * w - 1] + "");
		bw.flush();
	}
	static void dfs(int i, int j)
	{
	    visited[i][j] = true;
	    result[count]++;
	    for(int a=0;a<4;a++)
	    {
            int nx = i + dx[a];
            int ny = j + dy[a];
            if (nx < 0 || nx >= h || ny <0 || ny >= w)
               continue;
	       if (arr[nx][ny] ==  1 && !visited[nx][ny])
	       {
	           visited[nx][ny] = true;
	           dfs(nx, ny);
	       }
	    }
	}
}
