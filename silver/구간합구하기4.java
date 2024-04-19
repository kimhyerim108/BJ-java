import java.util.*;
import java.io.*;
public class Main
{
    static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
		    arr[i] += arr[i-1] + Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    
		    System.out.println(arr[y] - arr[x-1]);
		}
	}
}
