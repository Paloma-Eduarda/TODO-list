# DOTO-list(Java)

## Descrição

O **TODO-list** é uma aplicação Java para criar, listar, filtrar e excluir tarefas. O sistema permite organizar tarefas por categoria, status e prioridade. 

## Funcionalidades

- **Adicionar Tarefa**: Criar uma nova tarefa com nome, descrição, categoria, data final, prioridade e status.
- **Listar Tarefas**: Mostra todas as tarefas cadastradas.
- **Excluir Tarefa**: Remove uma tarefa específica.
- **Filtrar Tarefas por Status**: Exibe tarefas com o status especificado (TODO, DOING, DONE).
- **Filtrar Tarefas por Categoria**: Exibe tarefas de uma categoria específica (TRABALHO, CASA, ESTUDO).
- **Filtrar Tarefas por Prioridade**: Exibe tarefas com a prioridade especificada (1: Highest, 2: Critical, 3: High, 4: Medium, 5: Low).

## Tecnologias

- Java Development Kit (JDK) 8 ou superior.
- IntelliJ IDEA ou qualquer IDE compatível com Java.

## Como Executar

1. Clone o repositório ou baixe o código-fonte.
2. Compile e execute a classe `Main`.
3. Utilize o menu principal no console.

## Instruções de Uso

1. **Adicionar uma Tarefa**:
   - Digite o nome da tarefa.
   - Digite a descrição da tarefa.
   - Adcione uma categoria (`TRABALHO`, `CASA`, `ESTUDO`).
   - Insira a data final no formato `dd/MM/yyyy`.
   - Escolha uma prioridade entre 1 e 5.
   - Defina o status da tarefa (`TODO`, `DOING`, `DONE`).

2. **Listar Tarefas**: Listar todas as tarefas.

3. **Excluir uma Tarefa**:
   - Digite o número da tarefa a ser excluída.

4. **Filtrar Tarefas**:
   - Filtre por status, categoria ou prioridade seguindo as opções do menu.
Desenvolvido por: Paloma Eduarda

## Validações de Entrada

- **Prioridade**: Deve ser um número entre 1 e 5.
- **Categoria** : Entrada deve ser uma das opções TRABALHO, CASA e ESTUDO (usuário pode digitar com letras minusculas também, contando que a palavra esteja escrita de maneira correta).
- **Status**: Entrada deve ser uma das opções TODO, DOINE e DONE (usuário pode digitar com letras minusculas também, contando que a palavra esteja escrita de maneira correta).
- **Data**: Deve estar no formato `dd/MM/yyyy`.
