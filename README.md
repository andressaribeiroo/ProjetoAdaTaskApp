# AdaTaskApp - Aplicação de Gerenciamento de Tarefas

**AdaTaskApp** é uma aplicação Java simples e interativa para o gerenciamento eficiente de tarefas pessoais, de estudo e de trabalho. Ela foi projetada para ajudar os usuários a manterem-se organizados e a aumentar a produtividade ao permitir a criação, atualização, exclusão e visualização de tarefas de maneira descomplicada.

## Funcionalidades

A **AdaTaskApp** oferece diversas funcionalidades para simplificar o gerenciamento de tarefas:

1. **Criação de Tarefas**: Crie novas tarefas fornecendo informações essenciais, como título, descrição, prazo e detalhes específicos. Isso permite que você registre suas obrigações de maneira clara e estruturada.

2. **Edição de Tarefas**: Atualize facilmente tarefas existentes conforme necessário. Se surgirem mudanças nos detalhes da tarefa, você pode fazer ajustes sem problemas para manter tudo atualizado.

3. **Exclusão de Tarefas**: Remova tarefas que não são mais relevantes ou necessárias. Isso evita a poluição da lista de tarefas e mantém o foco nas atividades prioritárias.

4. **Visualização de Tarefas**: Tenha uma visão geral de todas as suas tarefas em uma lista organizada. Isso facilita o acompanhamento do progresso e o planejamento de futuras ações.

## Como Executar

Basta seguir os seguintes passos:

1. **Clone o Repositório**: Abra o terminal (ou Git Bash) e navegue até o diretório em que deseja clonar o projeto. Em seguida, execute o seguinte comando:

   ```shell
   git clone https://github.com/andressaribeiroo/ProjetoAdaTaskApp.git

2. **Navegue até o Projeto**: Após a conclusão do processo de clonagem, navegue até o diretório do projeto:
   
    ```shell
    cd ProjetoAdaTaskApp/src/main/java

3. **compile o projeto** (você deve ter o Java instalado em seu sistema):
    
    ```shell
    javac Main.java

4. **Atenção**: Para recompilar o código em caso de erro:

   ````shell
   javac -Xlint:unchecked Main.java

5. **Execute a Aplicação**: Agora você pode executar a aplicação AdaTaskApp:

    ```shell
    java Main

## Arquitetura do ProjetoAdaTaskApp

## Visão Geral
Este documento descreve a arquitetura do ProjetoAdaTaskApp, uma aplicação Java para gerenciamento de tarefas.

## Componentes

### Controladores
- `PersonalController`: Gerencia as tarefas pessoais.
- `StudyController`: Gerencia as tarefas de estudo.
- `WorkController`: Gerencia as tarefas de trabalho.

Cada controlador processa as entradas do usuário e interage com a camada de serviço correspondente.

### Domínio
- `BaseTask`: Classe base para tarefas.
- `PersonalTask`: Representa uma tarefa pessoal.
- `StudyTask`: Representa uma tarefa de estudo.
- `WorkTask`: Representa uma tarefa de trabalho.

As classes de domínio definem a estrutura dos dados que serão gerenciados pela aplicação.

### Repositório
- `TaskRepository`: Interface para a persistência de tarefas, interage diretamente com o banco de dados.

### Serviços
- `TaskService`: Camada de serviço que contém a lógica de negócio, interagindo com o repositório de tarefas.

### Visões
- `PersonalView`: Interface de usuário para tarefas pessoais.
- `StudyView`: Interface de usuário para tarefas de estudo.
- `WorkView`: Interface de usuário para tarefas de trabalho.

As visões são responsáveis por apresentar os dados ao usuário e capturar suas interações.

### Main
- `Main`: Ponto de entrada da aplicação que configura e inicia a aplicação.

## Fluxo da Aplicação
1. `Main` inicializa o sistema e direciona para o controlador apropriado com base na entrada do usuário.
2. O controlador interage com a camada de `TaskService`.
3. `TaskService` utiliza `TaskRepository` para persistir ou recuperar dados.
4. Os dados são devolvidos ao controlador, que então atualiza a `view` correspondente.

## Conclusão
Esta arquitetura permite uma separação clara e um gerenciamento eficiente das responsabilidades dentro da aplicação, facilitando a manutenção e a expansão futuras.

