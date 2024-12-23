# Projeto de Automação de Testes Api com Relatórios Allure

## Índice
1. [Pré-requisitos](#pré-requisitos)
2. [Instalação e Configuração](#instalação-e-configuração)
3. [Como Executar os Testes](#como-executar-os-testes)
4. [Geração de Relatórios Allure](#geração-de-relatórios-allure)

---

## 1. Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em sua máquina:

- **Java Development Kit (JDK)** 8 ou superior.
- **Apache Maven** para gerenciamento de dependências.
- **Allure Commandline** para geração de relatórios.
- Um IDE, como **IntelliJ IDEA** ou **Eclipse**.

---

## 2. Instalação e Configuração

### Passo 1: Clone o Repositório
Clone este repositório para sua máquina local:

```bash
git clone https://github.com/hebroms/testesAPI.git
```

### Passo 2: Configurar o Ambiente
Certifique-se de que as variáveis de ambiente estão configuradas corretamente:

- JAVA_HOME: Caminho para o JDK.
- ALLURE_HOME: Caminho para o diretório do Allure CLI.

### Passo 3: Instalar Dependências
Execute o comando Maven para instalar as dependências necessárias:

```bash
mvn clean install 
```

---

## 3. Como Executar os Testes

### Passo 1: Executar os Testes
Para rodar os testes automatizados, utilize o seguinte comando:
```bash
mvn clean test
```
Os resultados serão gerados no diretório allure-results.

---

## 4. Geração de Relatórios Allure

### Passo 1: Instalar o Allure CLI
Baixe e instale o Allure CLI:

- [Download do Allure CLI.](https://allurereport.org/docs/install/)
- Adicione o binário do Allure ao PATH.

```bash
allure serve allure-results
```
Isso abrirá automaticamente o relatório no navegador.
