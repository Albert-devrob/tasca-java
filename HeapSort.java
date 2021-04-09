package heapsort;
import java.util.ArrayList;
import java.util.List;
//package heapsort;
//import exemple.BRException;
import java.util.Random;

public class HeapSort {
	public List<Integer> sort(List<Integer> arr) {
		int n = arr.size();

		/* Parteix de la mitad de la array i s'en va cap a l'esquerra. Després crida al mètode heapify
		 i li passa la propia array, la seva longitud i la posició */
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		/* Cambia el número de la esquerra, que és el més gran, per l'últim i crida a heapify
		però aquest cop desde la posició cero i amb n un punt més petit, de forma que el gran
		que acabem canviant ja no entra en el lloc */ 
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr.get(0);
			arr.set(0,arr.get(i));
			arr.set(i,temp);

			/* Anirá col·locant el més gran a la esquerra, sortirà d'aquí i canviant-lo per l'ultim més u
			fins que la posició 0 sigui igual a la posició i*/
			heapify(arr, i, 0);
		}
		
		return arr;
	}

	/* Heapify determina tres paràmetres, la posició actual el doble d'aquesta més 1 i el doble d'aquesta 
	més 2*/
	void heapify(List<Integer> arr, int n, int i) {
		int largest = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 

		/* Si el doble de la posició més 1 es més gran que la longitud de l'array i el seu valor
		també és major que el de posició actual, pivotem sobre aquesta posició */
		
		if (l < n && arr.get(l) > arr.get(largest))
			largest = l;

		/* Si el doble de la posició més 1 es més gran que la longitud de l'array i el seu valor
		també és major que el de posició actual, pivotem sobre aquesta posició*/
		if (r < n && arr.get(r) > arr.get(largest))
			largest = r;

		/* Si després d'aquests dos if no estem pivotan sobre la posició actual, guardem el seu valor
		 i el cambiem pel valor de la posició on estem pivotant i al seu lloc i fiquem el valor de la 
		posició actual. */
		if (largest != i) {
			int swap = arr.get(i);
			arr.set(i,arr.get(largest));
			arr.set(largest,swap);

			// Fem el mateix procés de forma recursiva fins que array té el numero més alt a la primera posició.
			//entrant i sortint de heapify fins que i es menos que 0.
			heapify(arr, n, largest);
		}
	}

	/* Recorre l'array i imprimeix els elements un per un, obtenim el valor amb el get() 
	 i la posició com a argument "i" */
	
	static void printArray(List<Integer> arr) {
		int n = arr.size(); 
		for (int i = 0; i < n; ++i)
			System.out.print(arr.get(i)+" ");
//			double random = list.get(rand.nextInt(list.size()));
		System.out.println();
	}
	
	/* Transforma el text introduït per teclat en un integer i si salta NumberFormatExcepcion
	 retorna null i fa saltar la nostre propia excepció */

	private static Integer getInt(String texto) {
		try {
			return Integer.parseInt(texto);
		}catch (NumberFormatException e){
			return null;
		}
	}

	/* El main crea una array d'integer i defineix una nativa d'string.numero, que es recorre i es va convertint 
	 en nombres, afegint-los un per un a list, després fa un instància de la clase HeapSort i utiliza el mètode 
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
