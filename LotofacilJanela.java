import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class LotofacilJanela extends JFrame {

    //Atributos
    public JPanel Panel1 = new JPanel();
    public JLabel JpLotofácil1;
    private JButton JbApostarDe0a100 = new JButton("Apostar de 0 a 100");
    private JButton JbApostarDeAaZ = new JButton("Apostar de A à Z");
    private JButton JbApostarParOuImpar = new JButton("Apostar em par ou ímpar");
    private JButton JbSair = new JButton("Sair");


    public LotofacilJanela() {
        // Construtor
        this.setTitle("LOTOFÁCIL");
        setTitle("Lotofácil"); // Título da janela
        // Cria um JLabel para o título centralizado
        JLabel titleLabel = new JLabel("Lotofácil", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Consolos", Font.TYPE1_FONT, 20)); // Define a fonte e tamanho do título
        // Adiciona o JLabel ao norte do JFrame para centralizar
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        this.setSize(400, 250);
        Panel1.setLayout(new FlowLayout(FlowLayout.CENTER,100, 10));
        Panel1.setBackground(new Color(255,255,255));
        setResizable(false);

        Dimension buttonSize = new Dimension(300, 30); //Configuração do tamanho dos botões
        JbApostarDe0a100.setPreferredSize(buttonSize);
        JbApostarDeAaZ.setPreferredSize(buttonSize);
        JbApostarParOuImpar.setPreferredSize(buttonSize);
        JbSair.setPreferredSize(buttonSize);

        JbApostarDe0a100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDe0a100();
            }
        });
        Panel1.add(JbApostarDe0a100);

        JbApostarDeAaZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDeAaZ();
            }
        });
        Panel1.add(JbApostarDeAaZ);

        JbApostarParOuImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParOuImpar();
            }
        });
        Panel1.add(JbApostarParOuImpar);

        JbSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Panel1.add(JbSair);

        this.getContentPane().add(Panel1);
        this.setLocationRelativeTo(null); // Centralizar Janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir Janela
    }

    private void apostarDe0a100(){
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object numeroApostado = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:", "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        int numeroApostadoInt = Integer.parseInt(numeroApostado.toString());
        if (numeroApostadoInt >= 0 && numeroApostadoInt <= 100) {
            Random random = new Random();
            int numeroSorteado = random.nextInt(101);
            if (numeroApostadoInt == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi :  " + numeroSorteado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }

    private void apostarDeAaZ(){
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object letraApostadaObj = JOptionPane.showInputDialog(null, "Digite uma Letra de A á Z:", "Aposta 2", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        char letraApostada = letraApostadaObj.toString().charAt(0);

        //String letraApostada = JOptionPane.showInputDialog(" Digite uma Letra de A á Z: ");
        if (Character.isLetter(letraApostada)) {
            char letraPremiada = 'J'; //E um exemplo de letra premiada.
            char letraApostadaUpper = Character.toUpperCase(letraApostada);
            if (letraApostadaUpper == letraPremiada) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$500,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }

    private void apostarParOuImpar() {
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object numeroApostado = JOptionPane.showInputDialog(null, "Digite um número inteiro:", "Aposta 3", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        int numeroApostadoInt = Integer.parseInt(numeroApostado.toString());
        if (numeroApostadoInt % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$100,00 reais");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número digitado é impar e a premiação foi números pares.");
        }
    }

    public static void main (String [] args) {
        new LotofacilJanela();
    }
}
