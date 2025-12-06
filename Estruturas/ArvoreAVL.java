package Estruturas;

public class ArvoreAVL {
    private No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    private int calculoAltura(No no){
        if(no == null){
            return 0;
        }
        return no.altura;
    }

    public No getRaiz() {
        return raiz;        //método público para acessar a raiz para fazer testes no testes.java
    }

    public int testarAltura(No no) {
        return calculoAltura(no); //método público para testar a altura no testes.java
    }

    private void atualizarAltura(No no){
        no.altura = 1 + Math.max(calculoAltura(no.direita), calculoAltura(no.esquerda));
        //a altura total será 1 (da própria raiz) + a altura máxima dos filhos, ou seja, do inicio até o filho mais distante.
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
        atualizarAltura(raiz);
        return raiz; 
    }

    public boolean buscarAVL(int valor){
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

    private int fatorDeBalanceamento(No no){
        if(no == null){
            return 0;
        }
        return calculoAltura(no.direita) - calculoAltura(no.esquerda);
        //calcula altura da subárvore direita - esquerda para checar o fb. Caso seja menor que -1 ou maior que 1, a árvore está desbalanceada.
    }
}

