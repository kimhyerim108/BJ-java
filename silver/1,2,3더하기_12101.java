import java.util.*;

public class 일더하기이더하기삼_12101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();
		List<String>[] arr = new ArrayList[N +3];
		for(int i=0;i<=N+2;i++)
			arr[i] = new ArrayList<>();
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+1+1");
		arr[3].add("1+2");
		arr[3].add("2+1");
		arr[3].add("3");
		for(int i=4;i<=N;i++)
		{
			for(int j =1;j<=3;j++)
			{
				for(String op : arr[i-j])
					arr[i].add(op + "+" + j);
			}
		}
		if(arr[N].size() < K)
			System.out.println("-1");
		else
		{
			Collections.sort(arr[N]);
			System.out.println(arr[N].get(K-1));
		}
	}
}
