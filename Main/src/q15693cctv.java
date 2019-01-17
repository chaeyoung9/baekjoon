import java.util.*;


import java.util.*;
public class q15693cctv {
	
	static String[][] map, map2;
	static int[] x = new int[8];
	static int[] y = new int[8];
	static int[] key = new int[8];
	static int rows, columns;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		rows = Integer.valueOf(sc.next());
		columns = Integer.valueOf(sc.nextInt());
		map = new String[rows][columns];
		
		
		int count = 0;
		for (int i = 0 ; i < rows ; i++) {
			for (int j = 0 ; j < columns ; j++) {
				map[i][j] = sc.next();
				if (!map[i][j].equals("0")) {
					x[count] = Integer.valueOf(map[i][j]);
					y[count] = Integer.valueOf(map[i][j]);
					key[count++] = Integer.valueOf(map[i][j]);
				}
			}
		}
		
		for (int i = 0 ; i < x.length ; i++) {
			search(x[i], y[i], key[i]);
		}
		
		
	}
	
	static void search(int i , int j , int input) {
		String temp[][] = new String[8][8];
		System.arraycopy(temp, 0, map, 0, map.length);
		int tempv = check(temp);
		
		switch(input) {
		case(1): {
				for (int l = 1 ; l <= 4 ; l++) {
					move(i,j, l);
					if (tempv > check(map)) {
						System.arraycopy(temp, 0, map, 0, map.length);
					} else if (tempv <= check(map)) {
						System.arraycopy(map, 0, temp, 0, map.length);
					}
				}
			}
		break;

		case(2): {
				move(i,j, 1);
				move(i,j, 3);
				tempv = check(map);
				System.arraycopy(temp, 0, map, 0, map.length);
				move(i,j, 1);
				move(i,j, 3);
				if (tempv < check(map)) {
					System.arraycopy(map, 0, temp, 0, map.length);
				}
		}
		break;
		
		case(3): {
			for (int l = 1 ; l <= 4 ; l++) {
				move(i,j, l);
				if (tempv > check(map)) {
					System.arraycopy(temp, 0, map, 0, map.length);
				} else if (tempv <= check(map)) {
					System.arraycopy(map, 0, temp, 0, map.length);
				}
			}
		}
		break;
		
		case(4): {
			for (int l = 1 ; l <= 4 ; l++) {
				move(i,j, l);
				if (tempv > check(map)) {
					System.arraycopy(temp, 0, map, 0, map.length);
				} else if (tempv <= check(map)) {
					System.arraycopy(map, 0, temp, 0, map.length);
				}
			}
		}
	break;
		
		default: {
			for (int l = 1 ; l <= 4 ; l++) {
				move(i,j,l);
			}
		}
		
		}
	}
	
	static int check(String a[][]) {
		int count = 0;
		for (int i = 0 ; i < rows; i++) {
			for (int j = 0 ; j< columns ; j++) {
				if (a[i][j].equals("0")) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	static void move(int i , int j, int input) {
		/* 1 - right, 2 - left , 3 - up, 4 - down */
		if ( i+1 <=rows && i-1>=0 && j+1<=columns && j-1 >= 0) { 
		switch (input) {
		case 1: //right
			if (map[i][j+1].equals("0") && !map[i][j+1].equals("6")) {
				map[i][j+1] = "#";
				move(i,j, 1);
			}
			break;
		case 2: //left
			if (map[i][j-1].equals("0") && !map[i][j-1].equals("6") ) {
				map[i][j-1] = "#";
				move(i,j-1,2);
			}
			break;
		case 3:
			if (map[i-1][j].equals("0") && !map[i-1][j].equals("6")) {
				map[i-1][j] = "#";
				move(i-1,j, 3);
			}
			break;
		case 4:
			if (map[i+1][j].equals("0") && !map[i+1][j].equals("6")) {
				map[i+1][j] = "#";
				move(i+1,j, 4);
			}
			break;
		}
		}
	}
	

	
	
}