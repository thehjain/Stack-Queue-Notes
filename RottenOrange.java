//We have given an 2d array of size m*n.
//Values of array can be 0,1 and 2 like this.

// 0: Empty cell
// 1: Cells have fresh oranges
// 2: Cells have rotten oranges

//In one go rotten orange can make the fresh orange
//rotten which is adjacent to it.

//Basic approach is to run two loops and check
//the total time taken to rott all . The time complexity
//in this approach will be O(m^2.n^2);

//Efficient approach is to use BFS approach.

import java.util.Queue;
import java.util.LinkedList;

class RottenOrange {

	public final static int R = 3;
	public final static int C = 5;

	private static class Ele {
		int x, y;
		Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}

	static boolean isDelim(Ele temp) {
		return (temp.x == -1 && temp.y == -1);
	}

	static boolean checkAll(int[][] arr) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	static int rotOranges(int[][] arr) {

		Queue<Ele> Q = new LinkedList<>();
		Ele temp;
		int ans = 0;

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 2)
					Q.add(new Ele(i, j));

		Q.add(new Ele(-1, -1));

		while (!Q.isEmpty()) {

			boolean flag = false;


			while (!isDelim(Q.peek()) ) {

				temp = Q.peek();

				if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x + 1][temp.y] = 2;
					temp.x++;
					Q.add(new Ele(temp.x, temp.y));
					temp.x--;
				}
				if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x - 1][temp.y] = 2;
					temp.x--;
					Q.add(new Ele(temp.x, temp.y));
					temp.x++;
				}
				if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y + 1] = 2;
					temp.y++;
					Q.add(new Ele(temp.x, temp.y));
					temp.y--;
				}
				if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y - 1] = 2;
					temp.y--;
					Q.add(new Ele(temp.x, temp.y));
				}
				Q.remove();
			}
			Q.remove();

			if (!Q.isEmpty()) {
				Q.add(new Ele(-1, -1));
			}
		}
		return (checkAll(arr)) ? -1 : ans;
	}

	public static void  main(String[] args) {

		int arr[][] = { {2, 1, 0, 2, 1},
			{1, 0, 1, 2, 1},
			{1, 0, 0, 2, 1}
		};

		int ans = rotOranges(arr);

		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("time taken is " + ans);

	}
}

//Problem is available on geeksforgeeks