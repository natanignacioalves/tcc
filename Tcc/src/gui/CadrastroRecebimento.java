package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.DaoReceber;
import model.recebidos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadrastroRecebimento {

	private JFrame frame;
	private JTextField dataField;
	private JTextField valorField;
	private JTextField observacaoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadrastroRecebimento window = new CadrastroRecebimento();
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
	public CadrastroRecebimento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		dataField = new JTextField();
		dataField.setBounds(10, 79, 345, 36);
		frame.getContentPane().add(dataField);
		dataField.setColumns(10);
		
		valorField = new JTextField();
		valorField.setColumns(10);
		valorField.setBounds(10, 151, 345, 36);
		frame.getContentPane().add(valorField);
		
		observacaoField = new JTextField();
		observacaoField.setColumns(10);
		observacaoField.setBounds(10, 223, 345, 36);
		frame.getContentPane().add(observacaoField);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ListaReceber listaReceber = new ListaReceber();
			listaReceber.setVisible();
			frame.dispose();
		}
		});
		btnNewButton_1.setBounds(186, 300, 169, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("Concluir");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoReceber dao = new DaoReceber();
				recebidos receber = new recebidos();
				receber.setData(dataField.getText());
				receber.setValor(Double.parseDouble(valorField.getText()));
				receber.setObservacao(observacaoField.getText());
				dao.cadastrarReceber(receber);
				JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
				dataField.setText("");
				observacaoField.setText("");
				valorField.setText("");
			}
		});
		btnNewButton_1_1.setBounds(7, 300, 169, 50);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Observação");
		lblNewLabel.setBounds(10, 198, 115, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(10, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setBounds(10, 54, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastro");
		lblNewLabel_3.setBounds(159, 11, 88, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		frame.setVisible(true);
	}
	public void setVisible() {}

}
