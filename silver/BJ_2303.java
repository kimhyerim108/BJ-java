
package silver;

import java.io.*;
import java.util.*;

public class 숫자게임 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		StringTokenizer st;
		int max = 0;
		int values[]=new int[N];
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++)
		{
			max=0;
			int result = 0;
			for(int j=0;j<5;j++)
			{
				for(int x =j+1;x<5;x++)
				{
					for(int y=x+1;y<5;y++)
					{
						max = (arr[i][j] + arr[i][x] + arr[i][y]) % 10;
						result = Math.max(max, result);
						values[i] = result;
					}
				}
			}
		}
		int sum=0;
		for(int i=0;i<N;i++)
		{
			max = Math.max(max, values[i]);
			if(max==values[i]) sum =i+1;
		}
		System.out.println(sum);
	}

}
