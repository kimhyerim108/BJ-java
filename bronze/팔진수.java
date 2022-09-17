import java.io.*;

public class 팔진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String N = bf.readLine();
		bf.close();
		if (N.length() % 3 == 1)
			N = "00" + N;
		else if(N.length() % 3 ==2)
			N = "0" + N;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<N.length();i+=3)
		{
			String temp = N.substring(i, i+3);
			switch (temp) {
				case "000": sb.append("0"); break;
				case "001": sb.append("1"); break;
				case "010": sb.append("2"); break;
				case "011": sb.append("3"); break;
				case "100": sb.append("4"); break;
				case "101": sb.append("5"); break;
				case "110": sb.append("6"); break;
				case "111": sb.append("7"); break;
			}
		}
		System.out.println(sb);
	}
}
