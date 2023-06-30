package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import factory.ConnectioBd;
import model.pagamento;

public class DaoPagar {
	private static Connection connection;
	
	public void cadastrarpagar(pagamento pagar) {
    
	connection = new ConnectioBd().getConnector();

    String sql = "INSERT INTO pagar(Data, Observacao, Valor) VALUES(?,?,?)";
    try {

        PreparedStatement pstment = connection.prepareStatement(sql);
        pstment.setString(1, pagar.getData());
        pstment.setString(2, pagar.getObservacao());
        pstment.setDouble(3, pagar.getValor());
        pstment.execute();
        pstment.close();
    }
    catch (SQLException u) {
        throw new RuntimeException(u);
    }

}
	
	public void deletarpagar(pagamento pagar) {
		   String sql = "DELETE FROM pagar WHERE  Id =?";
		    try {
		        PreparedStatement pstment = connection.prepareStatement(sql);
		        pstment.setInt(1, pagar.getId());
		        pstment.execute();
		        pstment.close();
		    }
		    catch (SQLException u) {
		        throw new RuntimeException(u);
		    }

	}
	
	public static List<pagamento> listapagamento() {
		connection = new ConnectioBd().getConnector();

		   String sql = "SELECT * FROM pagar";
				   			
		   List<pagamento> pagar = new ArrayList<>();
		   
		   ResultSet rset = null;
		   
		   try {
			   PreparedStatement pstment = connection.prepareStatement(sql);
			   // usado para pegar os dados do banco
			   rset = pstment.executeQuery();
			   
			   while(rset.next()) {
			   pagamento apagar = new pagamento();
			   
			   apagar.setId(rset.getInt("Id"));
			   apagar.setData(rset.getString("Data"));
			   apagar.setValor(rset.getDouble("Valor"));
			   apagar.setObservacao(rset.getString("Observacao"));
			   
			   pagar.add(apagar);
		   }
			   pstment.close();
		   }
		   catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "erro ao gerar a lista de pagamento: " + e);
		   }
		   return pagar;
	}
	
	
	public void editarpagar(pagamento pagar) {
		   String sql = "UPTDATE pagar SET Data = ?,Observacao = ?,Valor = ? WHERE Id =?";
		    try {

		        PreparedStatement pstment = connection.prepareStatement(sql);
		        pstment.setString(1, pagar.getData());
		        pstment.setString(2, pagar.getObservacao());
		        pstment.setDouble(3, pagar.getValor());
		        pstment.execute();
		        pstment.close();
		    }
		    catch (SQLException u) {
		        throw new RuntimeException(u);
		    }

	}
}
