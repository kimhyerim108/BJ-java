import java.util.*;
import java.io.*;

public class Main
{
    //ㅋㅏ드2 queue를 사용하여 푸는 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++)
		{
		    queue.add(i);
		}
		while(queue.size() > 1){
		    queue.remove();
		    queue.add(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
