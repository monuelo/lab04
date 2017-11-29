package entidades;

import java.util.Scanner;

public class Main {
	static Controle controle = new Controle();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String operacao;
		do {
			System.out.print(Menu.menu());
			operacao = sc.nextLine();

			if (operacao == null) {
				throw new NullPointerException("Operação Nula");
			}

			if (operacao.trim().equals("")) {
				throw new IllegalArgumentException("Operação Inválida");
			}

			switch (operacao) {
			case "C":
				System.out.println(cadastra());
				break;

			case "E":
				System.out.print(Menu.matricula());
				String matricula = sc.nextLine();
				System.out.println(controle.consultaAluno(matricula));
				break;

			case "N":
				System.out.print(Menu.grupo());
				String grupo = sc.nextLine();
				controle.cadastraGrupo(grupo);
				break;

			case "A":
				System.out.println(alocaImprime());
				break;

			case "R":
				System.out.print(Menu.matricula());
				String respondao = sc.nextLine();
				System.out.println(controle.alunoResponde(respondao));
				break;

			case "I":
				System.out.println(controle.imprimeRespondoes());
				break;

			case "O":
				break;

			default:
				if (operacao.trim().isEmpty()) {
					throw new IllegalArgumentException();
				}
				System.out.println("Opção Inválida!" + System.lineSeparator());
			}

		} while (!operacao.equals("O"));
	}

	public static String cadastra() {
		System.out.print(Menu.matricula());
		String matricula = sc.nextLine();

		System.out.print(Menu.nome());
		String nome = sc.nextLine();

		System.out.print(Menu.curso());
		String curso = sc.nextLine();

		return controle.CadastraAluno(matricula, nome, curso);
	}

	public static String alocaImprime() {
		System.out.println(Menu.menuAlocacao());
		String opcao = sc.nextLine();

		if (opcao.equals("A")) {
			System.out.print(Menu.matricula());
			String matricula = sc.nextLine();
			System.out.print(Menu.grupo());
			String grupo = sc.nextLine();
			return (controle.alocaAluno(matricula, grupo));

		} else if (opcao.equals("I")) {
			System.out.print(Menu.grupo());
			String grupo = sc.nextLine();
			return (controle.imprimeGrupo(grupo));
		}
		return "Opção Inválida" + System.lineSeparator();
	}
}
