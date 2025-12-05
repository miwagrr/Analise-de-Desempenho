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

    public void ordenarBubbleSort(int[] vetor, int tamanho){
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

    public void ordenarQuickSort(){
        
    }
}