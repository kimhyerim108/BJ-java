import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int A=sc.nextInt();
		int B=sc.nextInt();
		int[] arr= new int[1002];
		int sum=0;
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<i;j++)
			{
				if (count==1001)break;
				arr[count]=i;
				count++;
			}
		}
		for(int i=A;i<=B;i++)
			sum+=arr[i];
		System.out.println(sum);
	}

}
