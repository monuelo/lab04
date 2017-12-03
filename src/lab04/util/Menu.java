package lab04.util;

/**
 * Classe Menu do Sistema. Possui os possíveis retornos em String de comunicação
 * com o usuário.
 * 
 * Lab04 - Laboratório de Programação II
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Menu {
	private static final String NL = System.lineSeparator();

	/**
	 * Lista as possíveis operações a serem realizadas.
	 * 
	 * @return uma string com as operações.
	 */
	public static String menu() {
		return "(C)adastrar Aluno" + NL + "(E)xibir Aluno" + NL + "(N)ovo Grupo" + NL
				+ "(A)locar Aluno no Grupo e Imprimir Grupos" + NL + "(R)egistrar Resposta de Aluno" + NL
				+ "(I)mprimir Alunos que Responderam" + NL + "(O)ra, vamos fechar o programa!" + NL + NL + "Opção > ";
	}

	/**
	 * Lista as possíveis operações quanto à alocação ou impressão.
	 * 
	 * @return uma String com as operações.
	 */
	public static String menuAlocacao() {
		return "(A)locar Aluno ou (I)mprimir Grupo? ";
	}

	/**
	 * Retorna a string que precede a matrícula.
	 * 
	 * @return a string "Matricula: ".
	 */
	public static String matricula() {
		return "Matricula: ";
	}

	/**
	 * Retorna a string que precede o nome.
	 * 
	 * @return a string "Nome: ".
	 */
	public static String nome() {
		return "Nome: ";
	}

	/**
	 * Retorna a string que precede o curso.
	 * 
	 * @return a string "Curso: ".
	 */
	public static String curso() {
		return "Curso: ";
	}

	/**
	 * Retorna a string que precede o Aluno.
	 * 
	 * @return a string "Aluno: ".
	 */
	public static String aluno() {
		return "Aluno: ";
	}

	/**
	 * Retorna a string que precede o Grupo.
	 * 
	 * @return a string "Grupo: ".
	 */
	public static String grupo() {
		return "Grupo: ";
	}

	/**
	 * Informa que o aluno não está cadastrado.
	 * 
	 * @return a string "Aluno não cadastrado!".
	 */
	public static String alunoNaoCadastrado() {
		return "Aluno não cadastrado!" + NL;
	}

	/**
	 * Informa que o cadastro foi realizado.
	 * 
	 * @return a string "Cadastro Realizado.".
	 */
	public static String cadastroRealizado() {
		return "Cadastro Realizado." + NL;
	}

	/**
	 * Informa que o grupo já está cadastrado.
	 * 
	 * @return a string "Grupo já cadastrado!".
	 */
	public static String grupoJaCadastrado() {
		return "Grupo já cadastrado!" + NL;
	}

	/**
	 * Informa que o Grupo não está cadastrado.
	 * 
	 * @return a string "Grupo não cadastrado!".
	 */
	public static String grupoNaoCadastrado() {
		return "Grupo não cadastrado!" + NL;
	}

	/**
	 * Informa que o aluno foi registrado.
	 * 
	 * @return a string "Aluno Registrado".
	 */
	public static String alunoRegistrado() {
		return "Aluno Registrado." + NL;
	}

	/**
	 * Informa que a opção é inválida.
	 * 
	 * @return a string "Opção Inválida!".
	 */
	public static String opcaoInvalida() {
		return "Opção Inválida!" + NL;
	}

	/**
	 * Informa que a matrícula já está cadastrada.
	 * 
	 * @return a string "Matrícula Já Cadastrada!".
	 */
	public static String matriculaJaCadastrada() {
		return "Matrícula Já Cadastrada!" + NL;
	}

	/**
	 * Informa que o aluno foi alocado.
	 * 
	 * @return a string "Aluno alocado!".
	 */
	public static String alunoAlocado() {
		return "Aluno Alocado!" + NL;
	}

	/**
	 * Informa o término do programa.
	 * 
	 * @return a string "Encerrando Programa...".
	 */
	public static String finalizando() {
		return "Encerrando Programa...";
	}
}
