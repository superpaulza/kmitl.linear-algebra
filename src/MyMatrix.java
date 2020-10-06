//MatrixUtils
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double[][] buildArrayfm() {
		int i = 0, j = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please enter your matrix dimension e.g, i*j");
			String di = sc.nextLine();
				if(Pattern.matches("^\\d+[*]\\d+$",di)) {
					i = Integer.parseInt(di.substring(0,di.indexOf("*")));
					if(i == 0) { 
						System.err.println("Error: i dimension must more than 0!");
						continue;
					}
					j = Integer.parseInt(di.substring(di.indexOf("*")+1,di.length()));
					if(j == 0) { 
						System.err.println("Error: j dimension must more than 0!");
						continue;
					}
					break;
				}
				else { 
					System.err.println("Error: Mismatch matrix dimension format, Please try again!");
					continue;
				}
		} while (true);
		double[][] a = new double[i][j];
		System.out.println("Enter Matrix" + "["+ i + "*" + j+"]" + "by row e.g, a11 a12 a13...");
		System.out.println("**leave a space between the number**");
		System.out.println("**Press 'Enter' for next row**");
		for(int n = 0; n < i; n++) {
			System.out.print("R"+"["+ (n+1) +"]: ");
			for(int m = 0; m < j; m++) {
				a[n][m] = sc.nextInt();
			}
		}
		System.out.println();
		return a;
	}
	

	public static void buildArrayfe() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the number of equations in the system ==> ");
		int no = sc.nextInt();
		for(int i = 0; i < no; i++) {
			String eq = sc.nextLine();
			
		}
	}
	
	public static void printMatrixS(int[][] matrix) {
		System.out.println();
		for (int[] row : matrix) {
		    System.out.println(Arrays.toString(row));
		}
	}
	
	public static void printMatrix(double[][] matrix) {
	    int cols = matrix[0].length;
	    int[] iWidths = new int[cols];
	    int[] fWidths = new int[cols];
	    for (double[] row : matrix) {
	        for (int c = 0; c < cols; c++) {
	            String[] parts = String.valueOf(row[c]).split("\\.");
	            iWidths[c] = Math.max(iWidths[c], parts[0].length());
	            fWidths[c] = Math.max(fWidths[c], parts[1].length());
	        }
	    }
	    for (double[] row : matrix) {
	        for (int c = 0; c < cols; c++) {
	            String[] parts = String.valueOf(row[c]).split("\\.");
	            int lp = iWidths[c] - parts[0].length();
	            int rp = fWidths[c] - parts[1].length();
	            String fmt = String.format("%s%%%ss%%s.%%s%%%ss%s",
	                    c == 0 ? "|" : "  ",
	                    lp == 0 ? "" : lp,
	                    rp == 0 ? "" : rp,
	                    c < cols - 1 ? "" : "|%n");
	            System.out.printf(fmt, "", parts[0], parts[1], "");
	        }
	    }
	}
}
