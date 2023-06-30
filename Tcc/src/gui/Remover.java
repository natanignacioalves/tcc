package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DaoPagar;
import model.pagamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remover {

	private JFrame frame;
	private JTextField ExcluirText;
	private JTextField txtDesejaExcluirEssa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remover window = new Remover();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Remover() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 42, 376, 98);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtDesejaExcluirEssa = new JTextField();
		txtDesejaExcluirEssa.setBackground(new Color(255, 255, 255));
		txtDesejaExcluirEssa.setEditable(false);
		txtDesejaExcluirEssa.setText("Deseja excluir essa anotação?");
		txtDesejaExcluirEssa.setBounds(10, 11, 203, 20);
		panel.add(txtDesejaExcluirEssa);
		txtDesejaExcluirEssa.setColumns(10);
		
		ExcluirText = new JTextField();
		ExcluirText.setHorizontalAlignment(SwingConstants.CENTER);
		ExcluirText.setText("Excluir");
		ExcluirText.setBounds(155, 11, 86, 20);
		frame.getContentPane().add(ExcluirText);
		ExcluirText.setColumns(10);
		
		JButton CancelarButton = new JButton("Cancelar");
		CancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPagar listaPagar = new ListaPagar();
				listaPagar.setVisible();
				frame.dispose();
			}
		});
		CancelarButton.setBounds(40, 152, 137, 34);
		frame.getContentPane().add(CancelarButton);
		
		JButton ContinuarButton = new JButton("Continuar");
		ContinuarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoPagar dao = new DaoPagar();
				pagamento pagar = new pagamento();
				dao.deletarpagar(pagar);
				JOptionPane.showMessageDialog(null,"Deletado com sucesso");
			}
		});
		ContinuarButton.setBounds(219, 152, 137, 34);
		frame.getContentPane().add(ContinuarButton);
		
		frame.setVisible(true);
	}
	public void setVisible() {}
}
