package Estruturas;

public class ArvoreAVL {
    private No raiz;

    private int calculoAltura(No no){
        if(no == null){
            return 0;
        }
        return no.altura;
    }

    public void inserirAVL(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No raiz, int valor){ 
        if(raiz == null){
            return new No(valor); //caso a raiz seja nula, o valor fornecido se torna a nova raiz
        }
        if(valor < raiz.valor){
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor); //caso seja menor que a raiz, o valor vai para sua esquerda
        } else if(valor > raiz.valor){
            raiz.direita = inserirRecursivo(raiz.direita, valor); //caso seja maior que a raiz, vai para sua direita
        }
        return raiz; 
    }

    private int fatorDeBalanceamento(No no){
        if(no == null){
            return 0;
        }
        return calculoAltura(no.direita) - calculoAltura(no.esquerda);
        //calcula altura da subárvore direita - esquerda para checar o fb. Caso seja menor que -1 ou maior que 1, a árvore está desbalanceada.
    }


}

