import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][10];
		for(int i=0;i<10;i++)
			arr[0][i] = 1;
		for(int i=1;i<N+1;i++)
			for(int j=0;j<10;j++)
				for(int k=j;k<10;k++)
				{
					arr[i][j] += arr[i-1][k];
					arr[i][j] %= 10007; 
				}
		bw.write(arr[N][0]+ "");
		bw.flush();
	}
}
