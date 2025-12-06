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
}