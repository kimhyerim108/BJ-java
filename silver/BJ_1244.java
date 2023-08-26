import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine()); //스위치 개수
	    int arr[] = new int[N+2];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=N;i++)
	        arr[i] = Integer.parseInt(st.nextToken()); //스위치 배열에 넣기
	    int S = Integer.parseInt(br.readLine()); //학생수
	    for(int i=0;i<S;i++)
	    {
	        st = new StringTokenizer(br.readLine());
	        int FM = Integer.parseInt(st.nextToken()); // 남녀 구분
	        int number = Integer.parseInt(st.nextToken()); //배정받은
	        //남학생(1)이면 배정받은 번호의 배수 반전 
	        if (FM == 1)
	        {
	            for (int j=1;j<=N;j++)
	                if(j % number == 0)
	                    arr[j] = (arr[j] == 1? 0 : 1);
	        }
	        else{
	            //여학생(2)이면 배정받은 번호의 좌우구간 확인후 반전
	            arr[number] = (arr[number] == 1? 0 : 1);
	            for(int j=1;j<=N;j++)
	            {
	                if (arr[number-j] != arr[number+j] || ((number-j) <1) || (number+j) >N)
	                    break;
	                else
	               {
	                   arr[number-j] = (arr[number-j] == 1? 0 : 1);
	                   arr[number+j] = (arr[number+j] == 1? 0 : 1);
	               }
	            }
	        }
	    }
	    for(int i=1;i<=N;i++)
	    {
	        System.out.print(arr[i] + " ");
	        if (i % 20 ==0)
	            System.out.println();
	    }
	}
}
