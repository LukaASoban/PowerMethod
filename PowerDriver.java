
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

import Jama.*;

public class PowerDriver {
	private static ArrayList<Integer> iterations= new ArrayList<Integer>();
	private static ArrayList<Double> determinants= new ArrayList<Double>();
	private static ArrayList<Double>traces= new ArrayList<Double>();
	
	private static ArrayList<Integer> Iiterations= new ArrayList<Integer>();
	private static ArrayList<Double> Ideterminants= new ArrayList<Double>();
	private static ArrayList<Double> Itraces= new ArrayList<Double>();
	
	public static void main(String[] args){
		
		for(int i=0; i<1000; i++){
			Matrix a= Matrix.random(2, 2);
			for(int j=0; j<2; j++){
				for(int k=0; k<2; k++){
					double x = (double)Math.random() *(4)-2;
					a.set(j, k, x);
				}
			}
			double[][] array = {{1.},{1.}};
			Matrix g= new Matrix(array);
			Power p= new Power(a, g, 0.00005, 100);
			p.doPower();
			iterations.add(p.getIterations());
			determinants.add(getDeterminant(a));
			traces.add(getTrace(a));
			
			Matrix inv=getInverse(a);
			Power Ip= new Power(inv, g, 0.00005, 100);
			Ip.doPower();
			Iiterations.add(Ip.getIterations());
			Ideterminants.add(getDeterminant(inv));
			Itraces.add(getTrace(inv));
			
			System.out.println("Largest Eigenvalue: " + p.getEigenVal());
			System.out.println("Smallest Eigenvalue: " + 1/Ip.getEigenVal());
			System.out.println("Large Eigenvector: " +"["+ p.getEigenVec().get(0, 0) + " "+ p.getEigenVec().get(1, 0)+"]");
			System.out.println("Small Eigenvector: " +"["+ Ip.getEigenVec().get(0, 0) + " "+ Ip.getEigenVec().get(1, 0)+"]");
			System.out.println("Normal Iterations: " + p.getIterations());
			System.out.println("Inverse Iterations: " + Ip.getIterations());
			System.out.println();
		}
		
	}
	
	public static double getDeterminant(Matrix A){
		double det= (A.get(0, 0)*A.get(1, 1))-(A.get(0, 1)*A.get(1, 0));
		return det;
	}
	
	public static double getTrace(Matrix A){
		double t= A.get(0, 0)+A.get(1, 1);
		return t;
	}
	
	public static Matrix getInverse(Matrix A){
		Matrix I= A;
		I.set(0,0,A.get(1, 1));
		I.set(1, 1, A.get(0, 0));
		I.set(0, 1, A.get(1, 0)*-1);
		I.set(1, 0, A.get(0, 1)*-1);
		return I;
	}
	
	public ArrayList<Double> getDeterminants(){
		return determinants;
	}
	
	public ArrayList<Integer> getIterations(){
		return iterations;
	}
	
	public ArrayList<Double> getTraces(){
		return traces;
	}
	
	public ArrayList<Double> getIDeterminants(){
		return Ideterminants;
	}
	
	public ArrayList<Integer> getIIterations(){
		return Iiterations;
	}
	
	public ArrayList<Double> getITraces(){
		return Itraces;
	}
}
