import exceptions.ClienteNaoEncontrado;

import java.util.Scanner;

public class Main {

    private Scanner scanner;

    public static void main(String[] args) {
        Banco guBank = new Banco("GuBank");

        acessarMenu(guBank);

    }

    public static void acessarMenu(Banco banco){
        Scanner scanner = new Scanner(System.in);
        String opcaoEscolhida = "";

        System.out.printf("%n=== Bem-vindo ao GuBank ===%n");

        System.out.printf("Escolha uma opção: %n 1 - Cadastrar novo cliente %n 2 - Abrir uma conta %n 3 - Listar todas as contas %n 4 - Listar todos clientes %n" );
        opcaoEscolhida = scanner.next();

        switch (opcaoEscolhida) {
            case "1":
                cadastrarNovoCliente(banco);
            case "2":
                cadastrarNovaConta(banco);
            case "3":
                System.out.println(banco.getContas());
                acessarMenu(banco);
            case "4":
                System.out.println(banco.getClientes());
                acessarMenu(banco);
        }
    }

    private static void cadastrarNovaConta(Banco banco) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%n Gostaria de abrir um conta corrente ou poupança?%n");
        String tipoDeConta = scanner.next();

        System.out.println("Qual o nome do cliente vinculado a conta?");
        String donoDaNovaConta = scanner.next();

        boolean clienteCadastrado = banco.getClientes().stream().anyMatch(cliente -> cliente.getNome().equalsIgnoreCase(donoDaNovaConta));

        Cliente clienteComNome = banco.getCliente(donoDaNovaConta);

        try{
            if(tipoDeConta.equalsIgnoreCase("corrente")){
                Conta novaConta = new ContaCorrente(clienteComNome);
                banco.adicionarConta(novaConta);
                System.out.printf("Nova conta corrente cadastrada no nome de %s com os seguintes dados: %s", clienteComNome.getNome(), novaConta);
            }
        } catch (ClienteNaoEncontrado clienteNaoEncontrado) {
            System.out.println("Cliente não encontrado");
        }

        acessarMenu(banco);
    }


    public static void cadastrarNovoCliente(Banco b){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do cliente a ser cadastrado: ");
        String nomeDoCliente = scanner.next();
        Cliente novoCliente = new Cliente(nomeDoCliente);
        b.adicionarCliente(novoCliente);
        System.out.println("Cliente " + nomeDoCliente + " cadastrado com sucesso!");
        acessarMenu(b);
    }




}
