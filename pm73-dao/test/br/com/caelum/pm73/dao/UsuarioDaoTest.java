package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {

    private Session session;
    private UsuarioDao usuarioDao;

    @Before
    public void antes() {
        // criamos a sessao e a passamos para o dao
        session = new CriadorDeSessao().getSession();
        usuarioDao = new UsuarioDao(session);
    }

    @After
    public void depois() {
        // fechamos a sessao
        session.close();
    }

    @Test
    public void deveEncontrarPeloNomeEEmail() {
        Usuario novoUsuario = new Usuario
                ("João da Silva", "joao@dasilva.com.br");
        usuarioDao.salvar(novoUsuario);

        Usuario usuarioDoBanco = usuarioDao
                .porNomeEEmail("João da Silva", "joao@dasilva.com.br");

        assertEquals("João da Silva", usuarioDoBanco.getNome());
        assertEquals("joao@dasilva.com.br", usuarioDoBanco.getEmail());
    }

    @Test
    public void deveRetornarNuloSeNaoEncontrarUsuario() {
        Usuario usuarioDoBanco = usuarioDao
                .porNomeEEmail("João Joaquim", "joao@joaquim.com.br");

        assertNull(usuarioDoBanco);
    }
    
    
	@Test
	public void deveDeletarUmUsuario() {
		Usuario usuario = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		usuarioDao.salvar(usuario);
		usuarioDao.deletar(usuario);

		// envia tudo para o banco de dados        
        session.flush();
        
		Usuario usuarioNoBanco = usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");

		assertNull(usuarioNoBanco);

	}
	
	@Test
	public void deveAlterarUmUsuario() {
		Usuario usuario = new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

		usuarioDao.salvar(usuario);
		
		usuario.setNome("Mauricio Manieri");

		// invocando o metódo a testar.
		usuarioDao.atualizar(usuario);
		
		// envia tudo para o banco de dados        
        session.flush();
        
		Usuario usuarioNoBanco1 = usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");
		Usuario usuarioNoBanco2 = usuarioDao.porNomeEEmail("Mauricio Manieri", "mauricio@aniche.com.br");

		assertNull(usuarioNoBanco1);
        assertEquals("Mauricio Manieri", usuarioNoBanco2.getNome());
        assertEquals("mauricio@aniche.com.br", usuarioNoBanco2.getEmail());
	}
}