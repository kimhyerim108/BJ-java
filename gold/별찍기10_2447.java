import java.util.Scanner;

public class 별찍기10_2447 {
	static char arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		arr = new char[N + 1][N + 1];
		backtraking(0,0,N,false);
		for(int i=0;i<N;i++)
		{
			for (int j=0;j<N;j++)
				sb.append(arr[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void backtraking(int x, int y, int N, boolean ch)
	{
		if (ch == true)
		{
			for(int i=x;i<N+x;i++)
			{
				for (int j=y;j<N+y;j++)
					arr[i][j] = ' ';
			}
			return ;
		}
		if (N == 1){
			arr[x][y] ='*'; 
			return ;
		}
		int size = N/3;
		int count = 0;
		for(int i=x;i<x+N;i+=size)
		{
			for (int j=y;j<y+N;j+=size)
			{
				count++;
				if (count == 5)
					backtraking(i, j, size, true);
				else
					backtraking(i, j, size, false);
			}
		}
	}
}
