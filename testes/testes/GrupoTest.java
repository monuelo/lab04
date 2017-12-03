package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	private Grupo grupo, outroGrupo;

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
		assertEquals("Alunos do grupo monitores:" + System.lineSeparator(), grupo.toString());
		// Após alocar o aluno "a".
		grupo.alocaAluno(a);
		assertEquals("Alunos do grupo monitores:" + System.lineSeparator() + "* 117 - HemiAlgumaCoisa - CC"
				+ System.lineSeparator(), grupo.toString());

		// Garantir que o aluno só pode ser inserido uma vez.
		grupo.alocaAluno(a);
		assertEquals("Alunos do grupo monitores:" + System.lineSeparator() + "* 117 - HemiAlgumaCoisa - CC"
				+ System.lineSeparator(), grupo.toString());

		// Verificar a adição efetiva de alunos diferentes.
		grupo.alocaAluno(b);
		assertEquals(
				"Alunos do grupo monitores:" + System.lineSeparator() + "* 117 - HemiAlgumaCoisa - CC"
						+ System.lineSeparator() + "* 118 - PericlesFuturoMonitor - CC" + System.lineSeparator(),
				grupo.toString());

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
