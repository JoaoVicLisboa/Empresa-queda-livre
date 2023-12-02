// INTEGRANTES : João Victor de Souza, Danilo Ramos, Felipe Gurgel, Daniel Nunes
import java.util.Arrays;
import java.util.Scanner;

public class Voo {

    private Passageiro[] passageiros;
    private Passageiro[] listEspera;
    private final String nomeVoo;
    private int capMaxPassageiros = 10;
    private int capMaxListEspera = 5;
    private int totalPassageiros;
    private int totalEspera;

    public Voo( String nomeVoo) {
        this.passageiros = new Passageiro[capMaxPassageiros];
        this.listEspera = new Passageiro[capMaxListEspera];
        this.nomeVoo = nomeVoo;
        this.totalPassageiros = 0;
        this.totalEspera = 0;
    }

    public boolean cadastrarPas(Passageiro p) {
        if (totalPassageiros < capMaxPassageiros){
            passageiros[totalPassageiros] = p;
            totalPassageiros++;
            System.out.println("Passageiro adicionado no voo com sucesso.");
            return true;
        } else if (totalEspera<capMaxListEspera) {
            listEspera[totalEspera]=p;
            totalEspera++;
            System.out.println("Passageiro adicionado na fila de espera!");
            return true;
        }else {
            return false;
        }
    }


    public boolean ExcluirPassageiro(String nome) {
        int teste=1;
        for (int i = 0; i < totalPassageiros ; i++) {
            if (nome.equalsIgnoreCase(passageiros[i].getNome())){
                if (totalEspera>0){
                    passageiros[i]=listEspera[0];
                    for (int o = 0;o<totalEspera;o++){
                        if (o == 4) {
                            listEspera[o]=null;
                        }else {
                            listEspera[o] = listEspera[o + 1];
                        }
                    }
                    totalEspera--;
                    System.out.println("Passageiro "+nome+" retirado com sucesso e foi adicionado um passageiro da lista de espera!");
                    return true;
                }else {
                    for (int o = i;o<totalPassageiros;o++){
                        if (o == 9) {
                            passageiros[o]=null;
                        }else {
                            passageiros[o] = passageiros[o + 1];
                        }
                    }
                    totalPassageiros--;
                    System.out.println("Passageiro "+nome+" retirado com sucesso");
                }
                return true;
            }else {
                teste=0;
            }
        }
        for (int i = 0; i < totalEspera ; i++) {
            if (nome.equalsIgnoreCase(listEspera[i].getNome())){
                for (int o=i;o<totalEspera;o++){
                    listEspera[o]=listEspera[o+1];
                }
                totalEspera--;
                System.out.println("Passageiro "+nome+" retirado com sucesso da fila de espera!");
                return true;
            }else {
                teste=0;
            }
        }

        if (teste==0){
            System.out.println("Passageiro não consta nesse voo");
            return false;
        }else {
            return true;
        }
    }
    public void ImprimirPassageiros(){
        for (Passageiro pas:passageiros) {
            if (pas!=null){
                System.out.println("Passageiro: "+pas.getNome());
                System.out.print("CPF: "+pas.getCPF() + ", Numero da Passagem: ");
                System.out.print(pas.getNumPassagem()+ ", Numero da Poltrona: ");
                System.out.println(pas.getNumPoltrona());
            }
        }
    }
    public void imprimirListaEspera(){
        for (Passageiro pas:listEspera) {
            if (pas!=null){
                System.out.println("Passageiro: "+pas.getNome());
                System.out.print("CPF: "+pas.getCPF() + ", Numero da Passagem: ");
                System.out.print(pas.getNumPassagem()+ ", Numero da Poltrona: ");
                System.out.println(pas.getNumPoltrona());
            }
        }
    }
    public boolean AdicionarPassageiro(){
        Scanner tec = new Scanner(System.in);
        String cpf;
        String nome;
        String endereco;
        String telefone;
        String numPassagem;
        String numPoltrona;
        int numVoo;
        String horario;
        if (totalEspera==capMaxListEspera){
            System.out.println("Fila Cheia, a reserva não pode ser feita.");
            return false;
        }
        else {
            System.out.println("Informe o CPF do passageiro:");
            cpf = tec.nextLine();
            System.out.println("Informe o nome do passageiro: ");
            nome = tec.nextLine();
            System.out.println("Informe o endereço do passageiro: ");
            endereco = tec.nextLine();
            System.out.println("Informe o telefone do passageiro: ");
            telefone = tec.nextLine();
            System.out.println("Informe o horario do passageiro: ");
            horario = tec.nextLine();
            System.out.println("Informe o numero da passagem do passageiro: ");
            numPassagem = tec.nextLine();
            System.out.println("Informe o numero da poltrona do passageiro: ");
            numPoltrona = tec.nextLine();
            System.out.println("Informe o numero do voo: ");
            numVoo = tec.nextInt();
            Passageiro passageiro = new Passageiro(cpf, nome, endereco, telefone, numPassagem, numPoltrona, numVoo, horario);
            cadastrarPas(passageiro);
            return true;
        }
    }

    public boolean ProcurarPassageiroCpf(String cpf){
        int teste=1;
        for (int i = 0; i < totalPassageiros ; i++) {
            if (cpf.equalsIgnoreCase(passageiros[i].getCPF())){
                System.out.println(passageiros[i]);
                return true;
            }else {
                teste=0;
            }
        }
        for (int i = 0; i < totalEspera ; i++) {
            if (cpf.equalsIgnoreCase(listEspera[i].getCPF())){
                System.out.println(listEspera[i]);
                return true;
            }else {
                teste=0;
            }
        }

        if (teste==0){
            System.out.println("Passageiro não consta nesse voo");
            return false;
        }else {
            return true;
        }
    }



    public boolean ProcurarPassageiroNome(String nome){
        int teste=1;
        for (int i = 0; i < totalPassageiros ; i++) {
            if (nome.equalsIgnoreCase(passageiros[i].getNome())){
                System.out.println(passageiros[i]);
                return true;
            }else {
                teste=0;
            }
        }
        for (int i = 0; i < totalEspera ; i++) {
            if (nome.equalsIgnoreCase(listEspera[i].getNome())){
                System.out.println(listEspera[i]);
                return true;
            }else {
                teste=0;
            }
        }

        if (teste==0){
            System.out.println("Passageiro não consta nesse voo");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Voo{" +
                "passageiros=" + Arrays.toString(passageiros) +
                ", listEspera=" + Arrays.toString(listEspera) +
                ", nome do Voo=" + nomeVoo +
                '}';
    }
}
