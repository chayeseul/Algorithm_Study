import java.util.*;
class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class baekjoon7576 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n,m; //n 세로 m: 가로
	static int[][] board,ch; //board : 토마토정보 ch : 일수정보
	static Queue<Point> q ;
	public void BFS(){
		while(!q.isEmpty()){
			Point cur = q.poll();
			for(int i=0;i<4;i++){
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
					board[nx][ny] = 1;
					q.offer(new Point(nx,ny));
					ch[nx][ny] = ch[cur.x][cur.y] +1 ;
				}
			}

		}
	}
	public static void main(String args[]){
		baekjoon7576 T = new baekjoon7576();
		Scanner kb = new Scanner(System.in);
		m = kb.nextInt();
		n = kb.nextInt();
		board = new int[n][m];
		ch = new int[n][m];
		q = new LinkedList<>();

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				board[i][j] = kb.nextInt();
				if(board[i][j]==1) q.offer(new Point(i,j));
			}
		}
		T.BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(board[i][j]==0) flag = false;
				answer = Math.max(answer,ch[i][j]);
			}
		}

		if(flag) System.out.println(answer);
		else System.out.println(-1);
	}

}
