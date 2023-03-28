package Interfata;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Polynomial.Polynomial;

public class Interfata extends JFrame {

	public static HashMap<Integer, Double> parsePolynomial(String str) {
		HashMap<Integer, Double> rezultat = new HashMap<Integer, Double>();
		Scanner scanner = new Scanner(str);
		scanner.useDelimiter("\\s*[+]\\s*");

		while (scanner.hasNext()) {
			// imparte string ul in substring-uri
			String substr = scanner.next();
			double coeficient;
			int grad;
			if (substr.contains("x")) {
				int xIndex = substr.indexOf("x");
				if (xIndex == 0) {
					coeficient = 1.0;
				} else if (substr.substring(0, xIndex).equals("-")) {
					coeficient = -1.0;
				} else {
					coeficient = Double.parseDouble(substr.substring(0, xIndex));
				}
				if (substr.contains("^")) {
					grad = Integer.parseInt(substr.substring(xIndex + 2));
				} else {
					grad = 1;
				}
			} else {
				coeficient = Double.parseDouble(substr);
				grad = 0;
			}
			if (rezultat.containsKey(grad)) {
				rezultat.put(grad, rezultat.get(grad) + coeficient);
			} else {
				rezultat.put(grad, coeficient);
			}
		}
		scanner.close();
		return rezultat;
	}

	public void createInterface() {
		JFrame frame = new JFrame("Calculator Polinomial");
		frame.setSize(1920, 1080);

		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setBackground(Color.BLUE);

		JLabel title = new JLabel("Poly Calculator");
		title.setBounds(600, 45, 700, 150);
		title.setFont(new Font("Georgia", Font.BOLD + Font.ITALIC, 50));

		JLabel pol1 = new JLabel("First Polynomial");
		pol1.setBounds(200, 145, 300, 150);
		pol1.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 20));

		JLabel pol2 = new JLabel("Second Polynomial");
		pol2.setBounds(200, 245, 300, 150);
		pol2.setFont(new Font("Times New Roman", Font.PLAIN + Font.BOLD, 20));

		JLabel pol3 = new JLabel("Resulted Polynomial");
		pol3.setBounds(200, 345, 300, 150);
		pol3.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 25));

		JButton adda = new JButton("ADAUGA");
		adda.setBounds(1000, 175, 150, 150);
		JButton sub = new JButton("SCADE");
		sub.setBounds(1200, 175, 150, 150);
		JButton mul = new JButton("INMULTESTE");
		mul.setBounds(1000, 350, 150, 150);
		JButton div = new JButton("IMPARTE");
		div.setBounds(1200, 350, 150, 150);
		JButton integ = new JButton("INTEGREAZA");
		integ.setBounds(1000, 525, 150, 150);
		JButton deriv = new JButton("DERIVEAZA");
		deriv.setBounds(1200, 525, 150, 150);

		final JTextField pol1space = new JTextField();
		pol1space.setBounds(500, 200, 300, 40);

		final JTextField pol2space = new JTextField();
		pol2space.setBounds(500, 300, 300, 40);

		final JTextField pol3space = new JTextField();
		pol3space.setBounds(500, 400, 300, 40);

		adda.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
				HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
				try {
				polinom1 = parsePolynomial(pol1space.getText());
				polinom2 = parsePolynomial(pol2space.getText());
				Polynomial polynomial1 = new Polynomial(polinom1);
				Polynomial polynomial2 = new Polynomial(polinom2);

				Polynomial polynomial3 = new Polynomial(polynomial1.addPolynomials(polynomial2));
				pol3space.setText(polynomial3.toString());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Unul sau mai multe polinoame introduse incorect!");
				}
			}

		});

		sub.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
				HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
				try {
				polinom1 = parsePolynomial(pol1space.getText());
				polinom2 = parsePolynomial(pol2space.getText());
				Polynomial polynomial1 = new Polynomial(polinom1);
				Polynomial polynomial2 = new Polynomial(polinom2);

				Polynomial polynomial3 = new Polynomial(polynomial1.subPolynomials(polynomial2));
				pol3space.setText(polynomial3.toString());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Unul sau mai multe polinoame introduse incorect!");
				}
			}

		});

		mul.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
				HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
				try {
				polinom1 = parsePolynomial(pol1space.getText());
				polinom2 = parsePolynomial(pol2space.getText());
				Polynomial polynomial1 = new Polynomial(polinom1);
				Polynomial polynomial2 = new Polynomial(polinom2);

				Polynomial polynomial3 = new Polynomial(polynomial1.multiplyPolynomials(polynomial2));
				pol3space.setText(polynomial3.toString());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Unul sau mai multe polinoame introduse incorect!");
				}
			}

		});

		div.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
				HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
				try {
				polinom1 = parsePolynomial(pol1space.getText());
				polinom2 = parsePolynomial(pol2space.getText());
				Polynomial polynomial1 = new Polynomial(polinom1);
				Polynomial polynomial2 = new Polynomial(polinom2);
				
				

				Polynomial polynomial3 = new Polynomial(polynomial1.dividePolynomials(polynomial2));
				pol3space.setText(polynomial3.toString());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Unul sau mai multe polinoame introduse incorect!");
				}
			}

		});

		deriv.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();

				polinom1 = parsePolynomial(pol1space.getText());

				try {
					String polinom2 = pol2space.getText();

					if (polinom2.isEmpty() == false) {
						throw new Exception("Integrarea se face folosind doar un polinom");
					}

					Polynomial polynomial1 = new Polynomial(polinom1);

					Polynomial polynomial3 = new Polynomial(polynomial1.derivativePolynomials());
					pol3space.setText(polynomial3.toString());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

		});

		integ.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();

				try {
					polinom1 = parsePolynomial(pol1space.getText());
					String polinom2 = pol2space.getText();

					if (polinom2.isEmpty() == false) {
						throw new Exception("Integrarea se face folosind doar un polinom");
					}

					Polynomial polynomial1 = new Polynomial(polinom1);

					Polynomial polynomial3 = new Polynomial(polynomial1.IntegralPolynomials());
					pol3space.setText(polynomial3.toString());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

		});

		frame.add(title);
		frame.add(pol1);
		frame.add(pol2);
		frame.add(pol3);
		frame.add(pol1space);
		frame.add(pol2space);
		frame.add(pol3space);
		frame.add(adda);
		frame.add(sub);
		frame.add(mul);
		frame.add(div);
		frame.add(integ);
		frame.add(deriv);
		frame.setVisible(true);
	}
}

