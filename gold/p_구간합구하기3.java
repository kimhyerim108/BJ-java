import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int [N + 1][N + 1];
		int dp[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=1;j<=N;j++)
		    {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		        dp[i][j] = arr[i][j] + dp[i][j-1];
		    }
		}
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int W = Integer.parseInt(st.nextToken());
		    int x1 = Integer.parseInt(st.nextToken());
	        int y1 = Integer.parseInt(st.nextToken());
		    if (W == 1){
		        int x2 = Integer.parseInt(st.nextToken());
		        int y2 = Integer.parseInt(st.nextToken());
		        
		        int sum = 0;
		        for(int j=x1;j<=x2;j++)
		            sum += (dp[j][y2] - dp[j][y1-1]);
		        System.out.println(sum);
		    }
		    else if(W == 0){
		        int c = Integer.parseInt(st.nextToken());
		        int change = c - arr[x1][y1];
		        for(int j=y1;j<=N;j++)
		            dp[x1][j] += change;
		        arr[x1][y1] = c;
		    }
		}
	}
}
