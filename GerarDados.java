import java.util.Random;

public class GerarDados{
    public static int[] gerarVetorCrescente(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            vetor[i] = i + 1;
        }
        return vetor;
    }

    public static int[] gerarVetorDecrescente(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            vetor[i] = tamanho - i;
        }
        return vetor;
    }

    public static int[] gerarVetorAleatorio(int tamanho){
        Random random = new Random();
        int[] vetor = new int[tamanho];
        
        for(int i = 0; i < tamanho; i++){
            vetor[i] = random.nextInt(5000); //gera numeros aleatorios até de 0 ate 4999 para o vetor
        }
        return vetor;
    }
}