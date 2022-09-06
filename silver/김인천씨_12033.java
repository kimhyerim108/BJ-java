import java.util.Scanner;

public class Main {
	static int[] y;
	static int N;
	static StringBuffer buffer=new StringBuffer();
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++)
		{
			N =sc.nextInt();
			arr = new int[N*2+1];
			y = new int[N * 2 + 1];
			visited = new boolean[N*2+1];
			for(int j =0;j<N*2;j++)
				y[j] = sc.nextInt();
			buffer.append("Case #").append(i+1).append(": ");
			cal();
		}
		System.out.println(buffer.toString());
	}
	private static void cal()
	{
		int count=0;
		for(int j=0;j<N*2;j++)
		{
			if (count == N) break;
			if(visited[j] || y[j] % 3 != 0) continue;
			visited[j] = true;
			long price = (y[j] / 3) * 4;
			for(int k=j+1;k<N*2;k++)
			{
				if(!visited[k]&& price==y[k])
				{
					arr[count]=y[j];
					visited[k] = true; 
					count++;
					break;
				}
			}
		}
		for(int i=0;i<N;i++)
			buffer.append(arr[i]).append(' ');
		buffer.append('\n');
	}
}
