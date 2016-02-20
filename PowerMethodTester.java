import java.util.Scanner;

import Jama.Matrix;

public class PowerMethodTester {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
System.out.println("What size square matrix would you like to create?");
int n = sc.nextInt();
Matrix M = new Matrix(n,n);
for (int j = 0; j < n; j++) {
for (int k = 0; k < n; k++) {
System.out.println("What is the value for row " + j + " column " + k + "?");
double x = sc.nextDouble();
M.set(j, k, x);
}
}
Matrix g = new Matrix(n, 1);
for (int j = 0; j < n; j++) {
System.out.println("What is the (" + j + ") parameter of you initial guess?");
g.set(j, 0, sc.nextDouble());
}


		
		System.out.println("Type in what tolerance you want to use");
		double tolerance= sc.nextDouble();
		System.out.println("Type in cutoff for iterations");
		int cutoff=sc.nextInt();
		sc.close();
		Power p= new Power(M, g, tolerance, cutoff);
		p.doPower();
		System.out.println("Eigenvalue: " + p.getEigenVal());
		System.out.println("Eigenvector: " +"["+ p.getEigenVec().get(0, 0) + " "+ p.getEigenVec().get(1, 0)+"]");
		System.out.println("Iterations: " + p.getIterations());
	}
}
