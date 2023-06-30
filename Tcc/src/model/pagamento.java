package model;
import java.time.LocalDate;
public class pagamento {
	private int Id;
    private String Data;
    private String Observacao;
    private double Valor;

    
    public int getId() {
        return Id;
    }
    
    public void setId(int newId) {
        Id = newId;
    }
 public String getData() {
     return Data;
 }

 public void setData(String newData) {
 	Data = newData;
 }
 
 public Double getValor() {
     return Valor;
 }

 public void setValor(Double newVaor) {
 	Valor = newVaor;
 }
 public String getObservacao() {
     return Observacao;
 }

 public void setObservacao(String newObservacao) {
 	Observacao = newObservacao;
 }
}