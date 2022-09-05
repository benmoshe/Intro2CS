package week5;
public class Matrices {

    public static void main(String[] args) {

    	// create a square matrix
    	final int N = 3;
    	int[][] matrix = new int[N][N];

    	// ask user to fill it
    	for (int i=0; i<N; i++)
    	{
    		for (int j=0; j<N; j++)
    		{
    			int num = MyConsole.readInt("Enter row " + i + " column " + j + ":");
    			matrix[i][j] = num;
    		}
    	}

    	// print matrix
    	myPrint(matrix);

    	// check if the matrix has special properties
    	boolean dia = isDiagonal(matrix);
    	boolean identity = isIdentity(matrix);
    	boolean upper = isUpperDiagonal(matrix);
    	boolean symmetric = isSymmetric(matrix);

    	System.out.println(" Diagonal: " + dia + "\n Identity: " + identity + "\n Upper Diagonal: " + upper + "\n Symmetric: " + symmetric);
		
		// transpose the matrix
		matrixTranspose(matrix);
		myPrint(matrix);
    }


    // This method prints a matrix
    public static void myPrint(int[][] m) {
    	int rows = m.length;
       	int columns = m[0].length;	// size of first row
       	for (int i=0; i<rows; i++)
       	{
       		for (int j=0; j<columns; j++)
       			System.out.print(m[i][j] + "\t");
       		System.out.println();
       	}
    }


    // This method takes a matrix and checks if it's diagonal, and returns true or false. Example:
    // 6 0 0
    // 0 2 0
    // 0 0 7
    public static boolean isDiagonal(int[][] m) {
    	boolean answer = true;
    	for (int i=0; i< m.length; i++)
    	{
    		for (int j=0; j< m[0].length; j++)
    		{
			// when i==j, we're on the diagonal
			// when i!=j, we're not on the diagonal
			// if we're not on the diagonal and see a non-zero number
			// the matrix is not diagonal
    			if((i != j) && (m[i][j] != 0))
    				answer = false;
    		}
    	}
    	return answer;
    }


    // This method takes a matrix and checks if it's the identity matrix, and returns true or false.
    // 1 0 0
    // 0 1 0
    // 0 0 1
    public static boolean isIdentity(int[][] m) {
    	boolean answer = true;
    	for (int i=0; i< m.length; i++)
    	{
    		for (int j=0; j< m[0].length; j++)
    		{
    			// check for 0's not on the diagonal
    			if((i != j) && (m[i][j] != 0))
    				answer = false;
    			// also check for 1's on the diagonal
    			if((i == j) && (m[i][j] != 1))
    				answer = false;
    		}
    	}
    	return answer;
    }


    // This method takes a matrix and checks if it's upper- diagonal, and 
    // returns true or false. Example:
    // 6 1 3
    // 0 2 0
    // 0 0 7
    public static boolean isUpperDiagonal(int[][] m) {
    	boolean answer = true;
    	for (int i=0; i< m.length; i++)
    	{
    		for (int j=0; j< m[0].length; j++) 
    		{
    			// i>j means we're below the diagonal, so we check for 0's
    			if((i > j) && (m[i][j] != 0))
    				answer = false;
    		}
    	}
    	return answer;
    }
    
    public static boolean isUpperDiagonalBetter(int[][] m) {
    	for (int i=1; i< m.length; i++)
    	{
    		for (int j=0; j< i; j++) 
    		{
    			// we only need to check for 0's
    			if(m[i][j] != 0)
    				return false;
    		}
    	}
    	return true;
    }


    // This method takes a matrix and checks if it's symmetric, and 
    // returns true or false. Example:
    // 6 1 3
    // 1 2 0
    // 3 0 7
    public static boolean isSymmetric(int[][] m) {
    	boolean answer = true;
    	for (int i=0; i< m.length; i++) 
    	{
    		for (int j=0; j< m.length; j++) 
    		{
    			// matrix is symmetric if (m[i][j] == m[j][i])
    			if(m[i][j] != m[j][i])
    				answer = false;
    		}
    	}
    	return answer;
    }
	
	public static void matrixTranspose(int[][] m) {
		int i, j, t;
		for (i = 0; i < m.length ;i++)
		{
			for (j = i+1; j < m[0].length; j++)
			{
				t = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = t;
			}
		}
	}
}