public class Passageiro {
    private String CPF;
    private String Nome;
    private String Endereco;
    private String Telefone;
    private int NumPassagem;
    private int NumPoltrona;
    private int NumVoo;
    private String Horario;

    // Constructor
    public Passageiro(String CPF, String nome, String endereco, String telefone, int numPassagem,
                      int numPoltrona, int numVoo, String horario) {
        this.CPF = CPF;
        this.Nome = nome;
        this.Endereco = endereco;
        this.Telefone = telefone;
        this.NumPassagem = numPassagem;
        this.NumPoltrona = numPoltrona;
        this.NumVoo = numVoo;
        this.Horario = horario;
    }

    public String getNome() {return Nome;}
    public String getCPF() {return CPF;}


    // toString

    @Override
    public String toString() {
        return "Passageiro" +
                "CPF='" + CPF + '\'' +
                ", Nome='" + Nome + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Telefone=" + Telefone +
                ", NumPassagem=" + NumPassagem +
                ", NumPoltrona=" + NumPoltrona +
                ", NumVoo=" + NumVoo +
                ", Horario='" + Horario + "\n";
    }
}