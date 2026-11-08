# 👤 CadastraUsuario

Sistema de gerenciamento de usuários com interface gráfica e banco de dados, desenvolvido em Java para a disciplina de Desenvolvimento para Servidores I (FATEC São Roque).

## 📋 Sobre o projeto

Este projeto se foca no CRUD (Create, Read, Update, Delete) de usuários, conforme os requisitos da P2. O sistema conta com:

- **Login** com autenticação segura.
- **Cadastro** de novos usuários.
- **Tela Inicial** com boas-vindas personalizadas.
- **Alteração** de nome e senha do próprio usuário.
- **Exclusão** da própria conta.

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (Classes, Objetos, Encapsulamento).
- Interface Gráfica com Java Swing (`JFrame`, `JPanel`, `JTextField`).
- Eventos (`ActionListener`) e Caixas de Diálogo (`JOptionPane`).
- Conexão com Banco de Dados MySQL (JDBC).
- Tratamento de Exceções (`try/catch`).
- Atributos e Métodos Estáticos.
- Sobrecarga de Métodos.

## 🗂️ Estrutura do projeto

src/
├── cadastrausuario/
├── Conexao.java → Classe de conexão com o MySQL
├── Usuario.java → Modelo e CRUD do usuário
├── TelaLogin.java → Tela de autenticação
├── TelaCadastro.java → Tela de novo usuário
├── TelaInicio.java → Tela pós-login (Home)
├── TelaAlteracao.java → Tela de edição de dados
├── TestaConexao.java → Teste de conexão
└── TestaTela.java → Inicializa a aplicação

## ⚙️ Como executar

1. Certifique-se de ter o MySQL instalado e rodando.
2. Crie o banco de dados executando o script `banco_de_dados.sql`.
3. Adicione a biblioteca `mysql-connector-j-9.6.0.jar` ao projeto.
4. Execute a classe `TestaTela.java`.

## 👤 Autor

Roberto Aparecido
- GitHub: [https://github.com/RobertoBetoRoberto]
- LinkedIn: [https://www.linkedin.com/in/roberto-aparecido-77aa6a415/]