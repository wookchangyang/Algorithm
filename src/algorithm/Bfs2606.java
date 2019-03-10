package algorithm;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs2606 {


	static int[] com;
	static int[][] net;
	static int resultCnt = 0;
	
	static void bfs(int comNumber) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(comNumber);
		while(!queue.isEmpty()) {
			int number = queue.poll();
			if(com[number] == 1) continue;
			else {
				com[number] = 1;
				resultCnt++;
			}
			
			for(int i = 0 ; i < net.length ; i++) {
				if(net[i][0] == number) {
					queue.offer(net[i][1]);
				} else if(net[i][1] == number){
					queue.offer(net[i][0]);
				}
			}
		}
	}
	
	public void bfs2606() {
		Scanner in = new Scanner(System.in);
		
		int nComputer = in.nextInt();
		in.nextLine();
		
		int nNetwork = in.nextInt();
		in.nextLine();
		
		
		com = new int[nComputer+1];
		
		net = new int[nNetwork][2];
		for(int i=0 ; i < nNetwork ; i++) {
			net[i][0] = in.nextInt();
			net[i][1] = in.nextInt();
		}
		
		bfs(1);
		
		System.out.println(resultCnt-1);
	}

}
