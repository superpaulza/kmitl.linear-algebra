import java.util.Scanner;

public class MySolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Numbers of Equations => "); int nq = sc.nextInt();
        /*double[][] MatA = new double[nq][nq];
        System.out.println("Matrix A: ");
        for(int i = 0; i < nq; i++) {
            for(int j = 0; j < nq; j++) {
                MatA[i][j] = sc.nextDouble();
            }
        }
        double[] MatB = new double[nq];
        System.out.println("Matrix B: ");
        for(int i = 0; i < nq; i++) {
            MatB[i] = sc.nextDouble();
        }*/

        double[][] matrix = new double[nq][nq+1];
        System.out.println("Matrix A: ");
        for(int i = 0; i < nq; i++) {
            for(int j = 0; j < nq; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Matrix B: ");
        for(int i = 0; i < nq; i++) {
            matrix[i][nq] = sc.nextDouble();
        }
        MyMatrix.printMatrix(matrix);
        double[] ans = MyGaussElim.solver(MyGaussElim.StepReduceRow(matrix), nq);
        System.out.println("Solve: ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print("x"+(i+1)+" = ");
            System.out.print(ans[i]+" ");
        }
    }
}
