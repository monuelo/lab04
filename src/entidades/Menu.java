package entidades;

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
}
