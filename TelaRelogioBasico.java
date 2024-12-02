package Testes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaRelogioBasico extends JFrame {
    private JLabel lblMostrador;
    private JButton btnTicTac, btnHora, btnMinuto;
    private Relogio relogio;
    public TelaRelogioBasico() 
    {
        relogio = new Relogio();
        setTitle("Relógio Basico");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        lblMostrador = new JLabel(relogio.mostra());
        lblMostrador.setBounds(80, 10, 100, 25);
        add(lblMostrador);
        btnTicTac = new JButton("TicTac");
        btnTicTac.setBounds(20, 50, 80, 25);
        btnTicTac.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                relogio.ticTac();
                lblMostrador.setText(relogio.mostra());
        }
        });
        add(btnTicTac);
        btnHora = new JButton("Hora");
        btnHora.setBounds(120, 50, 80, 25);
        btnHora.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String horaStr = JOptionPane.showInputDialog("Defina a Hora (0 a 23):");
                int hora = Integer.parseInt(horaStr);
                if (hora >= 0 && hora <= 23) {
                    relogio.setHora(hora);
                    lblMostrador.setText(relogio.mostra());
                } else {
                    JOptionPane.showMessageDialog(null, "Hora inválida!");
                }
        }
        });
        add(btnHora);
        btnMinuto = new JButton("Minuto");
        btnMinuto.setBounds(20, 90, 180, 25);
        btnMinuto.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String minutoStr = JOptionPane.showInputDialog("Defina o Minuto (0 a 59):");
                int minuto = Integer.parseInt(minutoStr);
                if (minuto >= 0 && minuto <= 59) {
                    relogio.setMinuto(minuto);
                    lblMostrador.setText(relogio.mostra());
                } else {
                    JOptionPane.showMessageDialog(null, "Minuto está inválido!");
                }
            }
        });
        add(btnMinuto);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaRelogioBasico().setVisible(true));
    }
}