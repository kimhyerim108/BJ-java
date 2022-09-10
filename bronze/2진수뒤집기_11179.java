import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String two = Integer.toBinaryString(N);
		StringBuilder sb = new StringBuilder(two);
		sb.reverse();
		int output = Integer.parseInt(sb.toString(),2);
		System.out.println(output);
	}
}
