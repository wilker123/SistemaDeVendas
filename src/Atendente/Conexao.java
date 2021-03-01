package Atendente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private Connection conexao;
	private String sql;
	private PreparedStatement acao;
	private ResultSet resultado;
	
	public Conexao() throws SQLException{
		String timezone = "useTimezone=true&serverTimezone=UTC&useSSL=false";
		conexao = DriverManager.getConnection("jdbc:mysql://localhost/birdshoes?" + timezone,"root","");
	}
	
	public Connection getConexao() {
		return conexao;
	}

	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public PreparedStatement getAcao() {
		return acao;
	}
	public void setAcao(PreparedStatement acao) {
		this.acao = acao;
	}
	public ResultSet getResultado() {
		return resultado;
	}
	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}

}
