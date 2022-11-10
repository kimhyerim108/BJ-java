import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		while(N-->0)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch (str) {
				case "push_back":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "push_front" :
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "front":
					if (deque.isEmpty()) System.out.println("-1");
					else System.out.println(deque.peek());
					break;
				case "back":
					if (deque.isEmpty()) System.out.println("-1");
					else System.out.println(deque.peekLast());
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					if(deque.isEmpty()) System.out.println("1");
					else System.out.println("0");
					break;
				case "pop_front":
					if (deque.isEmpty()) System.out.println("-1");
					else System.out.println(deque.poll());
					break;
				case "pop_back":
					if (deque.isEmpty()) System.out.println("-1");
					else System.out.println(deque.pollLast());
					break;
			}
		}
	}

}
