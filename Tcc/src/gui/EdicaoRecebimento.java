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

public class EdicaoRecebimento extends ListaReceber{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicaoRecebimento window = new EdicaoRecebimento();
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
	public EdicaoRecebimento() {
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
		
		textField = new JTextField();
		textField.setBounds(10, 79, 345, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 151, 345, 36);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 223, 345, 36);
		frame.getContentPane().add(textField_2);
		
		textField.setText(r.getData());
		textField_2.setText(r.getObservacao());
		textField_1.setText(String.valueOf(r.getValor()));
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				receber.setData(textField.getText());
				receber.setValor(Double.parseDouble(textField_1.getText()));
				receber.setObservacao(textField_2.getText());
				dao.editarReceber(receber);
				JOptionPane.showMessageDialog(null,"Editado com sucesso");
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
		
		JLabel lblNewLabel_3 = new JLabel("Edicao");
		lblNewLabel_3.setBounds(159, 11, 88, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		frame.setVisible(true);
	}
	public void setVisible() {}
}
