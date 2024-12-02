package Testes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaCadastroEmpregado extends JFrame 
{
    private JTextField nomeField, salarioField, comissaoField, horasField, tarefasField;
    private JComboBox<String> tipoEmpregadoCombo;
    private JButton btnMostrar;
    public TelaCadastroEmpregado() 
    {
        setTitle("Cadastro de Empregados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Nome:"));
        nomeField = new JTextField(20);
        add(nomeField);
        add(new JLabel("Salário:"));
        salarioField = new JTextField(10);
        add(salarioField);
        String[] tipos = { "Mensalista", "Comissionado", "Horista", "Tarefeiro" };
        add(new JLabel("Tipo de Empregado:"));
        tipoEmpregadoCombo = new JComboBox<>(tipos);
        add(tipoEmpregadoCombo);
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
        add(new JLabel("Tarefas Completas:"));
        add(tarefasField);
        tipoEmpregadoCombo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String tipoSelecionado = (String) tipoEmpregadoCombo.getSelectedItem();
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
                mostrarEmpregado();
            }
        });
        add(btnMostrar);
    }
    private void mostrarEmpregado() 
    {
        String nome = nomeField.getText();
        double salario = Double.parseDouble(salarioField.getText());
        String tipoSelecionado = (String) tipoEmpregadoCombo.getSelectedItem();
        Empregado empregado = null;
        switch (tipoSelecionado) 
        {
            case "Mensalista":
                empregado = new Mensalista(nome, salario);
                break;
            case "Comissionado":
                double comissao = Double.parseDouble(comissaoField.getText());
                empregado = new Comissionado(nome, salario, comissao);
                break;
            case "Horista":
                int horas = Integer.parseInt(horasField.getText());
                empregado = new Horista(nome, salario, horas);
                break;
            case "Tarefeiro":
                int tarefas = Integer.parseInt(tarefasField.getText());
                empregado = new Tarefeiro(nome, salario, tarefas);
                break;
        }
        JOptionPane.showMessageDialog(this, "Nome: " + empregado.getNome() +
                "\nSalário: " + empregado.getSalario() +
                "\nTipo: " + empregado.getTipo());
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new TelaCadastroEmpregado().setVisible(true));
    }
}