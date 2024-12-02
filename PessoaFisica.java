package Testes;

public class PessoaFisica 
{
    protected String nome;
    protected String cpf;
    public PessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTipo() {
        return "Pessoa Física";
    }
}
public class Desempregado extends PessoaFisica 
{
    public Desempregado(String nome, String cpf) {
        super(nome, cpf);
    }
    @Override
    public String getTipo() {
        return "Desempregado";
    }
}
public class Empregado extends PessoaFisica 
{
    protected double salario;
    public Empregado(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario = salario;
    }
    public double getSalario() {
        return salario;
    }
    @Override
    public String getTipo() {
        return "Empregado";
    }
}
public class Mensalista extends Empregado 
{
    public Mensalista(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public String getTipo() {
        return "Mensalista";
    }
}
public class Comissionado extends Empregado 
{
    private double comissao;
    public Comissionado(String nome, String cpf, double salario, double comissao) {
        super(nome, cpf, salario);
        this.comissao = comissao;
    }
    public double getComissao() {
        return comissao;
    }
    @Override
    public String getTipo() {
        return "Comissionado";
    }
}
public class Horista extends Empregado 
{
    private int horasTrabalhadas;
    public Horista(String nome, String cpf, double salario, int horasTrabalhadas) {
        super(nome, cpf, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    @Override
    public String getTipo() {
        return "Horista";
    }
}
public class Tarefeiro extends Empregado 
{
    private int tarefas;
    public Tarefeiro(String nome, String cpf, double salario, int tarefas) {
        super(nome, cpf, salario);
        this.tarefas = tarefas;
    }
    public int getTarefas() {
        return tarefas;
    }
    @Override
    public String getTipo() {
        return "Tarefeiro";
    }
}
