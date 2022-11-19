
import java.io.*;
import java.util.*;

public class 불 {
	static int T, h, w;
	static char[][] arr;
	static Queue<int[]> sangeun;
	static Queue<int[]> fire;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0)
		{
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new char[h][w];
			
			sangeun = new LinkedList<>();
			fire = new LinkedList<>();
			for(int i=0;i<h;i++)
			{
				String str = br.readLine();
				for(int j=0;j<w;j++)
				{
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='*')
						fire.add(new int[] {i,j});
					if (arr[i][j]=='@')
						sangeun.add(new int[] {i,j,0});
				}
			}
			size=0;
			bfs();
			if (size==0)System.out.println("IMPOSSIBLE");
			else System.out.println(size);
		}
	}
	static void bfs()
	{
		while(!sangeun.isEmpty())
		{
			int s = fire.size();
			for(int i=0;i<s;i++)
			{
				int temp[] = fire.poll();
				for(int j=0;j<4;j++)
				{
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					if(x< 0 || x>= h || y < 0 || y >= w) continue;
					if (arr[x][y] == '@' || arr[x][y] == '.')
					{
						arr[x][y] = '*';
						fire.add(new int[] {x,y});
					}
				}
			}
			s = sangeun.size();
			for(int i=0;i<s;i++)
			{
				int temp[] = sangeun.poll();
				for(int j=0;j<4;j++)
				{
					int x = temp[0] + dx[j];
					int y = temp[1] + dy[j];
					if (x < 0 || x >= h || y < 0 || y >= w) {size = temp[2]+1;return ;}
					if (arr[x][y] == '.')
					{
						arr[x][y]='@';
						sangeun.add(new int[] {x,y,temp[2]+1});
					}
				}
			}
		}
	}
}
