package pt.com.renanalvesdev;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static pt.com.renanalvesdev.utils.DataUtils.isMesmaData;
import static pt.com.renanalvesdev.utils.DataUtils.obterDataComDiferencaDias;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import pt.com.renanalvesdev.entidades.Filme;
import pt.com.renanalvesdev.entidades.Locacao;
import pt.com.renanalvesdev.entidades.Usuario;
import pt.com.renanalvesdev.servicos.LocacaoService;

public class LocacaoServiceTest {
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void testeLocacao() {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verficacao
		error.checkThat(locacao.getValor(),  is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
	
	//TODO
	
}