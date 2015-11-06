package com.aulaws.util;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aulaws.model.Marcacao;
import com.aulaws.model.UltimaLocalizacao;
import com.google.gson.Gson;

//o webservers vai atender pelo aulaws
@Path("/aulaws")
// o nome do meu webservs
public class AulaWS {
	// Chamar o metodo pra ver se está funcionando
	// http://localhost:8080/WebServers/rest/aulaws/listarTodosClienteGSON
	// só para consultar http://localhost:8080/WebServers2/rest/application.wadl
	// Sempre deixar o IP do servidor Fixo.
	// no Android http://ip:8080/

	// implementar os serviços para o webServers
	@GET
	// requisição
	@Produces(MediaType.TEXT_PLAIN)
	// tipo de dados que ele trabalha
	public String helloWordTexto() {
		return "Hello Word";
	}

	
	// =-=-=-=-=-=-=-- MÉTODO RESPONSAVEL POR CARREGAR AS MARCAÇÕES DO BANCO =-=-=-=-=-=-=-=-=-
	
	@GET
	@Path("/carregarMarcacaoGSON")
	@Produces("application/json")
	@SuppressWarnings("unchecked")
	public String listarTodosClientesGSON2() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Marcacao> marcacao = new ArrayList<>();

		try {
			Query consulta = sessao.getNamedQuery("marcacao.listar");
			marcacao = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			sessao.close();
		}
		
		//return marcacao;
		return new Gson().toJson(marcacao);		
		
	}
	
	
	// =-=-=-=-=-=-=-- MÉTODO RESPONSAVEL POR INSERIR AS MARCAÇÕES NO BANCO =-=-=-=-=-=-=-=-=-

	@Path("/inserirMarcacaoGSON")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String inserir(String marcacao) { // throws Exception quem chamar
		// esse metodo vai ser obrigado
		// a tratar o erro
		Gson gson = new Gson();

		// Transforma a String no Objeto Cliente
		Marcacao objetoMarcacao = gson.fromJson(marcacao, Marcacao.class);

		System.out.println(objetoMarcacao);
		// pegar uma sessão para conseguir fazer as operações no banco de dados
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null; // quando for start a transação pode dar
		// erro
		try {

			transacao = sessao.beginTransaction();
			sessao.save(objetoMarcacao);
			transacao.commit(); // confirma a transação

		} catch (RuntimeException ex) {
			// se for diferente de null e desfaz toda trasação
			if (transacao != null) {
				transacao.rollback();// desfazer toda a transação
			}

		} finally {
			sessao.close();
		}
		return marcacao;

	}

	@GET
	@Path("/verificaConexao")
	@Produces("application/json")
	public String verificaComunicacao(){
		
		List<String> conexao = new ArrayList<>();
		conexao.add("OK");
		conexao.add("OK");
		
		return new Gson().toJson(conexao);
		
		
	}
	
	
	
	
	
	// ===-=-=-=-=-=-=- NÃO USO ===-=-=-=-=-=-=-
	
	
	// =-=-=-=-=-=-=-- MÉTODO RESPONSAVEL POR CARREGAR A ULTIMA LOCALIZAÇÃO DO BANCO =-=-=-=-=-=-=-=-=-
	
	@GET
	@Path("/ultimaLocalizacaoGSON")
	@Produces("application/json")
	@SuppressWarnings("unchecked")
	public String ultimaLocalizacaoGSON() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<UltimaLocalizacao> location = null;

		try {
			Query consulta = sessao.getNamedQuery("location.ultimaLocalizacao");
			location = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;

		} finally {
			sessao.close();
		}
		return new Gson().toJson(location);
	}
	
	
	// =-=-=-=-=-=-=-- MÉTODO RESPONSAVEL POR INSERIR AS LOCALIZAÇÕES NO BANCO =-=-=-=-=-=-=-=-=-
	
	@Path("/inserirLocationGSON")
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String inserirLocation(String location) { // throws Exception quem chamar
		// esse metodo vai ser obrigado
		// a tratar o erro
		Gson gson = new Gson();

		// Transforma a String no Objeto Cliente
		UltimaLocalizacao objetoLocation = gson.fromJson(location, UltimaLocalizacao.class);

		System.out.println(objetoLocation);
		// pegar uma sessão para conseguir fazer as operações no banco de dados
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null; // quando for start a transação pode dar
		// erro
		try {

			transacao = sessao.beginTransaction();
			sessao.save(objetoLocation);
			transacao.commit(); // confirma a transação

		} catch (RuntimeException ex) {
			// se for diferente de null e desfaz toda trasação
			if (transacao != null) {
				transacao.rollback();// desfazer toda a transação
			}

		} finally {
			sessao.close();
		}
		return location;

	}

	
}
