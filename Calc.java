package calculadora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calc {

	private JFrame frmAndrezaCassandra;
	private JTextField JTFResultado;

	double valor1 = 0;
	double valor2 = 0;
	String op = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frmAndrezaCassandra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calc() {
		initialize();
	}

	// MÉTODOS OBRIGATÓRIOS DA ATIVIDADE
	public double adicao(double a, double b) {
		return a + b;
	}

	public double subtracao(double a, double b) {
		return a - b;
	}

	public double multiplicacao(double a, double b) {
		return a * b;
	}

	public double divisao(double a, double b) {
		return a / b;
	}

	public double potencia(double base, double expoente) {
		return Math.pow(base, expoente);
	}

	private void adicionarDigito(String digito) {
		JTFResultado.setText(JTFResultado.getText() + digito);
	}

	private void selecionarOperacao(String operacao) {
		if (!JTFResultado.getText().isEmpty()) {
			valor1 = Double.parseDouble(JTFResultado.getText().replace(",", "."));
			JTFResultado.setText("");
			op = operacao;
		}
	}

	private void initialize() {
		frmAndrezaCassandra = new JFrame();
		frmAndrezaCassandra.getContentPane().setBackground(new Color(118, 102, 206));
		frmAndrezaCassandra.setTitle("ANDREZA CASSANDRA - 0025674");
		frmAndrezaCassandra.setBounds(100, 100, 385, 495);
		frmAndrezaCassandra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAndrezaCassandra.getContentPane().setLayout(null);

		JTFResultado = new JTextField();
		JTFResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		JTFResultado.setFont(new Font("Arial", Font.BOLD, 28));
		JTFResultado.setBounds(23, 25, 325, 85);
		frmAndrezaCassandra.getContentPane().add(JTFResultado);
		JTFResultado.setColumns(10);

		// Linha superior: C e Potência (x^y)
		JButton btnLimpar = new JButton("C");
		btnLimpar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTFResultado.setText("");
				valor1 = 0;
				valor2 = 0;
				op = "";
			}
		});
		btnLimpar.setBounds(23, 130, 135, 52);
		frmAndrezaCassandra.getContentPane().add(btnLimpar);

		JButton btnPotencia = new JButton("^");
		btnPotencia.setFont(new Font("Arial", Font.BOLD, 18));
		btnPotencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarOperacao("Potencia");
			}
		});
		btnPotencia.setBounds(168, 130, 110, 52);
		frmAndrezaCassandra.getContentPane().add(btnPotencia);

		JButton btnDivisao = new JButton("/");
		btnDivisao.setFont(new Font("Arial", Font.BOLD, 16));
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarOperacao("Divisao");
			}
		});
		btnDivisao.setBounds(288, 130, 60, 52);
		frmAndrezaCassandra.getContentPane().add(btnDivisao);

		// Números 7, 8, 9 e *
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.BOLD, 16));
		btn7.addActionListener(e -> adicionarDigito("7"));
		btn7.setBounds(23, 192, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.BOLD, 16));
		btn8.addActionListener(e -> adicionarDigito("8"));
		btn8.setBounds(108, 192, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.BOLD, 16));
		btn9.addActionListener(e -> adicionarDigito("9"));
		btn9.setBounds(193, 192, 85, 52);
		frmAndrezaCassandra.getContentPane().add(btn9);

		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.setFont(new Font("Arial", Font.BOLD, 16));
		btnMultiplicacao.addActionListener(e -> selecionarOperacao("Multiplicacao"));
		btnMultiplicacao.setBounds(288, 192, 60, 52);
		frmAndrezaCassandra.getContentPane().add(btnMultiplicacao);

		// Números 4, 5, 6 e -
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.BOLD, 16));
		btn4.addActionListener(e -> adicionarDigito("4"));
		btn4.setBounds(23, 254, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.BOLD, 16));
		btn5.addActionListener(e -> adicionarDigito("5"));
		btn5.setBounds(108, 254, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.BOLD, 16));
		btn6.addActionListener(e -> adicionarDigito("6"));
		btn6.setBounds(193, 254, 85, 52);
		frmAndrezaCassandra.getContentPane().add(btn6);

		JButton btnSubtracao = new JButton("-");
		btnSubtracao.setFont(new Font("Arial", Font.BOLD, 16));
		btnSubtracao.addActionListener(e -> selecionarOperacao("Subtracao"));
		btnSubtracao.setBounds(288, 254, 60, 52);
		frmAndrezaCassandra.getContentPane().add(btnSubtracao);

		// Números 1, 2, 3 e +
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.BOLD, 16));
		btn1.addActionListener(e -> adicionarDigito("1"));
		btn1.setBounds(23, 316, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.BOLD, 16));
		btn2.addActionListener(e -> adicionarDigito("2"));
		btn2.setBounds(108, 316, 75, 52);
		frmAndrezaCassandra.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.BOLD, 16));
		btn3.addActionListener(e -> adicionarDigito("3"));
		btn3.setBounds(193, 316, 85, 52);
		frmAndrezaCassandra.getContentPane().add(btn3);

		JButton btnSoma = new JButton("+");
		btnSoma.setFont(new Font("Arial", Font.BOLD, 16));
		btnSoma.addActionListener(e -> selecionarOperacao("Soma"));
		btnSoma.setBounds(288, 316, 60, 52);
		frmAndrezaCassandra.getContentPane().add(btnSoma);

		// Linha inferior: 0, . e =
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 16));
		btn0.addActionListener(e -> adicionarDigito("0"));
		btn0.setBounds(23, 378, 160, 52);
		frmAndrezaCassandra.getContentPane().add(btn0);

		JButton btnPonto = new JButton(".");
		btnPonto.setFont(new Font("Arial", Font.BOLD, 16));
		btnPonto.addActionListener(e -> {
			if (!JTFResultado.getText().contains(".")) {
				adicionarDigito(".");
			}
		});
		btnPonto.setBounds(193, 378, 85, 52);
		frmAndrezaCassandra.getContentPane().add(btnPonto);

		JButton btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Arial", Font.BOLD, 16));
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!JTFResultado.getText().isEmpty() && !op.isEmpty()) {
					valor2 = Double.parseDouble(JTFResultado.getText().replace(",", "."));
					double resultado = 0;

					switch (op) {
					case "Soma":
						resultado = adicao(valor1, valor2);
						break;
					case "Subtracao":
						resultado = subtracao(valor1, valor2);
						break;
					case "Multiplicacao":
						resultado = multiplicacao(valor1, valor2);
						break;
					case "Divisao":
						if (valor2 == 0) {
							JOptionPane.showMessageDialog(null, "Não é possível dividir por zero!", "Erro",
									JOptionPane.ERROR_MESSAGE);
							JTFResultado.setText("");
							return;
						}
						resultado = divisao(valor1, valor2);
						break;
					case "Potencia":
						resultado = potencia(valor1, valor2);
						break;
					}

					JTFResultado.setText(String.valueOf(resultado));
					op = "";
				}
			}
		});
		btnIgual.setBounds(288, 378, 60, 52);
		frmAndrezaCassandra.getContentPane().add(btnIgual);
	}
}
