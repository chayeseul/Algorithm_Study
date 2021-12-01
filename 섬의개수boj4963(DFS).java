import java.util.*;
public class baekjoon4963 {
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,1,0,-1,-1,1,-1,1};
	static int w,h;
	static int[][] board;
	public void DFS(int x, int y){
		for(int i=0;i<8;i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx < h && ny>=0 && ny< w && board[nx][ny]==1){
				board[nx][ny] =0;
				DFS(nx,ny);
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
						T.DFS(i, j);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
