package lab04.util;

public class Validacao {

	public static void matriculaInvalida(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula Nula");
		}

		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula Inválida");
		}
	}

	public static void nomeDoGrupoInvalido(String nomeDoGrupo) {
		if (nomeDoGrupo == null) {
			throw new NullPointerException("Nome Nulo");
		}

		if (nomeDoGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome Inválido");
		}
	}

	public static void cadastraAlunoInvalido(String matricula, String nome, String curso) {
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
