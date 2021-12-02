import java.util.*;
public class baekjoon16173 {
	/*문제 설계
	* 출발점 : (0,0)
	* 이동 가능한 방향 : 오른쪽(dx:0,dy:1) 아래(dx :1 , dy:0)
	* 도착점 : (n-1,n-1)
	* 이동할 수 있는 칸의 수 : 현재 밟고 있는 칸에 쓰여진 수
	* */
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static int n;
	static int[][] board,ch;

	public void DFS(int x, int y){
		if(board[x][y]==-1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		else{
			for (int j = 0; j < 2; j ++) {
				int nx = x + dx[j]*board[x][y];
				int ny = y + dy[j]*board[x][y];
				if (nx >= 0 && nx <n && ny>=0 && ny<n && ch[nx][ny] ==0 ){
					ch[nx][ny] = 1;
					DFS(nx,ny);
					ch[nx][ny] = 0;
				}
			}

		}

	}
	public static void main(String args[]){
		baekjoon16173 T = new baekjoon16173();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		board = new int[n][n];
		ch = new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				board[i][j] = kb.nextInt();
			}
		}

		ch[0][0] = 1;
		T.DFS(0,0);
		System.out.println("Hing");

	}
}
