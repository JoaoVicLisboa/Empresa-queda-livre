// INTEGRANTES : João Victor de Souza, Danilo Ramos, Felipe Gurgel, Daniel Nunes
public class Passageiro {
    private final String CPF;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private int numPassagem;
    private int numPoltrona;
    private int numVoo;
    private String horario;

    public Passageiro(String CPF, String nome, String endereco, String telefone, int numPassagem, int numPoltrona, int numVoo, String horario) {
        this.CPF = CPF;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numPassagem = numPassagem;
        this.numPoltrona = numPoltrona;
        this.numVoo = numVoo;
        this.horario = horario;
    }

    public int getNumPassagem() {return numPassagem;}

    public int getNumPoltrona() {return numPoltrona;}

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "cpf='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", numPassagem=" + numPassagem +
                ", numPoltrona=" + numPoltrona +
                ", numVoo=" + numVoo +
                ", horario=" + horario +
                '}';
    }
}
