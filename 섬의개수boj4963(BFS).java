import java.util.*;
class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class baekjoon4963 {
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,1,0,-1,-1,1,-1,1};
	static int w,h;
	static int[][] board;
	static Queue<Point> q  = new LinkedList<>();

  public void BFS(int x, int y){
		while(!q.isEmpty()){
			Point cur = q.poll();
			for(int i=0;i<8;i++){
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx>=0 && nx <h && ny>=0 && ny<w && board[nx][ny]==1){
					board[nx][ny] = 0;
					q.offer(new Point(nx,ny));
				}
			}
		}

	}
	public static void main(String args[]){
		baekjoon4963 T = new baekjoon4963();
		Scanner kb = new Scanner(System.in);

		while(true) {
			w = kb.nextInt();
			h = kb.nextInt();
			if(h==0 && w==0) System.exit(0);
			board = new int[h][w];
			int answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					board[i][j] = kb.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (board[i][j] == 1) {
						board[i][j] = 0;
						answer++;
						q.offer(new Point(i,j));
						T.BFS(i,j);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
