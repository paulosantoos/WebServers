package com.aulaws.model;


import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "marcacao")
@NamedQueries({ @NamedQuery(name = "marcacao.listar", query = "select marcacao from Marcacao marcacao") })

public class Marcacao implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Marcacao(){
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mar_id")
	int codigo;

	@Column(name = "mar_titulo")
	String titulo;

	@Column(name = "mar_latitude")
	double latitude;

	@Column(name = "mar_longitude")
	double longitude;

	@Column(name = "mar_data")
	String dataCadastro;

	@Lob
	@Column(name = "mar_foto")
	byte[] foto;

	@Column(name = "mar_telefone")
	String telefone;

	@Column(name = "mar_pessoa")
	String pessoa;
	
	@Column(name = "mar_achou_perdeu", columnDefinition = "tinyint default false")
	boolean achou_perdeu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mar_cat_id", referencedColumnName = "cat_id", nullable = false)
	private Categoria categoria = new Categoria();
	
	
	public boolean isAchou_perdeu() {
		return achou_perdeu;
	}

	public void setAchou_perdeu(boolean achou_perdeu) {
		this.achou_perdeu = achou_perdeu;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Marcacao [codigo=" + codigo + ", titulo=" + titulo
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", dataCadastro=" + dataCadastro + ", foto="
				+ Arrays.toString(foto) + ", telefone=" + telefone
				+ ", pessoa=" + pessoa + ", achou_perdeu=" + achou_perdeu
				+ ", categoria=" + categoria + "]";
	}

	
	
	}
