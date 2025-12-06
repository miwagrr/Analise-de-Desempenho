import Estruturas.ArvoreABB;
import Estruturas.ArvoreAVL;
import Estruturas.Vetor;

public class MedidorTempo {
    public static double medirInsercaoEmVetor(int[] elementos){
        Vetor vetor = new Vetor(elementos.length);
        long inicio = System.nanoTime();

        for(int i = 0; i < elementos.length; i++){
            vetor.inserirVetor(elementos[i]);
        }

        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirInsercaoEmABB(int[] elementos){
        ArvoreABB arvoreABB = new ArvoreABB();
        long inicio = System.nanoTime();

        for(int i = 0; i < elementos.length; i++){
            arvoreABB.inserirABB(elementos[i]);
        }

        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirInsercaoEmAVL(int[] elementos){
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        long inicio = System.nanoTime();

        for(int i = 0; i < elementos.length; i++){
            arvoreAVL.inserirAVL(elementos[i]);
        }

        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirBuscaSequencialEmVetor(Vetor vetor, int valor){
        long inicio = System.nanoTime();
        vetor.buscaSequencial(valor);
        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirBuscaBinariaEmVetor(Vetor vetor, int valor){
        long inicio = System.nanoTime();
        vetor.buscaBinaria(valor);
        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirBuscaEmABB(ArvoreABB arvoreABB, int valor){
        long inicio = System.nanoTime();
        arvoreABB.buscarABB(valor);
        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirBuscaEmAVL(ArvoreAVL arvoreAVL, int valor){
        long inicio = System.nanoTime();
        arvoreAVL.buscarAVL(valor);
        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }

    public static double medirBubbleSort(int[] vetor){
        long inicio = System.nanoTime();
        Vetor v = new Vetor(vetor.length);
        v.ordenarBubbleSort(vetor, vetor.length);
        long fim = System.nanoTime();
        return (fim - inicio)/1000000.0;
    }
}