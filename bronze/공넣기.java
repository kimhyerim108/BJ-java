import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N+1];
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
		    int C = Integer.parseInt(st.nextToken());
		    for(int j=A;j<=B;j++)
		        arr[j] = C;
		}
		for(int i=1;i<=N;i++)
		    System.out.print(arr[i]+" ");
	}
}
