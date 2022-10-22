import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, y;
	static int[][] arr;
	static int[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		check = new int[101];
		for(int i=0;i<m;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		bfs(x, y);
		if (check[y] != 0)
			bw.write(check[y] + "");
		else bw.write("-1");
		bw.flush();
	}
	static void bfs(int start, int end)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty())
		{
			int temp=q.poll();
			if (temp == end) break;
			for(int i=1;i<=n;i++)
			{
				if (arr[temp][i] == 1 && check[i] ==0)
				{
					check[i] = check[temp] + 1;
					q.add(i);
				}
			}
		}
	}
}
