import java.io.*;
import java.util.StringTokenizer;

public class Main_나의인생에는수학과함께 {
	static int N;
	static char[][] arr;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0;i<N;i++)
		{
			String[] str = br.readLine().split(" ");
			for(int j=0;j<N;j++)
				arr[i][j] = str[j].charAt(0);
		}
		dfs(0, 0, 0, '+');
		System.out.println(max + " " + min);
	}
	static void dfs(int x, int y, int save, char cal)
	{
		if (x >= N || y >= N) return ;
		int num = arr[x][y] - '0';
		if (num>=0 && num<= 5)
		{
			if (cal == '+')
				save += num;
			else if (cal == '*')
				save *= num;
			else
				save -= num;
		}
		else
			cal = arr[x][y];
		if (x == N-1 && y == N - 1)
		{
			min = Math.min(save, min);
			max = Math.max(save, max);
			return ;
		}
		dfs(x+1, y, save, cal);
		dfs(x, y+1, save, cal);
	}
}
