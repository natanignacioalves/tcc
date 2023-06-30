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

import dao.DaoPagar;
import dao.DaoReceber;
import model.pagamento;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPagar {
	
	public static DaoPagar dao = new DaoPagar();
	public static pagamento p  = new pagamento();

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPagar window = new ListaPagar();
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
	public ListaPagar() {
		initialize();
		consultarPagamentos();
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
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible();
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(374, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Editar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setData(table.getValueAt(table.getSelectedRow(),0).toString());
				p.setValor((Double)table.getValueAt(table.getSelectedRow(),1));
				p.setObservacao(table.getValueAt(table.getSelectedRow(),2).toString());
				Edicao edicaoPagar = new Edicao();
				edicaoPagar.setVisible();
				frame.dispose();
			}
		});
		btnNewButton_2_1.setBounds(560, 278, 160, 51);
		frame.getContentPane().add(btnNewButton_2_1);
		
		
		JButton btnNewButton_2_2 = new JButton("Remover");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				p.setId((int)table.getValueAt(table.getSelectedRow(),3));
				frame.dispose();
				DaoPagar deletarpagar = new DaoPagar();
				deletarpagar.deletarpagar(p);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso");
				ListaPagar listaPagar = new ListaPagar();
				listaPagar.setVisible();
				} 
				catch (Exception err) {
					JOptionPane.showMessageDialog(null, "erro ao deletar " + err);
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
		
		table = new JTable();
		table.setBackground(new Color(128, 128, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Valor", "Observa\u00E7\u00E3o", "Id"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(197);
		table.getColumnModel().getColumn(2).setPreferredWidth(207);
		table.getColumnModel().getColumn(3).setPreferredWidth(38);
		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
	public void setVisible() {}
	public void consultarPagamentos() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//para não ficar listando infinitamente
		model.setNumRows(0);
		
		try {
			for (pagamento p: DaoPagar.listapagamento()) {
				model.addRow(new Object[]
						{
							p.getData(),
							p.getValor(),
							p.getObservacao(),
							p.getId()
						});	
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao gerar a lista de recebidos: " + e);
		}

	}
}
