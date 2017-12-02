package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import lab04.entidades.Aluno;
import lab04.entidades.Grupo;

public class GrupoTest {

	Grupo grupo, outroGrupo;

	@Test
	public void testConstrutor() {
		assertTrue(grupo == null);
		grupo = new Grupo("GG SURRENDER AOS 15");
		assertFalse(grupo == null);
	}

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

	@Test
	public void testGetNome() {
		grupo = new Grupo("Gaudetes");
		assertEquals("Gaudetes", grupo.getNome());
	}

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

	@Test
	public void testHashCodeDiferente() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Shoow");
		assertFalse(grupo.hashCode() == outroGrupo.hashCode());
		outroGrupo = new Grupo("flw");
		assertFalse(grupo.hashCode() == outroGrupo.hashCode());
	}

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

	@Test
	public void testGruposDiferentes() {
		grupo = new Grupo("Show");
		outroGrupo = new Grupo("Shoow");
		assertFalse(grupo.equals(outroGrupo));
		outroGrupo = new Grupo("flw");
		assertFalse(grupo.equals(outroGrupo));

	}
}
