import jdk.dynalink.beans.StaticClass;

public class Passageiro {
    private String CPF;
    private String Nome;
    private String Endereco;
    private String Horario;
    private int Telefone;
    private int NumPassagem;
    private int NumPoltrona;
    private int NumVoo;

    // Constructor
    public Passageiro(String CPF, String nome, String endereco, String horario, int telefone, int numPassagem,
                      int numPoltrona, int numVoo) {
        this.CPF = CPF;
        this.Nome = nome;
        this.Endereco = endereco;
        this.Horario = horario;
        this.Telefone = telefone;
        this.NumPassagem = numPassagem;
        this.NumPoltrona = numPoltrona;
        this.NumVoo = numVoo;
    }

    public String getNome() {return Nome;}
    public String getCPF() {return CPF;}


    // toString
    @Override
    public String toString() {
        return " CPF=" + CPF + ", Nome=" + Nome + ", Endereco=" + Endereco + ", Horario=" + Horario
                + ", Telefone=" + Telefone + ", NumPassagem=" + NumPassagem + ", NumPoltrona=" + NumPoltrona
                + ", NumVoo=" + NumVoo +"\n";
    }


}