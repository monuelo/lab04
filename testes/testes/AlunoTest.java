package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import lab04.entidades.Aluno;

/**
 * Teste da classe Aluno.
 * 
 * Lab04 - Laboratório de Programação II
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class AlunoTest {

	private Aluno aluno, outroAluno;

	/**
	 * Testa o Construtor da classe Aluno.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(aluno == null);
		aluno = new Aluno("118", "Gauds", "Computação");
		assertFalse(aluno == null);
	}

	/**
	 * Testa o método getMatrícula.
	 */
	@Test
	public void testGetMatricula() {
		aluno = new Aluno("118", "Gauds", "Computação");
		assertEquals("118", aluno.getMatricula());
	}

	/**
	 * Testa a representação em String do Aluno.
	 */
	@Test
	public void testToString() {
		aluno = new Aluno("118", "Gauds", "Computação");
		assertEquals("118 - Gauds - Computação", aluno.toString());
		outroAluno = new Aluno("119", "Picles", "CC");
		assertEquals("119 - Picles - CC", outroAluno.toString());
	}

	/*
	 * Testa o método Equals quando os alunos possuem a mesma matrícula.
	 */
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

	/*
	 * Testa o método Equals quando os alunos possuem a matrículas diferentes.
	 */
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

	/**
	 * Testa o método hashCode, quando os alunos possuem hashCodes iguais.
	 */
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

	/**
	 * Testa o método hashCode, quando os alunos possuem hashCodes diferentes.
	 */
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

}
