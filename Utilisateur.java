package TP2_22_23;

import java.io.Serializable;

public class Utilisateur implements Serializable{
	
	    public String id;
        public String pass;
        
        public Utilisateur(String id,String pass) {
            super();
            this.id=id;
            this.pass=pass;
        }
}
