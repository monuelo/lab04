package lab04.util;

/**
 * Classe de Validação de Entradas. Verifica entradas inválidas e lança
 * exceções, caso sejam.
 *
 * Lab04 - Laboratório de Programação II
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Validacao {

	/**
	 * Verifica se uma matrícula é nula ou vazia.
	 * 
	 * @param matricula
	 *            A String a ser verificada.
	 */
	public void matriculaInvalida(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula Nula");
		}

		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula Inválida");
		}
	}

	/**
	 * Verifica se o nome do Grupo é nulo ou vazio.
	 * 
	 * @param nomeDoGrupo
	 *            A String a ser verificada.
	 */
	public void nomeDoGrupoInvalido(String nomeDoGrupo) {
		if (nomeDoGrupo == null) {
			throw new NullPointerException("Nome Nulo");
		}

		if (nomeDoGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome Inválido");
		}
	}

	/**
	 * Verifica se os parâmetros de cadastro de um Aluno são inválidos.
	 * 
	 * @param matricula
	 *            A matrícula do aluno.
	 * @param nome
	 *            O nome do aluno.
	 * @param curso
	 *            O curso do aluno.
	 */
	public void cadastraAlunoInvalido(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula Nula");
		}

		if (nome == null) {
			throw new NullPointerException("Nome Nulo");
		}

		if (curso == null) {
			throw new NullPointerException("Curso Nulo");
		}

		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula Inválida");
		}

		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome Inválido");
		}

		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso Inválido");
		}

	}

}
