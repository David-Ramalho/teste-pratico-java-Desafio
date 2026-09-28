# Teste Prático Java

Implementação do teste prático de Java proposto durante processo seletivo.

## Tecnologias utilizadas

* Java 27
* `LocalDate` para manipulação de datas
* `BigDecimal` para valores monetários
* Collections (`List` e `Map`)
* Stream API
* `Comparator` para ordenação
* `Period` para cálculo de idade

## Estrutura do projeto

```text
teste-pratico-java-iniflex/
├── Pessoa.java
├── Funcionario.java
├── Principal.java
├── README.md
└── .gitignore
```

## Classes

### Pessoa

Classe responsável pelos dados básicos de uma pessoa:

* Nome
* Data de nascimento

### Funcionario

Classe que estende `Pessoa` e adiciona:

* Salário
* Função

### Principal

Responsável pela execução do programa e implementação das operações solicitadas no teste.

## Funcionalidades implementadas

O projeto contempla os requisitos do teste:

* Cadastro dos funcionários conforme os dados fornecidos
* Remoção do funcionário João
* Exibição dos funcionários com formatação de data e salário
* Aplicação de aumento salarial de 10%
* Agrupamento de funcionários por função
* Exibição dos funcionários agrupados por função
* Identificação dos aniversariantes dos meses de outubro e dezembro
* Identificação do funcionário mais velho e cálculo da idade
* Ordenação dos funcionários em ordem alfabética
* Cálculo do total dos salários
* Cálculo da quantidade de salários mínimos recebida por cada funcionário

## Como executar

### Pré-requisito

É necessário ter o JDK 27 instalado.

Para verificar a instalação:

```bash
java -version
javac -version
```

### Compilação

Abra um terminal na pasta do projeto e execute:

```bash
javac *.java
```

### Execução

Após a compilação:

```bash
java Principal
```

## Observações

Os valores salariais são tratados utilizando `BigDecimal`, visando maior precisão em operações monetárias.

As datas são manipuladas utilizando a API `java.time`.
