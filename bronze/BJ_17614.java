package bronze;

import java.io.*;

public class 삼육구 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count= 1;
		String str;
		int result=0;
		while(count<=N)
		{
			str=count+"";
			char c;
			for(int i=0;i<str.length();i++)
			{
				c = str.charAt(i);
				switch (c) {
				case '3': case '6' : case '9':
					result++;
					break;
				}
			}
			count++;
		}
		System.out.println(result);
	}

}
