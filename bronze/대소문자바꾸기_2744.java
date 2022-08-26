package baekjoon;

import java.util.Scanner;

public class 대소문자바꾸기_2744 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = new String[101];
		for(int i =0;i< str.length();i++)
		{
			char a = str.charAt(i);
			if (Character.isUpperCase(a) == true)
				System.out.print(Character.toLowerCase(a));
			else 
				System.out.print(Character.toUpperCase(a));
		}
		
	}

}
