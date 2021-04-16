cambiat
package exercici_quatre;

import java.io.*;
import java.util.ArrayList;

class lletra
{
	private char id;
	private int freq;

	public lletra(char id)
	{
		this.id=id;
		this.freq=0;
	}

	public char getId()
	{
		return this.id;
	}

	public int getFreq()
	{
		return this.freq;
	}

	public void incFreq()
	{
		this.freq++;
	}

}
     

	public static void incrementa(String cadena, char c, int i)
	{
		int posicion=cadena.indexOf(c);
		int contador = 0;
        while (posicion != -1) {
        	
        	lletres.get(i).incFreq();
            posicion = cadena.indexOf(c, posicion + 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try
	      {
	         InputStreamReader leer = new InputStreamReader(System.in);
	         BufferedReader buff = new BufferedReader(leer);
	         String texto = buff.readLine().toLowerCase();
	         
		    lletres=new ArrayList<lletra>();
		    inicialitza();
		    int size=lletres.size();
		    
		   for (int i=0; i<size; i++ ) {
				 
			    incrementa(texto,lletres.get(i).getId(),i);
			    
			    }
		    
		    for (int i=0; i<size; i++ ) {
		 
		    System.out.println(lletres.get(i).getId());
		    System.out.println(lletres.get(i).getFreq());
		    }
	          
	      }
	      //leer del teclado como String
	      catch(Exception e) {
	      	System.out.println(e.toString());
	      }

	}

}
