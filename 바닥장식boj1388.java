import java.io.*;
		import java.util.*;
public class baekjoon1388 {
	static int n,m;
	static int answer =0;
	static char[][] board;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];

		for(int i=0;i<n;i++){
			String str = br.readLine();
			for(int j=0;j<m;j++){
				board[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++){ //'-'의 개수
			for(int j=0;j<m;j++){
				if(board[i][j] =='-'){
					answer ++;
					//같은 행에서 연속으로 '-'을 만날 경우 count하지 않음
					while(j<m && board[i][j]=='-') j++;
				}

			}
		}

		for(int i=0;i<m;i++){ //'|' 의 개수
			for(int j=0;j<n;j++){
				if(board[j][i]=='|'){
					answer ++;
					//같은 열에서 연속으로 '|'을 만날 경우 count하지 않음
					while( j<n && board[j][i]=='|') j++;
				}

			}
		}
		System.out.println(answer);

		br.close();

	}
}
