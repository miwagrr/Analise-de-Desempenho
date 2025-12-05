import Estruturas.ArvoreAVL;
import Estruturas.ArvoreABB;
import Estruturas.No;


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

    }
}
