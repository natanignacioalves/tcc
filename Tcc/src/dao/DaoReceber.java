package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import factory.ConnectioBd;
import model.recebidos;

public class DaoReceber {
	
	private static Connection connection;
	
	public void cadastrarReceber(recebidos receber) {
    
	connection = new ConnectioBd().getConnector();

    String sql = "INSERT INTO receber(Data, Observacao, Valor) VALUES(?,?,?)";
    try {

        PreparedStatement pstment = connection.prepareStatement(sql);
        pstment.setString(1, receber.getData());
        pstment.setString(2, receber.getObservacao());
        pstment.setDouble(3, receber.getValor());
        pstment.execute();
        pstment.close();
    }
    catch (SQLException u) {
        throw new RuntimeException(u);
    }

}
	
	public void deletarReceber(recebidos receber) {
		   String sql = "DELETE FROM receber WHERE  Id = ?";
		    try {

		        PreparedStatement pstment = connection.prepareStatement(sql);
		        pstment.setInt(1, receber.getId());
		        pstment.executeUpdate();
		        pstment.close();
		    }
		    catch (SQLException u) {
		        throw new RuntimeException(u);
		    }

	}
	
	public static List<recebidos> listarReceber() {
		connection = new ConnectioBd().getConnector();

		   String sql = "SELECT * FROM receber";
				   			
		   List<recebidos> receber = new ArrayList<>();
		   
		   ResultSet rset = null;
		   
		   try {
			   PreparedStatement pstment = connection.prepareStatement(sql);
			   // usado para pegar os dados do banco
			   rset = pstment.executeQuery();
			   
			   while(rset.next()) {
			   recebidos aReceber = new recebidos();
			   
			   aReceber.setId(rset.getInt("Id"));
			   aReceber.setData(rset.getString("Data"));
			   aReceber.setValor(rset.getDouble("Valor"));
			   aReceber.setObservacao(rset.getString("Observacao"));
			   
			   receber.add(aReceber);
		   }
			   pstment.close();
		   }
		   catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "erro ao gerar a lista de recebidos: " + e);
		   }
		   return receber;
	}
	
	public void editarReceber(recebidos receber) {
		   String sql = "UPTDATE receber SET Data = ?,Observacao = ?,Valor = ? WHERE Id =?";
		    try {

		        PreparedStatement pstment = connection.prepareStatement(sql);
		        pstment.setString(1, receber.getData());
		        pstment.setString(2, receber.getObservacao());
		        pstment.setDouble(3, receber.getValor());
		        pstment.execute();
		        pstment.close();
		    }
		    catch (SQLException u) {
		        throw new RuntimeException(u);
		    }

	}

}