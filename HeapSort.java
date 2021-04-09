package heapsort;
import java.util.ArrayList;
import java.util.List;
//package heapsort;
//import exemple.BRException;
import java.util.Random;

public class HeapSort {
	public List<Integer> sort(List<Integer> arr) {
		int n = arr.size();

		/* Parteix de la mitad de la array i s'en va cap a l'esquerra. Despr�s crida al m�tode heapify
		 i li passa la propia array, la seva longitud i la posici� */
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		/* Cambia el n�mero de la esquerra, que �s el m�s gran, per l'�ltim i crida a heapify
		per� aquest cop desde la posici� cero i amb n un punt m�s petit, de forma que el gran
		que acabem canviant ja no entra en el lloc */ 
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr.get(0);
			arr.set(0,arr.get(i));
			arr.set(i,temp);

			/* Anir� col�locant el m�s gran a la esquerra, sortir� d'aqu� i canviant-lo per l'ultim m�s u
			fins que la posici� 0 sigui igual a la posici� i*/
			heapify(arr, i, 0);
		}
		
		return arr;
	}

	/* Heapify determina tres par�metres, la posici� actual el doble d'aquesta m�s 1 i el doble d'aquesta 
	m�s 2*/
	void heapify(List<Integer> arr, int n, int i) {
		int largest = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		/* Si el doble de la posici� m�s 1 es m�s gran que la longitud de l'array i el seu valor
		tamb� �s major que el de posici� actual, pivotem sobre aquesta posici� */
		
		if (l < n && arr.get(l) > arr.get(largest))
			largest = l;

		/* Si el doble de la posici� m�s 1 es m�s gran que la longitud de l'array i el seu valor
		tamb� �s major que el de posici� actual, pivotem sobre aquesta posici�*/
		if (r < n && arr.get(r) > arr.get(largest))
			largest = r;

		/* Si despr�s d'aquests dos if no estem pivotan sobre la posici� actual, guardem el seu valor
		 i el cambiem pel valor de la posici� on estem pivotant i al seu lloc i fiquem el valor de la 
		posici� actual. */
		if (largest != i) {
			int swap = arr.get(i);
			arr.set(i,arr.get(largest));
			arr.set(largest,swap);

			// Fem el mateix proc�s de forma recursiva fins que array t� el numero m�s alt a la primera posici�.
			//entrant i sortint de heapify fins que i es menos que 0.
			heapify(arr, n, largest);
		}
	}

	/* Recorre l'array i imprimeix els elements un per un, obtenim el valor amb el get() 
	 i la posici� com a argument "i" */
	
	static void printArray(List<Integer> arr) {
		int n = arr.size(); 
		for (int i = 0; i < n; ++i)
			System.out.print(arr.get(i)+" ");
//			double random = list.get(rand.nextInt(list.size()));
		System.out.println();
	}
	
	/* Transforma el text introdu�t per teclat en un integer i si salta NumberFormatExcepcion
	 retorna null i fa saltar la nostre propia excepci� */

	private static Integer getInt(String texto) {
		try {
			return Integer.parseInt(texto);
		}catch (NumberFormatException e){
			return null;
		}
	}

	/* El main crea una array d'integer i defineix una nativa d'string.numero, que es recorre i es va convertint 
	 en nombres, afegint-los un per un a list, despr�s fa un inst�ncia de la clase HeapSort i utiliza el m�tode 
	 sort() per ordenarla, finalment la imprimeix amb printArray()*/
	
	public static void main(String args[])throws HeapSortException {
		List<Integer> list = new ArrayList<Integer>();
		String arr[] = { "12", "4", "13", "5", "6", "7" };
		int n = arr.length;
		
		for (int x = 0; x < n; x++) {
			if (getInt(arr[x]) == null) throw new HeapSortException("Solo se pueden introducir valores numericos");
			int n1 = getInt(arr[x]);
			list.add(n1);
			System.out.println(arr[x]);
		}

		HeapSort ob = new HeapSort(); 
		ob.sort(list); 

		System.out.println("Sorted array is"); 
		printArray(list); 
	}
}
