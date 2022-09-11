import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = Integer.toBinaryString(N);
		System.out.println(str.length());
	}
}
