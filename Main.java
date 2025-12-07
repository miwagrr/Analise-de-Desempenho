import Estruturas.ArvoreABB;
import Estruturas.ArvoreAVL;
import Estruturas.Vetor;
import java.util.Random;

public class Main {

    private static void borda(String titulo) {
        System.out.println("\n=========== " + titulo + " =============");
    }

    private static void linhaTabela() {
        System.out.println("+-------------------------+-----------------+");
    }

    //calcula a média dos tempos pra pegar a média de tempo das 5 repetições dos testes
    private static double media(double[] tempos) {
        double soma = 0;
        for (double t : tempos) soma += t;
        return soma / tempos.length;
    }

    //método principal de testes das estruturas
    private static void testarTudo(int[] elementos, String nomeCenario, int tamanho) {

        borda(nomeCenario + " (" + tamanho + ")");

        //criação das estruturas
        Vetor vetor = new Vetor(elementos.length);
        ArvoreABB abb = new ArvoreABB();
        ArvoreAVL avl = new ArvoreAVL();

        long inicio, fim;

        //inicio das inserções de dados nas estruturas
        inicio = System.nanoTime();
        for (int i = 0; i < elementos.length; i++)
            vetor.inserirVetor(elementos[i]);
        fim = System.nanoTime();
        double tempoInsercaoVetor = (fim - inicio) / 1000000.0;

        inicio = System.nanoTime();
        for (int i = 0; i < elementos.length; i++)
            abb.inserirABB(elementos[i]);
        fim = System.nanoTime();
        double tempoInsercaoABB = (fim - inicio) / 1000000.0;

        inicio = System.nanoTime();
        for (int i = 0; i < elementos.length; i++)
            avl.inserirAVL(elementos[i]);
        fim = System.nanoTime();
        double tempoInsercaoAVL = (fim - inicio) / 1000000.0;

        //dados dos tempos de inserção em cada uma das estruturas
        System.out.println("\nTempo de Inserção (ms):");
        linhaTabela();
        System.out.printf("| %-26s | %-12.4f |\n", "Vetor", tempoInsercaoVetor);
        System.out.printf("| %-26s | %-12.4f |\n", "Árvore ABB", tempoInsercaoABB);
        System.out.printf("| %-26s | %-12.4f |\n", "Árvore AVL", tempoInsercaoAVL);
        linhaTabela();

        //elementos que vão ser buscados nas estruturas (primeiro, ultimo, do meio, 3 aleatorios e um inexistente)
        int primeiro = elementos[0];
        int meio = elementos[elementos.length / 2];
        int ultimo = elementos[elementos.length - 1];
        int inexistente = Integer.MAX_VALUE;

        Random random = new Random();
        int aleatorio1 = elementos[random.nextInt(elementos.length)];
        int aleatorio2 = elementos[random.nextInt(elementos.length)];
        int aleatorio3 = elementos[random.nextInt(elementos.length)];

        //mede os tempos da busca sequencial no vetor (primeiro, ultimo, do meio, 3 aleatorios e um inexistente)
        System.out.println("\nTempo de Busca Sequencial em Vetor (ms):");
        linhaTabela();
        double[] seqTempos = new double[5];
        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, primeiro);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Primeiro", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, meio);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Meio", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, ultimo);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Último", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, aleatorio1);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Aleatório 1", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, aleatorio2);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Aleatório 2", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, aleatorio3);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Aleatório 3", media(seqTempos));

        for (int i = 0; i < 5; i++) seqTempos[i] = MedidorTempo.medirBuscaSequencialEmVetor(vetor, inexistente);
        System.out.printf("| %-26s | %-12.4f |\n", "Sequencial Inexistente", media(seqTempos));
        linhaTabela();

        //testes de ordenação (bubbleSort e mergeSort)
        double[] bubbleTempos = new double[5];
        double[] mergeTempos = new double[5];

        //executa 5x cada ordenação e calcula o tempo médio
        for (int i = 0; i < 5; i++) {
            int[] copia1 = elementos.clone();
            vetor.ordenarBubbleSort(copia1, copia1.length);
            inicio = System.nanoTime();
            vetor.ordenarBubbleSort(copia1, copia1.length);
            fim = System.nanoTime();
            bubbleTempos[i] = (fim - inicio) / 1000000.0;

            int[] copia2 = elementos.clone();
            inicio = System.nanoTime();
            vetor.ordenarMergeSort(copia2, 0, copia2.length - 1);
            fim = System.nanoTime();
            mergeTempos[i] = (fim - inicio) / 1000000.0;
        }

        System.out.println("\nTempo de Ordenação (ms):");
        linhaTabela();
        System.out.printf("| %-26s | %-12.4f |\n", "Bubble Sort", media(bubbleTempos));
        System.out.printf("| %-26s | %-12.4f |\n", "Merge Sort", media(mergeTempos));
        linhaTabela();


        //ordena o vetor com mergeSort antes de realizar a busca binária

        vetor.ordenarMergeSort(vetor.getElementos(), 0, vetor.getTamanho() - 1);

        //testes de busca binária dos valores (primeiro, ultimo, do meio, 3 aleatorios e um inexistente)
        System.out.println("\nTempo de Busca Binária em Vetor (ms):");
        linhaTabela();
        double[] binTempos = new double[5];
        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, primeiro);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Primeiro", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, meio);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Meio", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, ultimo);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Último", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, aleatorio1);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Aleatório 1", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, aleatorio2);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Aleatório 2", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, aleatorio3);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Aleatório 3", media(binTempos));

        for (int i = 0; i < 5; i++) binTempos[i] = MedidorTempo.medirBuscaBinariaEmVetor(vetor, inexistente);
        System.out.printf("| %-26s | %-12.4f |\n", "Binária Inexistente", media(binTempos));
        linhaTabela();

        //testes de busca em árvores (ABB e AVL)
        double[] abbTempos = new double[5];
        double[] avlTempos = new double[5];

        System.out.println("\nTempo de Busca em ABB (ms):");
        linhaTabela();
        int[] buscaABB = {primeiro, meio, ultimo, aleatorio1, aleatorio2, aleatorio3, inexistente};
        String[] nomesBusca = {"Primeiro", "Meio", "Último", "Aleatório 1", "Aleatório 2", "Aleatório 3", "Inexistente"};
        for (int i = 0; i < buscaABB.length; i++) {
            for (int j = 0; j < 5; j++) abbTempos[j] = MedidorTempo.medirBuscaEmABB(abb, buscaABB[i]);
            System.out.printf("| %-26s | %-12.4f |\n", nomesBusca[i], media(abbTempos));
        }
        linhaTabela();

        System.out.println("\nTempo de Busca em AVL (ms):");
        linhaTabela();
        for (int i = 0; i < buscaABB.length; i++) {
            for (int j = 0; j < 5; j++) avlTempos[j] = MedidorTempo.medirBuscaEmAVL(avl, buscaABB[i]);
            System.out.printf("| %-26s | %-12.4f |\n", nomesBusca[i], media(avlTempos));
        }
        linhaTabela();
    }

    public static void main(String[] args) {
        //método principal, define os tamanhos (100, 1000 e 10000) para cada estrutura e realiza todos os testes com elas
        int[] tamanhos = {100, 1000, 10000};
        for (int tamanho : tamanhos) {
            testarTudo(GerarDados.gerarVetorCrescente(tamanho), "Crescente", tamanho);
            testarTudo(GerarDados.gerarVetorDecrescente(tamanho), "Decrescente", tamanho);
            testarTudo(GerarDados.gerarVetorAleatorio(tamanho), "Aleatório", tamanho);
        }
    }
}
