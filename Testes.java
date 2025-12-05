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

        int[] vetor10 = GerarDados.gerarVetorCrescente(10);
        int[] vetor100 = GerarDados.gerarVetorCrescente(100);
    
        System.out.println("\nVetor de tamanho 10:");
        for (int i = 0; i < vetor10.length; i++) {
            System.out.print(vetor10[i] + " ");
        }

        System.out.println("\nVetor de tamanho 100:");
        for (int i = 0; i < vetor100.length; i++) {
            System.out.print(vetor100[i] + " ");
        }

        int[] vetor15 = GerarDados.gerarVetorDecrescente(15);
        int[] vetor90 = GerarDados.gerarVetorDecrescente(90);
    
        System.out.println("\nVetor de tamanho 15 decrescente:");
        for (int i = 0; i < vetor15.length; i++) {
            System.out.print(vetor15[i] + " ");
        }

        System.out.println("\nVetor de tamanho 90 decrescente:");
        for (int i = 0; i < vetor90.length; i++) {
            System.out.print(vetor90[i] + " ");
        }
    }
}
