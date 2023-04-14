//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP2_22_23;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import TP4_22_23.Utilisateur;

 public class Serveur extends Thread{
    static final int port = 2023;
    private Socket socket;
    private static ArrayList<Utilisateur> Clients = new ArrayList<Utilisateur>();
    
	public static void main(String argv []) throws Exception {
	    Clients.add(new Utilisateur("Amina", "isi"));
        Clients.add(new Utilisateur("Yacine", "wic"));

		ServerSocket ss = new ServerSocket(port);
   	    System.out.println("Serveur en attente:");

    	while (true) {
    	 Socket socketclient=ss.accept();
         System.out.println("Un client se connect");

         Serveur thread=new Serveur(socketclient);
         thread.start();}
    	 }
         
    public Serveur(Socket soc) {this.socket=soc;}

    public String login(String id, String pass){
    	
        for (int i = 0; i < Clients.size(); i++) {
            if (id.equals(Clients.get(i).id)) {
                if (pass.equals(Clients.get(i).pass)) {
                	 System.out.println("Utilisateur Identifié ");
                     return "Bienvenue";
                     }
                else {
                    return "Mot de passe incorrect";}
                }
            else {
                Clients.add(new Utilisateur(id, pass));
                System.out.println("Utilisateur enregistré ");
                return "Bienvenue";
                }
            }
        return "Bienvenue";

    }
        
     public void run () {
         	 try {
        		 ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
    	         ObjectInputStream in=new ObjectInputStream(socket.getInputStream());

    	         while (true) {
    	        	 String username=(String) in.readObject();
    	        	 String password=(String) in.readObject();

    	             String reponse = login(username, password);
    	             out.writeObject(reponse);
    	             int[][] A = (int[][]) in.readObject();
    	             int[][] B = (int[][]) in.readObject();
    	        	 int[][] A1 = (int[][]) in.readObject();
    	        	 int[][] B1 = (int[][]) in.readObject();

    	            int choix=(int) in.readObject();
    	        	switch(choix){
    	     	   
    	            case 1: 
    	            	int[][] resultadd=opMatrice.add(A1,B1);
    	            	out.writeObject("---Addition---");
    	            	out.writeObject(resultadd);

    	           	 break;
    	            case 2:
    	            	int[][] resultsub=opMatrice.sub(A1,B1);
    	            	out.writeObject("---Soustraction---");
    	            	out.writeObject(resultsub);

    	           	 break;
    	            case 3:
    	            	int[][] resultmult=opMatrice.multip(A,B);
    	            	out.writeObject("---Multiplication---");
    	            	out.writeObject(resultmult);
    	           	 break;
    	            case 4:
    	            	int[][] resultransp=opMatrice.transp(A1);
    	            	out.writeObject("---Transposée de matrice---");
    	            	out.writeObject(resultransp);

    	           	 break;
    	            default:
    	            	out.writeObject("Choix incorrect");
    	                break;
    	                }
    	         	}
    	         }
              catch (Exception e){
              System.err.println("Erreur : "+e);
              }
        	 

    }

}
