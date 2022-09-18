package silver;

import java.io.*;
import java.util.*;

public class 아저는볶음밥이요 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long D = Long.parseLong(br.readLine());
		String[] strs = br.readLine().split(" ");
		long N = Long.parseLong(strs[0]);
		long M = Long.parseLong(strs[1]);
		long K = Long.parseLong(strs[2]);
		long[] count = new long[4];
		long[] size = new long[4];
		long x = N%D;
		long y = M%D;
		long m = (N+M+K)/D;
		count[0] = K / D + N / D + M / D;
		size[0] = K;
		count[1] = (K - (D-x)) / D + (N + (D-x))/ D + M / D;
		size[1] = K -(D-x);
		count[2]= (K - (D-y)) / D + N/ D + (M+(D-y)) / D;
		size[2] =  K -(D-y);
		count[3] = (K - (D-x) - (D-y)) / D + (N + (D-x))/ D + (M+(D-y)) / D;
		size[3] = K - (D-x)-(D-y);
		long max = 0;
		for(int i=0;i<4;i++)
		{
			if(size[i] > max && count[i] == m)
				max = size[i];
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}
