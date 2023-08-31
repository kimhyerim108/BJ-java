import java.util.*;
import java.io.*;
public class Main
{
	//2차원배열 수 합하기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		for(int i=1;i<=N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j=1;j<=M;j++)
		        arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		for(int a =0;a< K;a++)
		{
	        st = new StringTokenizer(br.readLine());
		    int i = Integer.parseInt(st.nextToken());
		    int j = Integer.parseInt(st.nextToken());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    int sum = 0;
		    for(int k = i; k<=x;k++)
		    {
		        for(int z = j;z<=y;z++)
		            sum += arr[k][z];
		    }
		    System.out.println(sum);
		}
	}
}
