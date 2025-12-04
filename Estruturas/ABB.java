package Estruturas;

public class ArvoreBinariaDeBusca {
    private No raiz;

    public void inserirABB(int valor) {
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

    public boolean buscarABB(int valor){
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No raiz, int valor){
        if(raiz == null){ //se a raiz não existir, o valor buscado não está na árvore
            return false;
        }
        else if(raiz.valor == valor){
            return true; //se a raíz corresponder ao valor, retorna como verdadeiro
        }
        else if(valor < raiz.valor){
            return buscarRecursivo(raiz.esquerda, valor); //busca recursivamente à esquerda da árvore caso o valor buscado seja menor que a raiz
        } else {
            return buscarRecursivo(raiz.direita, valor); //busca recursivamente à direita da árvore caso o valor buscado seja maior que a raiz
        }
    }
}
