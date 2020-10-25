//Gaussian Eliminations
public class MyGaussElim {

	public static void main(String[] args) {
		double[][] matrix = {{2,3,-2,1,9},{4,8,1,4,1},{1,1,-2,1,9},{3,-2,5,-3,-2}};
		System.out.println("Matrix :");
		MyMatrix.printMatrix(matrix);
		System.out.println();
		solver(StepReduceRow(matrix));
	}
	public static double[][] StepReduceRow(double[][] matrix) {
		int count = 1;
		double temp[] = new double[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
         double lead = matrix[i][i];
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j]/=lead;
				temp[j] = matrix[i][j];
			}
			System.out.println("Step: " + count);
			System.out.println("R"+ "[" + (i+1)+"]" +" / " + lead + " --> R" + "["+(i+1)+"]");
			MyMatrix.printMatrix(matrix);
			System.out.println();
			count++;
			for (int k = i+1; k < matrix.length; k++) {
            lead = matrix[k][i];
				for (int l = 0; l < matrix[0].length; l++) {
					temp[l]*=lead;
				}
				for (int m = 0; m < matrix[0].length; m++) {
					matrix[k][m]-=temp[m];
					temp[m] = matrix[i][m];
				}
				System.out.println("Step: " + count);
				System.out.println("R"+ "["+ (k+1)+"]" +" - " + lead + "R" + "["+(i+1)+"]" + " --> R" + "["+(k+1)+"]");
				MyMatrix.printMatrix(matrix);
				System.out.println();
				count++;
			}
		}
		return matrix;
	}
	
	public static void solver(double[][] matrix) {
		double x4 = matrix[4-1][5-1]/matrix[4-1][4-1];
		double x3 = (matrix[3-1][5-1]-matrix[3-1][4-1]*x4)/matrix[3-1][3-1];
		double x2 = (matrix[2-1][5-1]-matrix[2-1][4-1]*x4-matrix[2-1][3-1]*x3)/matrix[2-1][2-1];
		double x1 = (matrix[1-1][5-1]-matrix[1-1][4-1]*x4-matrix[1-1][3-1]*x3-matrix[1-1][2-1]*x2)/matrix[1-1][1-1];
		System.out.println("Answer: x1 = "+x1+" x2 = "+x2 + " x3 = "+ x3+" x4 = "+ x4 );
	}
}
