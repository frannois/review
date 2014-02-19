package review;

import java.util.Arrays;

/**
 * WORKS
 * given an 2D matrix M, is filled either using X or O, you need to find the
 * region which is filled by O and surrounded by X and fill it with X.
 * 
 * example 1:
 * 
 * X X X X X
 * X X O O X
 * X X O O X
 * O X X X X
 * 
 * Answer :
 * 
 * X X X X X X X X X X X X X X X O X X X X
 * 
 * example 2:
 * 
 * X X X X X X X O O X X X O O O O X X X X
 * 
 * answer 2: X X X X X X X O O X X X O O O O X X X X
 * 
 * @author jfdionne
 * 
 */
public class FilltheO {

    private char[][] array;
    boolean[][] visited;

    public FilltheO(char[][] ar) {
	array = ar;
	visited = new boolean[ar.length][ar[0].length];
	for (int i = 0 ; i < visited.length ;i++) {
	    Arrays.fill(visited[i], false);
	}
    }

    public void touchesTheBounds(int i, int j) {
	if (i < array.length && i >= 0 && j < array[0].length && j >= 0
		&& !visited[i][j] && array[i][j] == 'O') {
	    visited[i][j] = true;
	    touchesTheBounds(i - 1, j);
	    touchesTheBounds(i + 1, j);
	    touchesTheBounds(i, j + 1);
	    touchesTheBounds(i, j - 1);
	}

    }

    public char[][] solve() {
	int j, i;
	for (i = 0; i < array.length; i++) {
	    touchesTheBounds(i, 0);
	    touchesTheBounds(i, array[0].length - 1);
	}

	for (j = 0; j < array[0].length; j++) {
	    touchesTheBounds(0, j);
	    touchesTheBounds(array.length -1,  j);
	}
	
	for ( i = 0 ; i < array.length ;i++) {
	    for ( j = 0 ; j < array[0].length; j++){
		if(!visited[i][j]) {
		    array[i][j] = 'X';
		}
	    }
	}
	return array;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	char[][] array = new char[4][5];
	for (int i = 0 ; i < array.length ;i++) {
	    Arrays.fill(array[i], 'X');; 
	}
	
	array[0][0] = 'O';
	array[1][2] = 'O';
	array[1][3] = 'O';
	array[2][2] = 'O';
	array[2][3] = 'O';
	array[2][3] = 'O';
	array[3][0] = 'O';
	//array[2][4] = 'O';
	
	for (int i = 0 ; i < array.length ;i++) {
	    for (int j = 0 ; j < array[0].length; j++){
		System.out.print(array[i][j] + " ");
	    }
		System.out.println();
	}
	
	FilltheO o = new FilltheO(array);
	array = o.solve();
	System.out.println();
	System.out.println();
	for (int i = 0 ; i < array.length ;i++) {
	    for (int j = 0 ; j < array[0].length; j++){
		System.out.print(array[i][j] + " ");
	    }
		System.out.println();
	}
	
    }

}
