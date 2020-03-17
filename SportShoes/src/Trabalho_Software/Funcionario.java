package Trabalho_Software;

import javax.swing.Spring;
import javax.xml.crypto.Data;

public class Funcionario {
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String cargo;
	private Data dataNascimento;
	private String estadoCivil;
	private float salario;
	private Data dataEntrada;
	private String rg;
	private String usuario;
	private String senha;
	private String senhaBanco;
	private String usuarioBanco;
	private String setor;
	private String setorBanco;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Data getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Data getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaBanco() {
		return senhaBanco;
	}
	public void setSenhaBanco(String senhaBanco) {
		this.senhaBanco = senhaBanco;
	}
	public String getUsuarioBanco() {
		return usuarioBanco;
	}
	public void setUsuarioBanco(String usuarioBanco) {
		this.usuarioBanco = usuarioBanco;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getSetorBanco() {
		return setorBanco;
	}
	public void setSetorBanco(String setorBanco) {
		this.setorBanco = setorBanco;
	}
	
}
