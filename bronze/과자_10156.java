package bronze;

import java.util.*;

public class 과자_10156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int money = K * N - M;
		if (money > 0)
			System.out.println(money);
		else
			System.out.println("0");
	}

}
