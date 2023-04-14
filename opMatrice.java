package TP2_22_23;

public class opMatrice {
	
    public static int[][] add(int[][] A, int[][] B)
    {   
	       int l = A.length;
	       int c = A[0].length;
	       int [][] C = new int[l][c];
		   for (int i=0; i<l;i++) {
			   for (int j=0; j<c;j++) {
			         C[i][j] = A[i][j] + B[i][j];}}
		   return C;
	  }
    public static int[][] sub(int[][] A, int[][] B){
    	
    	int l = A.length;
	       int c = A[0].length;
	       int[][] C = new int[l][c];
		   for (int i=0; i<l;i++) {
			   for (int j=0; j<c;j++) {
			         C[i][j] = A[i][j] - B[i][j];}}
          return C;}
    public static  int[][] multip(int[][] A, int[][] B) 
    {   
       int la = A.length;
       int lb = B.length;
       int cb = B[0].length;
       int [][] C = new int[la][cb];
	   for (int i=0; i<la;i++) {
		   for (int j=0; j<cb;j++) {
		        C[i][j] = 0;
		         for (int k=0;k<lb;k++) {
    	           C[i][j] += A[i][k] * B[k][j];}}}
		         
		   return C;}
	public static int[][] transp(int[][] A)
	{
		   int la = A.length;
	       int ca = A[0].length;
	       int [][] C = new int[ca][la];
		   for (int i=0; i<ca;i++) {
			   for (int j=0; j<la;j++) {
	    	           C[i][j] = A[j][i];}}
		   return C;}
}
