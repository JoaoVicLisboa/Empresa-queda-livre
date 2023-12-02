// INTEGRANTES : João Victor de Souza, Danilo Ramos, Felipe Gurgel, Daniel Nunes

import java.util.*;

public class Main {
    static Voo[] voos = new Voo[3];
    static Scanner teclado = new Scanner(System.in);
    public static void loadData() {
        //cadastrar Passageiros
        Scanner txtPassageiros = new Scanner(Main.class.getResourceAsStream("Banco de Dados.txt"));
        String cpf;
        String nome;
        String endereco;
        String telefone;
        int numPassagem;
        int numPoltrona;
        int nVoo;
        String horario;

        voos[0] =new Voo("BH-RIO");
        for (int i = 0; i < 15; i++) {
            nome = txtPassageiros.nextLine();
            cpf = txtPassageiros.nextLine();
            endereco = txtPassageiros.nextLine();
            telefone = txtPassageiros.nextLine();
            horario = txtPassageiros.nextLine();
            numPassagem = Integer.parseInt(txtPassageiros.nextLine());
            numPoltrona = Integer.parseInt(txtPassageiros.nextLine());
            nVoo = Integer.parseInt(txtPassageiros.nextLine());
            Passageiro p = new Passageiro(cpf, nome, endereco, telefone, numPassagem, numPoltrona, nVoo, horario);
            voos[0].cadastrarPas(p);
        }
        voos[1] =new Voo("BH-SP");
        for (int i = 0; i < 15; i++) {
            nome = txtPassageiros.nextLine();
            cpf = txtPassageiros.nextLine();
            endereco = txtPassageiros.nextLine();
            telefone = txtPassageiros.nextLine();
            horario = txtPassageiros.nextLine();
            numPassagem = Integer.parseInt(txtPassageiros.nextLine());
            numPoltrona = Integer.parseInt(txtPassageiros.nextLine());
            nVoo = Integer.parseInt(txtPassageiros.nextLine());
            Passageiro p = new Passageiro(cpf, nome, endereco, telefone, numPassagem, numPoltrona, nVoo, horario);
            voos[1].cadastrarPas(p);
        }
        voos[2] =new Voo("BH-BRASILIA");
        for (int i = 0; i < 10; i++) {
            nome = txtPassageiros.nextLine();
            cpf = txtPassageiros.nextLine();
            endereco = txtPassageiros.nextLine();
            telefone = txtPassageiros.nextLine();
            horario = txtPassageiros.nextLine();
            numPassagem = Integer.parseInt(txtPassageiros.nextLine());
            numPoltrona = Integer.parseInt(txtPassageiros.nextLine());
            nVoo = Integer.parseInt(txtPassageiros.nextLine());
            Passageiro p = new Passageiro(cpf, nome, endereco, telefone, numPassagem, numPoltrona, nVoo, horario);
            voos[2].cadastrarPas(p);
        }
    }

    public static int telaBasica(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual será o número de voo?");
        System.out.println("[1]- BH-RIO");
        System.out.println("[2]- BH-SP");
        System.out.println("[3]- BH-BRASILIA");
        int nVoo = in.nextInt();
        while (nVoo<1 || nVoo>3) {
            System.out.println("Opcao de voo nao encontrada");
            System.out.println("Digite novamente:");
            nVoo = in.nextInt();
        }
        return nVoo;

    }
    public static int NumDeVoo() {
        int op;
        System.out.println();
        System.out.println("Informe o voo que deseja saber as opões: ");
        System.out.println("[1]- BH-RIO");
        System.out.println("[2]- BH-SP");
        System.out.println("[3]- BH-BRASILIA");
        op = teclado.nextInt();
        while (op<1 || op>3) {
            System.out.println("Opcao de voo nao encontrada!");
            System.out.println("Digite novamente:");
            op = teclado.nextInt();
        }
        return op;
    }

    public static int menuPrincipal(int numVoo) {
        int op;
        String nomVoo;
        if (numVoo == 1) {
            nomVoo = "BH-RIO";
        } else if (numVoo == 2) {
            nomVoo = "BH-SP";
        } else {
            nomVoo = "BH-BRASILIA";
        }
        Scanner in = new Scanner(System.in);
        System.out.println("EMPRESA AEREA QUEDA LIVRE - VOO " +nomVoo);
        System.out.println("\n        MENU DE OPÇÕES");
        System.out.println("[1] Mostrar Lista de Passageiros ");
        System.out.println("[2] Pesquisar Passageiro por CPF");
        System.out.println("[3] Pesquisar Passageiro por Nome");
        System.out.println("[4] Cadastrar Passageiro");
        System.out.println("[5] Remover Passageiro");
        System.out.println("[6] Mostrar Lista de Espera");
        System.out.println("[7] Excluir Passageiro da Lista");
        System.out.println("[8] Mostrar Fila de Espera");
        System.out.println("[9] Sair");
        System.out.println("Digite sua opção:");
        op = in.nextInt();
        return op;
    }

    public static void menuSecundario(int op, int NumDeVoo) {
        if (NumDeVoo == 1) {
            NumDeVoo = 0;
        } else if (NumDeVoo == 2) {
            NumDeVoo = 1;
        } else if (NumDeVoo == 3) {
            NumDeVoo = 2;
        }        
        switch (op) {
            case 1:
                System.out.println("========== Lista de Passageiros =============================");
                voos[NumDeVoo].ImprimirPassageiros();
                break;
            case 2:
                System.out.println("Digite o CPF do passageiro a ser pesquisado:");
                String cpf = teclado.nextLine();
                voos[NumDeVoo].ProcurarPassageiroCpf(cpf);


                break;
            case 3:
                System.out.println("Digite o nome do passageiro a ser pesquisado:");
                String nome = teclado.nextLine();
                voos[NumDeVoo].ProcurarPassageiroNome(nome);

                break;
            case 4:
                System.out.println("Cadastrando Passageiro");
                voos[NumDeVoo].AdicionarPassageiro();
                break;
            case 5:
                System.out.println("Removendo Passageiro");
                System.out.println("Digite o nome do passageiro para ser removido :");
                String excluir = teclado.nextLine();
                voos[NumDeVoo].ExcluirPassageiro(excluir);
                break;
            case 6:
                System.out.println("========== Lista de Espera ==================================");

                break;
            case 7:
                System.out.println("Excluindo Passageiro da Lista");
                System.out.println("Digite o nome do passageiro a ser removido da lista de espera: ");
                String nomeLista = teclado.nextLine();
                voos[NumDeVoo].ExcluirPassageiro(nomeLista);

                break;
            case 8:
                System.out.println("========== Fila de Espera ===================================");
                voos[NumDeVoo].imprimirListaEspera();

                break;
            default:
                if (op != 9)
                    System.out.println("Opcao Invalida.");
                else
                    System.out.println("Programa encerrado.");
        }
    }

    public static void main(String[] args) {
        loadData();
        int opM ;
        int op = NumDeVoo();
        if (op == 1 || op == 2 || op == 3) {
            do {
                opM = menuPrincipal(op);
                menuSecundario(opM, op);
            } while (opM != 0);
        }
        teclado.close();
    }

}



