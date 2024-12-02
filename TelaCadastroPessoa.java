package Testes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaCadastroPessoa extends JFrame 
{
    private JTextField nomeField, cpfField, salarioField, comissaoField, horasField, tarefasField;
    private JComboBox<String> tipoPessoaCombo;
    private JButton btnMostrar;
    public TelaCadastroPessoa() {
        setTitle("Cadastro de Pessoas");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Nome:"));
        nomeField = new JTextField(20);
        add(nomeField);
        add(new JLabel("CPF:"));
        cpfField = new JTextField(15);
        add(cpfField);
        String[] tipos = { "Desempregado", "Mensalista", "Comissionado", "Horista", "Tarefeiro" };
        add(new JLabel("Tipo de Pessoa:"));
        tipoPessoaCombo = new JComboBox<>(tipos);
        add(tipoPessoaCombo);
        salarioField = new JTextField(10);
        add(new JLabel("Salário:"));
        add(salarioField);
        comissaoField = new JTextField(10);
        comissaoField.setVisible(false);
        add(new JLabel("Comissão:"));
        add(comissaoField);
        horasField = new JTextField(10);
        horasField.setVisible(false);
        add(new JLabel("Horas Trabalhadas:"));
        add(horasField);
        tarefasField = new JTextField(10);
        tarefasField.setVisible(false);
        add(new JLabel("Tarefas:"));
        add(tarefasField);
        tipoPessoaCombo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String tipoSelecionado = (String) tipoPessoaCombo.getSelectedItem();
                boolean isEmpregado = !tipoSelecionado.equals("Desempregado");
                salarioField.setVisible(isEmpregado);
                comissaoField.setVisible("Comissionado".equals(tipoSelecionado));
                horasField.setVisible("Horista".equals(tipoSelecionado));
                tarefasField.setVisible("Tarefeiro".equals(tipoSelecionado));
                revalidate();
                repaint();
        }
        });
        btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                mostrarPessoa();
            }
        });
        add(btnMostrar);
    }
    private void mostrarPessoa() 
    {
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String tipoSelecionado = (String) tipoPessoaCombo.getSelectedItem();
        PessoaFisica pessoa = null;
        switch (tipoSelecionado) {
            case "Desempregado":
                pessoa = new Desempregado(nome, cpf);
                break;
            case "Mensalista":
                double salarioMensalista = Double.parseDouble(salarioField.getText());
                pessoa = new Mensalista(nome, cpf, salarioMensalista);
                break;
            case "Comissionado":
                double salarioComissionado = Double.parseDouble(salarioField.getText());
                double comissao = Double.parseDouble(comissaoField.getText());
                pessoa = new Comissionado(nome, cpf, salarioComissionado, comissao);
                break;
            case "Horista":
                double salarioHorista = Double.parseDouble(salarioField.getText());
                int horas = Integer.parseInt(horasField.getText());
                pessoa = new Horista(nome, cpf, salarioHorista, horas);
                break;
            case "Tarefeiro":
                double salarioTarefeiro = Double.parseDouble(salarioField.getText());
                int tarefas = Integer.parseInt(tarefasField.getText());
                pessoa = new Tarefeiro(nome, cpf, salarioTarefeiro, tarefas);
                break;
        }
        JOptionPane.showMessageDialog(this, "Nome: " + pessoa.getNome() +
                "\nCPF: " + pessoa.getCpf() +
                "\nTipo: " + pessoa.getTipo());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroPessoa().setVisible(true));
    }
}
