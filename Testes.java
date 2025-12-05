import Estruturas.ArvoreAVL;
import Estruturas.ArvoreABB;
import Estruturas.No;
import Estruturas.Vetor;


public class Testes {
    public static void main(String[] args) {

        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserirAVL(10);
        arvore.inserirAVL(5);
        arvore.inserirAVL(15);
        arvore.inserirAVL(16);
        arvore.inserirAVL(3);
        System.out.println("Altura da árvore: " + arvore.testarAltura(arvore.getRaiz()));
        System.out.println("Existe 15 na árvore? " + arvore.buscarAVL(15));
        System.out.println("Existe 4 na árvore? " + arvore.buscarAVL(4));

        Vetor v = new Vetor(10);

        v.inserirVetor(5);
        v.inserirVetor(2);
        v.inserirVetor(9);
        v.inserirVetor(1);
        v.inserirVetor(7);

        int[] elementos = v.getElementos();

        System.out.println("Antes de ordenar:");
        for (int i = 0; i < v.getTamanho(); i++) {
            System.out.print(elementos[i] + " ");
        }

        v.ordenarBubbleSort(elementos, v.getTamanho());

        System.out.println("\nDepois de ordenar:");
        for (int i = 0; i < v.getTamanho(); i++) {
            System.out.print(elementos[i] + " ");
        }
    }
}
