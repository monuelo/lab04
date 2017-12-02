package lab04.util;

public class Menu {
	private static final String NL = System.lineSeparator();

	public static String menu() {
		return "(C)adastrar Aluno" + NL + "(E)xibir Aluno" + NL + "(N)ovo Grupo" + NL
				+ "(A)locar Aluno no Grupo e Imprimir Grupos" + NL + "(R)egistrar Resposta de Aluno" + NL
				+ "(I)mprimir Alunos que Responderam" + NL + "(O)ra, vamos fechar o programa!" + NL + NL + "Opção > ";
	}

	public static String menuAlocacao() {
		return "(A)locar Aluno ou (I)mprimir Grupo? ";
	}

	public static String matricula() {
		return "Matricula: ";
	}

	public static String nome() {
		return "Nome: ";
	}

	public static String curso() {
		return "Curso: ";
	}

	public static String aluno() {
		return "Aluno: ";
	}

	public static String grupo() {
		return "Grupo: ";
	}

	public static String alunoNaoCadastrado() {
		return "Aluno não cadastrado!" + NL;
	}

	public static String cadastroRealizado() {
		return "Cadastro Realizado." + NL;
	}

	public static String grupoJaCadastrado() {
		return "Grupo já cadastrado." + NL;
	}

	public static String grupoNaoCadastrado() {
		return "Grupo não cadastrado." + NL;
	}

	public static String alunoRegistrado() {
		return "Aluno Registrado." + NL;
	}

	public static String opcaoInvalida() {
		return "Opção Inválida!" + NL;
	}

	public static String matriculaJaCadastrada() {
		return "Matrícula Já Cadastrada!" + NL;
	}

	public static String alunoAlocado() {
		return "Aluno Alocado!" + NL;
	}

	public static String finalizando() {
		return "Encerrando Programa...";
	}
}
