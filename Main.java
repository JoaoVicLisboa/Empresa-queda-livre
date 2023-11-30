

import java.util.*;

public class Main {
    public static void loadData() {
        //cadastrar Passageiros
        Voo voo01 = new Voo("BH","RIO", 1010);
        Voo voo02 = new Voo("BH","SP", 2020);
        Voo voo03 = new Voo("BH","BRASÍLIA", 3030);
        Passageiro Teste1 = new Passageiro("8484198-54","safada da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste2 = new Passageiro("8484198-53","gasosa da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste3 = new Passageiro("8484198-54","delicio da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste4 = new Passageiro("8484198-54","sanhado da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste5 = new Passageiro("8484198-54","gasoso da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste6 = new Passageiro("8484198-54","casos bahia da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste7 = new Passageiro("8484198-54","daniel da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste8 = new Passageiro("8484198-54","filipe da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste9 = new Passageiro("8484198-54","danilo da silva","rua casada da silva","10:35",31,31,31,1010);
        Passageiro Teste10 = new Passageiro("8484198-54","joao da silva","rua casada da silva","10:35",31,31,31,1010);
        voo01.cadrastrarPassageiro(Teste1);
        voo01.cadrastrarPassageiro(Teste2);
        voo01.cadrastrarPassageiro(Teste3);
        voo01.cadrastrarPassageiro(Teste4);
        voo01.cadrastrarPassageiro(Teste5);
        voo01.cadrastrarPassageiro(Teste6);
        voo01.cadrastrarPassageiro(Teste7);
        voo01.cadrastrarPassageiro(Teste8);
        voo01.cadrastrarPassageiro(Teste9);
        voo01.cadrastrarPassageiro(Teste10);


    }

    public static int telaBasica(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual será o número de voo?");
        System.out.println("[voo001]- BH-RIO");
        System.out.println("[2]- BH-SP");
        System.out.println("[3]- BH-BRASILIA");
        int nVoo = in.nextInt();
        while (nVoo<1 || nVoo>3) {
            System.out.println("Opcao de voo nao encontrada!");
            System.out.println("Digite novamente:");
            nVoo = in.nextInt();
        }
        return nVoo;

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

    public static void menuSecundario(int op) {
        Scanner teclado = new Scanner(System.in);
        switch (op) {
            case 1:
                System.out.println("========== Lista de Passageiros =============================");
                Voo.ImprimirPassageiros();
                break;
            case 2:
                System.out.println("Digite o CPF do passageiro a ser pesquisado:");
                String cpf = teclado.nextLine();
                Voo.ProcurarPassageiroCpf(cpf);


                break;
            case 3:
                System.out.println("Digite o nome do passageiro a ser pesquisado:");
                String nome = teclado.nextLine();
                Voo.ProcurarPassageiroNome(nome);

                break;
            case 4:
                System.out.println("Cadastrando Passageiro");

                break;
            case 5:
                System.out.println("Removendo Passageiro");
                System.out.println("Digite o nome do passageiro para ser removido :");
                String excluir = teclado.nextLine();
                Voo.ExcluirPassageiro(excluir);
                break;
            case 6:
                System.out.println("========== Lista de Espera ==================================");

                break;
            case 7:
                System.out.println("Excluindo Passageiro da Lista");
                System.out.println("Digite o nome do passageiro a ser removido da lista de espera: ");
                String nomeLista = teclado.nextLine();
                Voo.ExcluirPassageiroListaEspera(nomeLista);

                break;
            case 8:
                System.out.println("========== Fila de Espera ===================================");
                Voo.ImprimirListaEspera();

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
        int opc = telaBasica();
        int op = 0;
        while (op != 9) {
            op = menuPrincipal(opc);
            menuSecundario(op);
        }
    }

}



