//Gauss-Seidel
public class MyGausssei {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		double[][] matrix = {{4,6,-2,40},{3,-5,2,-24},{1,9,-8,10}};
		//double[][] matrix = {{3,-0.1,-0.2,8.5},{0.1,7,-0.3,2},{0.3,-0.2,10,10}};
		System.out.println("Matrix :");
		MyMatrix.printMatrix(matrix);
		System.out.println();
		solver(matrix);
		long stop = System.currentTimeMillis();
		System.out.println("\nExecution Time: " + (stop-start) + " ms.");
	}
	
	public static void solver(double[][] matrix) {
		double ox1 = 0, /*ox2 = 0, ox3 = 0,*/ 
				x1 = 0, x2 = 0, x3 = 0, 
				esl = 1/*, esl2 = 1, esl3 = 1*/;
		for (int i = 0; esl > 0.01 /*&& esl2 > 0.01 && esl3 > 0.01*/; i++) {
			x1 = (matrix[0][3]-(matrix[0][1]*x2)-(matrix[0][2]*x3))/matrix[0][0];
			esl = Math.abs(((ox1-x1)/x1)*100);
			ox1 = x1;
			x2 = (matrix[1][3]-(matrix[1][0]*x1)-(matrix[1][2]*x3))/matrix[1][1];
			/*esl2 = Math.abs(((ox2-x2)/x2)*100);
			ox2 = x2;*/
			x3 = (matrix[2][3]-(matrix[2][0]*x1)-(matrix[2][1]*x2))/matrix[2][2];
			/*esl3 = Math.abs(((ox3-x3)/x3)*100);
			ox3 = x3;*/
			System.out.println("Round: " + (i+1));
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
			System.out.println("x3 = " + x3);
			System.out.println("Epsilon = " + esl + " (Estimate: " + String.format("%.2f", esl) + ")");
			/*System.out.println("Epsilon2 = " + esl2);
			System.out.println("Epsilon3 = " + esl3);*/
			System.out.println("=====================================");
		}
		System.out.printf("Answer: x1 = %d, x2 = %d, x3 = %d",Math.round(x1),Math.round(x2),Math.round(x3));
	}
	
	
}
