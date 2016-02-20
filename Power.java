import Jama.*;

import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Scanner;

public class Power {
	private Matrix matrix;
	private Matrix u;
	private double tolerance;
	private int N;
	private double eigenVal;
	private Matrix eigenVec;
	private int iterations;
	private double error;

	public Power(Matrix M, Matrix guess, double t, int cutoff){
		matrix= M;
		u= guess;
		tolerance=t;
		N=cutoff;
	}
	
	public void doPower(){
		iterations=0;
		error=1;
		double a=1;
		double prevA=1;
       while(iterations<N  && error>tolerance){
    	   u= matrix.times(u);
    	   prevA=a;
    	   a =u.get(0, 0);
    	   u=u.times(1/a);
    	   error=Math.abs(prevA-a);
    	   iterations++;
       }
       eigenVec=u;
       eigenVal=a;
	}
	
	public Matrix getEigenVec(){
		return eigenVec;
	}
	
	public double getEigenVal(){
		return Math.abs(eigenVal);
	}
	
	public int getIterations(){
		return iterations;
	}
	
}