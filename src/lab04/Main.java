package lab04;

import java.util.Scanner;

import lab04.entidades.*;
import lab04.util.Menu;

public class Main {
	private static Controle controle = new Controle();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String matricula;
		String operacao;

		do {
			System.out.print(Menu.menu());
			operacao = sc.nextLine().toUpperCase();

			if (operacao == null) {
				throw new NullPointerException("Operação Nula");
			}

			if (operacao.trim().isEmpty()) {
				throw new IllegalArgumentException("Operação Inválida");
			}

			switch (operacao) {
			case "C":
				System.out.println(cadastra());
				break;
			case "E":
				System.out.print(Menu.matricula());
				matricula = sc.nextLine();
				if (controle.consultaAluno(matricula) == null) {
					System.out.println(Menu.alunoNaoCadastrado());
				} else {
					System.out.println(controle.consultaAluno(matricula).toString());
				}
				break;

			case "N":
				System.out.print(Menu.grupo());
				String grupo = sc.nextLine();
				if (controle.cadastraGrupo(grupo)) {
					System.out.println(Menu.cadastroRealizado());
				} else {
					System.out.println(Menu.grupoJaCadastrado());
				}
				break;

			case "A":
				System.out.println(alocaImprime());
				break;

			case "R":
				System.out.print(Menu.matricula());
				matricula = sc.nextLine();
				if(controle.alunoResponde(matricula)) {
					System.out.println(Menu.alunoRegistrado());
				} else {
					System.out.println(Menu.alunoNaoCadastrado());
				}
				break;

			case "I":
				System.out.println(controle.imprimeRespondoes());
				break;  

			case "O":
				System.out.println(Menu.finalizando());
				break;

			default:
				System.out.println(Menu.opcaoInvalida());
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

		if (controle.cadastraAluno(matricula, nome, curso)) {
			return Menu.cadastroRealizado();
		}
		return Menu.matriculaJaCadastrada();
	}

	public static String alocaImprime() {
		System.out.println(Menu.menuAlocacao());
		String opcao = sc.nextLine().toUpperCase();

		if (opcao.equals("A")) {
			System.out.print(Menu.matricula());
			String matricula = sc.nextLine();
			System.out.print(Menu.grupo());
			String grupo = sc.nextLine();
			if (!controle.hasAluno(matricula)) {
				return Menu.alunoNaoCadastrado();
			}
			if (!controle.hasGrupo(grupo)) {
				return Menu.grupoNaoCadastrado();
			}
			controle.alocaAluno(matricula, grupo);
			return Menu.alunoAlocado();

		} else if (opcao.equals("I")) {
			System.out.print(Menu.grupo());
			String nome = sc.nextLine();
			if (!(controle.imprimeGrupo(nome) == null)) {
				return controle.imprimeGrupo(nome).toString();
			} else {
				return Menu.grupoNaoCadastrado();
			}
		}
		return Menu.opcaoInvalida();
	}
}
