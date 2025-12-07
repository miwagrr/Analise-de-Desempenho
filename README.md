![Capa do Projeto](Imagem/imagem.png)
# Análise de Desempenho de Estruturas de Dados em Java

## 📋 Descrição do Projeto

Este projeto implementa e compara o desempenho de diferentes estruturas de dados (Vetores, Árvores Binárias de Busca e Árvores AVL) através de testes de inserção, busca e ordenação. A análise é realizada com conjuntos de dados de diferentes tamanhos (100, 1.000 e 10.000 elementos) e três ordens de inserção distintas (crescente, decrescente e aleatória).

## 🎯 Objetivos

- Implementar estruturas de dados do zero sem uso de bibliotecas prontas
- Medir e comparar o desempenho de operações de inserção e busca
- Analisar diferentes algoritmos de ordenação
- Relacionar resultados práticos com complexidade teórica (Big O)

## 📁 Estrutura do Projeto

```
projeto/
│
├── Estruturas/
│   ├── ArvoreABB.java      # Implementação da Árvore Binária de Busca
│   ├── ArvoreAVL.java      # Implementação da Árvore AVL (auto-balanceada)
│   ├── No.java             # Classe nó para as árvores
│   └── Vetor.java          # Implementação do Vetor com métodos de busca e ordenação
├── Imagem/
│   └── imagem.png          # Capa do trabalho no github
├── GerarDados.java         # Classe para geração de conjuntos de dados
├── MedidorTempo.java       # Classe para medição de tempo das operações
└── Main.java               # Classe principal com execução dos testes
```

## 💻 Como Compilar e Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado
- Terminal/Prompt de comando

### Compilação

#### Windows (CMD/PowerShell):
```bash
# Navegar até o diretório do projeto
cd caminho/do/projeto

# Compilar todos os arquivos
javac Estruturas/*.java *.java
```

#### Linux/Mac:
```bash
# Navegar até o diretório do projeto
cd caminho/do/projeto

# Compilar todos os arquivos
javac Estruturas/*.java *.java
```

### Execução

```bash
# Executar o programa principal
java Main
```

## 📊 Testes Realizados

O programa executa automaticamente os seguintes testes:

### Para cada tamanho (100, 1.000, 10.000 elementos):
1. **Três ordens de inserção**:
   - Crescente (1, 2, 3, ...)
   - Decrescente (n, n-1, n-2, ...)
   - Aleatória

2. **Medições de tempo**:
   - Inserção em cada estrutura
   - Busca do primeiro elemento
   - Busca do elemento do meio
   - Busca do último elemento
   - Busca de 3 elementos aleatórios
   - Busca de elemento inexistente
   - Ordenação com Bubble Sort
   - Ordenação com Merge Sort

3. **Repetições**: Cada teste é executado 5 vezes e a média é calculada para maior precisão

## 📈 Formato de Saída

Os resultados são exibidos no console em formato de tabelas organizadas:

```
=========== Crescente (100) =============

Tempo de Inserção (ms):
+-------------------------+-----------------+
| Vetor                   | 0.xxxx          |
| Árvore ABB              | 0.xxxx          |
| Árvore AVL              | 0.xxxx          |
+-------------------------+-----------------+

[...]
```

## 🔍 Detalhes de Implementação

### Geração de Dados
- **Crescente**: Sequência 1 até n
- **Decrescente**: Sequência n até 1
- **Aleatória**: Números aleatórios de 0 a 4999

### Medição de Tempo
- Utiliza `System.nanoTime()` para precisão
- Converte para milissegundos (ms)
- Calcula média de 5 execuções

### Busca Binária
- Executada apenas após ordenação do vetor com Merge Sort
- Implementação iterativa

### Árvore AVL
- Implementa rotações simples (esquerda e direita)
- Implementa rotações duplas (esquerda-direita e direita-esquerda)
- Atualização automática de altura e fator de balanceamento

## 👨‍💻 Autor

[Maria Eduarda Braga] [4° Período - Análise e Desenvolvimento de Sistemas]
