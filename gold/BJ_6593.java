import java.io.*;
import java.util.*;



public class 상범빌딩6593 {
	public static class Building{
		int x;
		int y;
		int z;
		int count;
		public Building(int x, int y, int z,int count)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			this.count  = count;
		}
	}
	static int L, R, C;
	static char[][][] arr;
	static Queue<Building> q;
	static int dx[] = {-1,1,0,0,0,0};
	static int dy[] = {0,0,-1,1,0,0};
	static int dz[] = {0,0,0,0,-1,1};
	static boolean[][][] visited;
	static int s;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		q = new LinkedList<>();
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new char[L+1][R+1][C+1];
			visited = new boolean[L][R][C];
			if(L==0 && R == 0 && C == 0) break;
			for(int a=0;a<L;a++)
			{
				for(int i=0;i<R;i++)
				{
					String str = br.readLine();
					for(int j=0;j<C;j++)
					{
						arr[a][i][j] = str.charAt(j);
						if (arr[a][i][j] == 'S') q.add(new Building(i,j,a,1));
					}
				}
				if(a<L) br.readLine();
			}
			s=-1;
			bfs();
			if(s==-1)System.out.println("Trapped!");
		}
	}
	static void bfs()
	{
		while(!q.isEmpty())
		{
			Building build = q.poll();
			int x = build.x;
			int y = build.y;
			int z = build.z;
			int count=build.count;
			for(int i=0;i<6;i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(nx<0||nx>=R||ny<0||ny>=C||nz<0||nz >= L) continue;
				if (arr[nz][nx][ny]=='.' &&!visited[nz][nx][ny])
				{
					visited[nz][nx][ny]=true;
					q.add(new Building(nx, ny, nz,count+1));
				}
				else if(arr[nz][nx][ny] == 'E')
				{
					s=1;
					System.out.println("Escaped in " + count + " minute(s).");
					q.clear();
					break;
				}
			}
		}
	}
}
