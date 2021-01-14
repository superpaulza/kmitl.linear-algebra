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

	public static double[] solver(double[][] MatA, double[] MatB) {
		int N = MatB.length;
		for(int k = 0; k < N; k++) {
			int max = N;
			for(int i = k+1; i < N; i++) {
				if(Math.abs(MatA[i][k]) > Math.abs(MatA[max][k])) max = i;
			}

			double[] temp = MatA[k];
			MatA[k] = MatA[max];
			MatA[max] = temp;

			double t = MatB[k];
			MatB[k] = MatB[max];
			MatB[max] = t;

			for(int i = k+1; i < N; i++) {
				double factor = MatA[i][k] / MatA[k][k];
				MatB[i] -= factor * MatB[k];
				for(int j = k; j < N; j++) {
					MatA[i][j] -= factor * MatA[k][j];
				} 
			}
		}

		double[] solution = new double[N];
		for(int i = N - 1; i >= 0; i--) {
			double sum = 0.0;
			for(int j = i + 1; j < N; j++) {
				sum += MatA[i][j] * solution[j];
			}
			solution[i] = (MatB[i] - sum) / MatA[i][i];
		}
		return solution;
	}
	
	public static void solver(double[][] matrix) {
		double x4 = matrix[4-1][5-1]/matrix[4-1][4-1];
		double x3 = (matrix[3-1][5-1]-matrix[3-1][4-1]*x4)/matrix[3-1][3-1];
		double x2 = (matrix[2-1][5-1]-matrix[2-1][4-1]*x4-matrix[2-1][3-1]*x3)/matrix[2-1][2-1];
		double x1 = (matrix[1-1][5-1]-matrix[1-1][4-1]*x4-matrix[1-1][3-1]*x3-matrix[1-1][2-1]*x2)/matrix[1-1][1-1];
		System.out.println("Answer: x1 = "+x1+" x2 = "+x2 + " x3 = "+ x3+" x4 = "+ x4 );
	}

	public static double[] solver(double[][] matrix, int nq) {
		double[] solution = new double[nq];
		for(int i = nq - 1; i >= 0; i--) {
			double sum = 0.0;
			for(int j = i + 1; j < nq; j++) {
				sum += matrix[i][j] * solution[j];
			}
			solution[i] = (matrix[i][nq] - sum) / matrix[i][i];
		}
		return solution;
	}
}
