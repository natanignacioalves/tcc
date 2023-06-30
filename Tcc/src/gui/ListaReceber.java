package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DaoReceber;
import model.recebidos;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaReceber {
	
	public static DaoReceber dao = new DaoReceber();
	public static recebidos r  = new recebidos();


	private JFrame frame;
	private JTable tableReceber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaReceber window = new ListaReceber();
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
	public ListaReceber() {
		initialize();
		consultarRecebidos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 746, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadrastroRecebimento cadastroRecebimento = new CadrastroRecebimento();
				cadastroRecebimento.setVisible();
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(374, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Editar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setData(tableReceber.getValueAt(tableReceber.getSelectedRow(),0).toString());
				r.setValor((Double)tableReceber.getValueAt(tableReceber.getSelectedRow(),1));
				r.setObservacao(tableReceber.getValueAt(tableReceber.getSelectedRow(),2).toString());
				EdicaoRecebimento edicaoReceber = new EdicaoRecebimento();
				edicaoReceber.setVisible();
				frame.dispose();
			}
		});
		btnNewButton_2_1.setBounds(560, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Remover");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				r.setId((int)tableReceber.getValueAt(tableReceber.getSelectedRow(),3));
				frame.dispose();
				DaoReceber deletarReceber = new DaoReceber();
				deletarReceber.deletarReceber(r);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso ");
				ListaReceber listaReceber = new ListaReceber();
				listaReceber.setVisible();
				} 
				catch (Exception sql) {
					JOptionPane.showMessageDialog(null, "erro ao deletar " + sql);
				}
				
			}
		});
		btnNewButton_2_2.setBounds(10, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Voltar");
		btnNewButton_2_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MenuPrincipal menuPrincipal = new MenuPrincipal();
			menuPrincipal.setVisible();
			frame.dispose();
		}
		});
		btnNewButton_2_3.setBounds(193, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2_3);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 710, 256);
		frame.getContentPane().add(scrollPane);
		
		tableReceber = new JTable();
		tableReceber.setBackground(new Color(128, 128, 255));
		tableReceber.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Valor", "Observa\u00E7\u00E3o", "Id"
			}
		));
		tableReceber.getColumnModel().getColumn(1).setPreferredWidth(197);
		tableReceber.getColumnModel().getColumn(2).setPreferredWidth(207);
		tableReceber.getColumnModel().getColumn(3).setPreferredWidth(36);
		scrollPane.setViewportView(tableReceber);
		
		frame.setVisible(true);
	}
	public void setVisible() {}
	public void consultarRecebidos() {
		DefaultTableModel model = (DefaultTableModel) tableReceber.getModel();
		//para não ficar listando infinito
		model.setNumRows(0);
		
		try {
			for (recebidos r: DaoReceber.listarReceber()) {
				model.addRow(new Object[]
						{
							r.getData(),
							r.getValor(),
							r.getObservacao(),
							r.getId()
						});	
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao gerar a lista de recebidos: " + e);
		}

	}
}
