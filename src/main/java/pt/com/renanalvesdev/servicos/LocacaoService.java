package pt.com.renanalvesdev.servicos;

import static pt.com.renanalvesdev.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import pt.com.renanalvesdev.entidades.Filme;
import pt.com.renanalvesdev.entidades.Locacao;
import pt.com.renanalvesdev.entidades.Usuario;
import pt.com.renanalvesdev.utils.DataUtils;

public class LocacaoService {
	
	String teste;
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}
	
	
}