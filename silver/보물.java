import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		Integer B[] = new Integer[N];
		StringTokenizer st;
		for(int i=0;i<2;i++)
		{
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++)
		    {
		        if(i ==0) A[j] = Integer.parseInt(st.nextToken());
		        else if (i==1) B[j] = Integer.parseInt(st.nextToken());
		    }
		}
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());
		int S=0;
	    for(int j=0;j<N;j++)
	    {
	        S += A[j]*B[j];
		}
		System.out.println(S);
	}
}
