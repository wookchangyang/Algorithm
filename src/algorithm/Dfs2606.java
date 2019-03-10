package algorithm;

import java.util.Scanner;
/**
 * 
 * @author øÌ√¢æÁ
 * πÈ¡ÿ 2606 DFS
 * https://www.acmicpc.net/problem/2606
 *
 */
public class Dfs2606 {
	
	static int[] com;
	static int[][] net;
	int resultCnt = 0;
	
	public void dfs(int comNumber) {
		if(com[comNumber] != 1) {
			com[comNumber] = 1; // ∞®ø∞µ 
			resultCnt++;
		} else {
			return;
		}
		
		for(int i = 0 ; i < net.length ; i++) {
			if(net[i][0] == comNumber) {
				dfs(net[i][1]);
				
			} else if(net[i][1] == comNumber){
				dfs(net[i][0]);

			}
		}
		
	}
	
	public void backjoon2606(){
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
		
		dfs(1);
		
		System.out.println(resultCnt-1);
	}	
}
