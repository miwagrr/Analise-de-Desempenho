package Estruturas;

public class Vetor {
    private int[] elementos;
    private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }

    public void inserirVetor(int valor) {
        if(this.tamanho < this.elementos.length){
            elementos[tamanho] = valor;
            tamanho++;
        }
    }

    public boolean buscaSequencial(int valorBuscado){
        for(int i = 0; i < this.tamanho; i++){
            if(this.elementos[i] == valorBuscado){
                return true;
            }
        }
        return false;
    }

    public boolean buscaBinaria(int valorBuscado){
        int inicio = 0;
        int fim = this.tamanho - 1;

        while(inicio <= fim){
            int meio = (inicio + fim)/2;

            if (this.elementos[meio] == valorBuscado) {
                return true;
            } else if(this.elementos[meio] < valorBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio -1;
            }
        }
        return false;
    }

        public int[] getElementos() {
        return this.elementos;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }

    public void ordenarBubbleSort(int[] vetor, int tamanho){ //implementação do método de ordenação bubblesort
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho - 1; j++){
                if(vetor[j] > vetor[j + 1]){
                    int temporario = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temporario;
                }
            }
        }
    }

    public void ordenarMergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
    
            ordenarMergeSort(vetor, inicio, fim);
            ordenarMergeSort(vetor, meio + 1, fim);
    
            merge(vetor, inicio, meio, fim);
        }
    }
    
    private void merge(int[] vetor, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;
    
        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];
    
        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = vetor[inicio + i];
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = vetor[meio + 1 + j];
        }
    
        int i = 0, j = 0, k = inicio;
    
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda[i] <= direita[j]) {
                vetor[k] = esquerda[i];
                i++;
            } else {
                vetor[k] = direita[j];
                j++;
            }
            k++;
        }
    
        while (i < tamanhoEsquerda) {
            vetor[k] = esquerda[i];
            i++;
            k++;
        }
    
        while (j < tamanhoDireita) {
            vetor[k] = direita[j];
            j++;
            k++;
        }
    }
}