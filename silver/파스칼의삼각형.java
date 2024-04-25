import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int arr[][] = new int[31][31];
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		for(int i=3;i<=30;i++){
		    for(int j=1;j<i+1;j++){
		        if (j==1) arr[i][j] = 1;
		        else if (j==i) arr[i][j] = 1;
		        else
		            arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
		    }
		}
		int dp = 0;
		for(int i=1;i<=W;i++){
		    for(int j=1;j<i+1;j++){
		        dp += arr[i + R - 1][j + C -1 ];
		    }
		}
		System.out.println(dp);
	}
}
