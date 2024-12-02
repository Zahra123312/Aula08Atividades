package Testes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ExemploTela extends JFrame 
{
    private JTextField campoTexto;
    private JButton btnMostrar, btnLimpar, btnSair;
    public ExemploTela() 
  {
        setTitle("Exemplo da Tela");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        JLabel label = new JLabel("Texto:");
        label.setBounds(10, 10, 50, 25);
        add(label);
        campoTexto = new JTextField();
        campoTexto.setBounds(60, 10, 200, 25);
        add(campoTexto);
        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(10, 50, 80, 25);
        btnMostrar.addActionListener(e -> JOptionPane.showMessageDialog(this, campoTexto.getText()));
        add(btnMostrar);
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(100, 50, 80, 25);
        btnLimpar.addActionListener(e -> campoTexto.setText(""));
        add(btnLimpar);
        btnSair = new JButton("Sair");
        btnSair.setBounds(190, 50, 80, 25);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExemploTela().setVisible(true));
    }
}