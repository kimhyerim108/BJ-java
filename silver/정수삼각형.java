import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int arr[][] = new int[N+1][N+1];
		int sp[][] = new int[N+1][N+1];
		for(int i=0;i<N;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j = 0;j<=i;j++)
		        arr[i][j] = Integer.parseInt(st.nextToken());
		}
		sp[0][0] = arr[0][0];
		sp[1][0] = arr[1][0] + sp[0][0];
		sp[1][1] = arr[1][1] + sp[0][0];
		for(int i=2;i<N;i++)
		{
		    for(int j = 0;j<=i;j++)
		    {
		        if(j==0)
		            sp[i][j] = sp[i-1][j] + arr[i][j];
		        else if(j==i)
		            sp[i][j] = sp[i-1][j-1] + arr[i][j];
		        else
		            sp[i][j] = Math.max(sp[i-1][j-1], sp[i-1][j]) + arr[i][j];
		        
		    }
		}
		int answer = 0;
		for(int i=0;i<N;i++)
		    answer = Math.max(answer, sp[N-1][i]);
		System.out.println(answer);
	}
}
