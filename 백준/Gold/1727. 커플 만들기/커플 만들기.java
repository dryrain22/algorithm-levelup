import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int n, m;
	static int[] rows;
	static int[] cols;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	public static void solve() {
		int col = Math.max(n, m);
		int row = Math.min(n, m);
		Arrays.sort(rows);
		Arrays.sort(cols);
		
		for(int i=0; i<row; i++) {
			Arrays.fill(dp[i], 10_000_000);
		}
		
		int minValue = Integer.MAX_VALUE;
		for(int i=0; i<=col-row; i++) {
			int diff = Math.abs(rows[0] - cols[i]);
			minValue = Math.min(minValue, diff);
			dp[0][i] = minValue;
		}
		
		
		
		for (int i=1; i<row; i++) {
			
			for (int j=i; j<=col-row+i; j++) {
				int diff = Math.abs(rows[i] - cols[j]);
				dp[i][j] = Math.min(dp[i][j-1], diff + dp[i-1][j-1]);
			}
		}

		System.out.println(dp[row-1][col-1]);
	}
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int col = Math.max(n, m);
		int row = Math.min(n, m);
		
		rows = new int[row];
		cols = new int[col];
		dp = new int[row][col];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (n == col)
				cols[i] = num;
			else 
				rows[i] = num;
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (n == col)
				rows[i] = num;
			else 
				cols[i] = num;
		}
 	}

}