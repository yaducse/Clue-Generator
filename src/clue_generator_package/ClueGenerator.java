package clue_generator_package;

import java.util.Scanner;


public class ClueGenerator {
	
	public static void rotateMatrix(int m, int n, String matrix[][], int k) { 
		
		int row = k, col = k; 
		String prev, curr; 
		
		prev = matrix[row + 1][col]; 
  
		for (int i = col; i < n; i++) { 
			
			curr = matrix[row][i]; 
			matrix[row][i] = prev; 
			prev = curr;
			
		} 
		row++; 
 
		for (int i = row; i < m; i++) { 
			curr = matrix[i][n-1]; 
			matrix[i][n-1] = prev; 
			prev = curr; 
		} 
		n--; 
  
        for (int i = n-1; i >= col; i--) { 
        	curr = matrix[m-1][i]; 
        	matrix[m-1][i] = prev; 
        	prev = curr; 
        }  
        m--;

        for (int i = m-1; i >= row; i--) { 
        	curr = matrix[i][col]; 
        	matrix[i][col] = prev; 
        	prev = curr; 
        } 
        col++; 

	}//end_func_rotateMatrix()
	
	public static void antiRotateMatrix(int m, int n, String matrix[][], int k) {
		
		int row = k, col = k; 
		String prev, curr; 
		
		prev = matrix[row][col + 1]; 
  
		for (int i = row; i < m; i++) { 
			
			curr = matrix[i][col]; 
			matrix[i][col] = prev; 
			prev = curr;
			
		} 
		col++; 
 
		for (int i = col; i < n; i++) { 
			curr = matrix[m-1][i]; 
			matrix[m-1][i] = prev; 
			prev = curr; 
		} 
		m--; 
  		
        for (int i = m-1; i >= row; i--) { 
        	curr = matrix[i][n-1]; 
        	matrix[i][n-1] = prev; 
        	prev = curr; 
        }  
        n--;

        for (int i = n-1; i >= col; i--) { 
        	curr = matrix[row][i]; 
        	matrix[row][i] = prev; 
        	prev = curr; 
        } 
        row++; 

	}//end_func_antiRotateMatrix()
	
	public static void display(int row, int col, String clue_matrix[][]) {
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++)
				System.out.print(clue_matrix[i][j]+" ");
			System.out.println();
		}
	}//end_func_display()
	
	public static String matrixToString(int row, int col, String clue_matrix[][]) {
		
		String result="";
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++)
				result+=clue_matrix[i][j];
		}
		return result;
	}//end_func_matrixToString

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//********Uncomment below 4 lines to take input from user*********		
		
//		System.out.println("Enter the number of Rotations needed: ");
//		int no_of_rotations = Integer.parseInt(sc.nextLine());
//		System.out.println("Enter the Clue : ");
//		String clue = sc.nextLine();
		
//***********Comment the below 2 lines if u uncommented above 4 lines*********
		
		int no_of_rotations=3; //Line 1
		String clue="he find #o un eht#eyekr th# racksde"; //Line 2

		String[] clue_array = clue.split("#",0);
		int row = clue_array.length;
		int col = clue_array[0].length();
		String[][] clue_matrix = new String[row][col];
		
		for(int i=0; i<row; i++)
			for(int j=0; j<col; j++)
				clue_matrix[i][j]=String.valueOf(clue_array[i].charAt(j));

	//Uncomment below line to display input in matrix form
		//display(row,col,clueMatrix);
		
		for(int layer=0; layer<row; layer++) {
			int m = row-layer;
			int n = col-layer;
			if (row-layer*2<=1 || col-layer*2<=1) 
				break;
			else {
				for(int z=0; z<no_of_rotations; z++) {
					if(layer%2==0)	//for even layers(0,2,4,...)
						antiRotateMatrix(m, n, clue_matrix, layer);
					else //for odd layers(1,2,3,...)
						rotateMatrix(m, n, clue_matrix, layer);
				}//end_for(z)
				
			}//end_else
			
		}//end_for(k)

		String decoded_clue = matrixToString(row, col, clue_matrix);
		System.out.println("The Decoded Information in clue is: "+decoded_clue);
			
		sc.close();

	}

	

}
