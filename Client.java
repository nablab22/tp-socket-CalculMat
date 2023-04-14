//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP2_22_23;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	static int port = 2023;
    static String host="localhost";
	public static void main(String argv []) {
	try {
		Socket socket=new Socket(InetAddress.getByName(host),port);
 
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
	    ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
	    
	    int A[][] = {{1,2,0},{4,3,-1}};
	    int B[][] = {{5,1},{2,3},{3,4}};
        int[][] A1 = { {1, 5, 3}, {2, 4, 1} , {9, 6, 0}};
        int[][] B1 = { {2, 7, 3}, {0, 9, 3} , {8, 2, 7} };
	    Scanner scan = new Scanner(System.in);
        System.out.print("Identifiant:");
        String username = scan.nextLine();
        System.out.print("Mot de passe:");
        String password = scan.next();

        out.writeObject(username);
        out.writeObject(password);

	    while (true) {
            String reponse = (String) in.readObject();
            System.out.println(reponse);
            if (reponse.equals("Bienvenue")) {
	        out.writeObject(A);
	        out.writeObject(B);
	        out.writeObject(A1);
	        out.writeObject(B1);
	        System.out.println("Choisir l'operation à faire:\n"+
					"1. Addition\n" +"2. Soustraction\n"+"3. Multiplication\n"+"4. Transposée de matrice");
	        int choix =scan.nextInt();

	        out.writeObject(choix);
	        
	        String operation = (String) in.readObject();
            System.out.println(operation);

            int[][] C = (int[][]) in.readObject();
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
            

        }
            }
	    }      
	catch (Exception e){System.err.println("Erreur:"+e);}
	}
}
