package Testes;

public class Empregado 
{
    protected String nome;
    protected double salario;
    public Empregado(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }
    public String getTipo() {
        return "Empregado";
    }
}
public class Mensalista extends Empregado 
{
    public Mensalista(String nome, double salario) {
        super(nome, salario);
    }
    @Override
    public String getTipo() {
        return "Mensalista";
    }
}
public class Comissionado extends Empregado 
{
    private double comissao;
    public Comissionado(String nome, double salario, double comissao) {
        super(nome, salario);
        this.comissao = comissao;
    }
    @Override
    public String getTipo() {
        return "Comissionado";
    }
    public double getComissao() {
        return comissao;
    }
}
class Horista extends Empregado 
{
    private int horasTrabalhadas;
    public Horista(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }
    @Override
    public String getTipo() {
        return "Horista";
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
}
public class Tarefeiro extends Empregado 
{
    private int tarefas;
    public Tarefeiro(String nome, double salario, int tarefas) {
        super(nome, salario);
        this.tarefas = tarefas;
    }
    @Override
    public String getTipo() {
        return "Tarefeiro";
    }
    public int getTarefas() {
        return tarefas;
    }
}
