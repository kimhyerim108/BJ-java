package baekjoon;

import java.util.Scanner;

public class 이진수팔진수_1373 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String N = sc.nextLine();
		if(N.length() % 3 == 1)
			sb.append((N.charAt(0) -'0') * 1);
		else if(N.length() % 3 == 2)
			sb.append((N.charAt(0) - '0') * 2 + (N.charAt(1) - '0') * 1);
		for(int i=N.length() % 3;i<N.length();i+=3)
			sb.append((N.charAt(i) - '0') * 4 + (N.charAt(i + 1) -'0') * 2 + (N.charAt(i+2) - '0') * 1);
		System.out.println(sb);
	}
}
