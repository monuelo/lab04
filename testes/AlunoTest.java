
import static org.junit.Assert.*;

import org.junit.Test;

import lab04.entidades.Aluno;

public class AlunoTest {

	Aluno aluno, outroAluno;

	@Test
	public void testConstrutor() {
		assertTrue(aluno == null);
		aluno = new Aluno("118", "Gauds", "Computação");
		assertFalse(aluno == null);
	}

	@Test
	public void testGetMatricula() {
		aluno = new Aluno("118", "Gauds", "Computação");
		assertEquals("118", aluno.getMatricula());
	}

	@Test
	public void testToString() {
		aluno = new Aluno("118", "Gauds", "Computação");
		assertEquals("118 - Gauds - Computação", aluno.toString());
		outroAluno = new Aluno("119", "Picles", "CC");
		assertEquals("119 - Picles - CC", outroAluno.toString());
	}

	@Test
	public void testAlunosIguais() {
		aluno = new Aluno("118", "Gauds", "Computação");
		outroAluno = new Aluno("118", "Gauds", "Computação");

		assertTrue(aluno.equals(outroAluno));
		aluno = new Aluno("118", "Picles", "Computação");
		assertTrue(aluno.equals(outroAluno));
		aluno = new Aluno("118", "Gauds", "Elétrica");
		assertTrue(aluno.equals(outroAluno));
		aluno = new Aluno("118", "Picles", "Elétrica");
		assertTrue(aluno.equals(outroAluno));

	}

	@Test
	public void testAlunosDiferentes() {
		aluno = new Aluno("118", "Gauds", "Computação");
		outroAluno = new Aluno("119", "Gauds", "Computação");

		assertFalse(aluno.equals(outroAluno));
		aluno = new Aluno("120", "Picles", "Computação");
		assertFalse(aluno.equals(outroAluno));
		aluno = new Aluno("117", "Gauds", "Elétrica");
		assertFalse(aluno.equals(outroAluno));
		aluno = new Aluno("114", "Picles", "Elétrica");
		assertFalse(aluno.equals(outroAluno));

	}

	@Test
	public void testHashCodeIguais() {
		aluno = new Aluno("118", "Gauds", "Computação");
		outroAluno = new Aluno("118", "Gauds", "Computação");

		assertTrue(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("118", "Picles", "Computação");
		assertTrue(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("118", "Gauds", "Elétrica");
		assertTrue(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("118", "Picles", "Elétrica");
		assertTrue(aluno.hashCode() == outroAluno.hashCode());
	}

	@Test
	public void testHashCodeDiferentes() {
		aluno = new Aluno("118", "Gauds", "Computação");
		outroAluno = new Aluno("119", "Gauds", "Computação");

		assertFalse(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("120", "Picles", "Computação");
		assertFalse(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("117", "Gauds", "Elétrica");
		assertFalse(aluno.hashCode() == outroAluno.hashCode());
		aluno = new Aluno("114", "Picles", "Elétrica");
		assertFalse(aluno.hashCode() == outroAluno.hashCode());
		
	}
	@Test(expected = NullPointerException.class)
	public void testMatriculaNula() {
		aluno = new Aluno(null, "Gauds", "Computação");
	}

	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		aluno = new Aluno("118", null, "Computação");
	}

	@Test(expected = NullPointerException.class)
	public void testCursoNulo() {
		aluno = new Aluno("118", "Gauds", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMatriculaVazia() {
		aluno = new Aluno("", "Gauds", "Computação");
		aluno = new Aluno("           ", "Gauds", "Computação");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNomeVazio() {
		aluno = new Aluno("118", "", "Computação");
		aluno = new Aluno("118", "     ", "Computação");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCursoVazio() {
		aluno = new Aluno("118", "Gauds", "");
		aluno = new Aluno("118", "Gauds", "       ");
	}

}
