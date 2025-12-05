import java.util.Random;

public class GerarDados{
    public static int[] gerarVetorCrescente(int tamanho){
        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            vetor[i] = i;
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

}