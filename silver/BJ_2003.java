import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int count =0;
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++)
		{
			int num = arr[i];
			for(int j=i+1;j<N+1;j++)
			{
				if (num == M) {count++;break;}
				num += arr[j];
			}
		}
		System.out.println(count);
	}
