
public class ExercicioOrd {
	class Main {
		  public static void main(String[] args) {

		    int quantidade = 20;
		    int[] vetor = new int[quantidade];

		    for (int i = 0; i < vetor.length; i++) {
		      vetor[i] = (int) (Math.random() * quantidade);
		    }

		    long tempoInicial = System.nanoTime();

		    insertionSort(vetor);

		    long tempoFinal = System.nanoTime();

		    System.out.println("Sort 20 executado em em = " + (tempoFinal - tempoInicial) + " ns");

		    tempoInicial = System.nanoTime();

		    mergeSort(vetor, vetor.length);

		    tempoFinal = System.nanoTime();

		    System.out.println("mergeSort 20 executado em em = " + (tempoFinal - tempoInicial) + " ns");

		    
		    int quantidade2 = 20000;
		    int[] vetor2 = new int[quantidade2];

		    for (int i = 0; i < vetor2.length; i++) {
		      vetor2[i] = (int) (Math.random() * quantidade2);
		    }

		    
		    tempoInicial = System.nanoTime();

		    insertionSort(vetor2);

		    tempoFinal = System.nanoTime();

		    System.out.println("Sort 20k executado em em = " + (tempoFinal - tempoInicial) + " ns");

		    
		    tempoInicial = System.nanoTime();

		    mergeSort(vetor2, vetor2.length);

		    tempoFinal = System.nanoTime();

		    System.out.println("mergeSort 20k executado em em = " + (tempoFinal - tempoInicial) + " ns");

		  }

		  public static void insertionSort(int[] vetor) {
		    int j;
		    int key;
		    int i;

		    for (j = 1; j < vetor.length; j++) {
		      key = vetor[j];
		      for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
		        vetor[i + 1] = vetor[i];
		      }
		      vetor[i + 1] = key;
		    }
		  }
		  

		  public static void mergeSort(int[] a, int n) {
		    if (n < 2) {
		      return;
		    }
		    int mid = n / 2;
		    int[] l = new int[mid];
		    int[] r = new int[n - mid];

		    for (int i = 0; i < mid; i++) {
		      l[i] = a[i];
		    }
		    for (int i = mid; i < n; i++) {
		      r[i - mid] = a[i];
		    }
		    mergeSort(l, mid);
		    mergeSort(r, n - mid);

		    merge(a, l, r, mid, n - mid);
		  }

		  public static void merge(
		      int[] a, int[] l, int[] r, int left, int right) {

		    int i = 0, j = 0, k = 0;
		    while (i < left && j < right) {
		      if (l[i] <= r[j]) {
		        a[k++] = l[i++];
		      } else {
		        a[k++] = r[j++];
		      }
		    }
		    while (i < left) {
		      a[k++] = l[i++];
		    }
		    while (j < right) {
		      a[k++] = r[j++];
		    }
		  }
		}
}
