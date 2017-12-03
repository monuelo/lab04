package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import lab04.entidades.Aluno;
import lab04.entidades.Grupo;

/**
 * Teste da classe Grupo.
 * 
 * Lab04 - Laboratório de Programação II
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class GrupoTest {

	Grupo grupo, outroGrupo;

	/**
	 * Testa o construtor de um grupo.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(grupo == null);
		grupo = new Grupo("GG SURRENDER AOS 15");
		assertFalse(grupo == null);
	}

	/**
	 * Testa a alocação de alunos no Set de objetos do tipo Aluno.
	 */
	@Test
	public void testAlocaAluno() {
		grupo = new Grupo("monitores");
		Aluno a = new Aluno("117", "HemiAlgumaCoisa", "CC");
		Aluno b = new Aluno("118", "PericlesFuturoMonitor", "CC");

		// Antes de alocar o aluno "a".
		assertTrue(grupo.getAlunos().size() == 0);
		grupo.alocaAluno(a);

		// Após alocar o aluno "a".
		assertTrue(grupo.getAlunos().size() == 1);
		assertTrue(grupo.getAlunos().contains(a));

		// Garantir que o aluno só pode ser inserido uma vez.
		grupo.alocaAluno(a);
		assertTrue(grupo.getAlunos().size() == 1);
		assertTrue(grupo.getAlunos().contains(a));

		// Verificar a adição efetiva de alunos diferentes.
		grupo.alocaAluno(b);
		assertTrue(grupo.getAlunos().size() == 2);
		assertTrue(grupo.getAlunos().contains(b));
	}

	/**
	 * Testa o método get para o nome do grupo.
	 */
	@Test
	public void testGetNome() {
		grupo = new Grupo("Gaudetes");
		assertEquals("Gaudetes", grupo.getNome());
	}

	/**
	 * Testa o método get para o Set de alunos do grupo.
	 */
	@Test
	public void testGetAlunos() {
		grupo = new Grupo("Miniaturas da sala de gauds");
		Aluno a = new Aluno("117", "Gauds", "CC");
		HashSet<Aluno> set = new HashSet<>();

		// Obtendo um HashSet Vazio.
		assertEquals(set, grupo.getAlunos());

		// Verificando o retorno com elementos no HashSet
		set.add(a);
		grupo.alocaAluno(a);
		assertEquals(set, grupo.getAlunos());
	}

	/**
	 * Testa o método hashCode, quando os grupos possuem hashCodes iguais.
	 */
	@Test
	public void testHashCodeIgual() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Show");
		assertTrue(grupo.hashCode() == outroGrupo.hashCode());
		outroGrupo = new Grupo("show");
		assertTrue(grupo.hashCode() == outroGrupo.hashCode());
		outroGrupo = new Grupo("SHOW");
		assertTrue(grupo.hashCode() == outroGrupo.hashCode());
	}

	/**
	 * Testa o método hashCode, quando os grupos possuem hashCodes diferentes.
	 */
	@Test
	public void testHashCodeDiferente() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Shoow");
		assertFalse(grupo.hashCode() == outroGrupo.hashCode());
		outroGrupo = new Grupo("flw");
		assertFalse(grupo.hashCode() == outroGrupo.hashCode());
	}

	/*
	 * Testa o método Equals quando os grupos possuem os mesmos nomes.
	 */
	@Test
	public void testGruposIguais() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Show");
		assertTrue(grupo.equals(outroGrupo));
		outroGrupo = new Grupo("show");
		assertTrue(grupo.equals(outroGrupo));
		outroGrupo = new Grupo("SHOW");
		assertTrue(grupo.equals(outroGrupo));
	}


	/*
	 * Testa o método Equals quando os grupos possuem nomes diferentes.
	 */
	@Test
	public void testGruposDiferentes() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Shoow");
		assertFalse(grupo.equals(outroGrupo));
		outroGrupo = new Grupo("flw");
		assertFalse(grupo.equals(outroGrupo));

	}
}
