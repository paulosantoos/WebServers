package br.com.aulaws.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.aulaws.model.Marcacao;
import com.aulaws.util.HibernateUtil;



public class Teste {
	
	
	
	public static void main(String[] args) {
		
		String codigo = "baralho";
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Marcacao venda = null;

		try {
			Query consulta = sessao.getNamedQuery("marcacao.filtro");
			consulta.setString("titulo", codigo);

			venda = (Marcacao) consulta.list();
			
			if(venda != null){
				System.out.println("Deu certo: "+venda.toString());
			}
			else{
				System.out.println("Deu errado");
			}
			
			
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		
	}
	

}
