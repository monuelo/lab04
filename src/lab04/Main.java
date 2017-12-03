package lab04;

import java.util.Scanner;

import lab04.entidades.*;
import lab04.util.Menu;

/**
 * Classe principal do sistema
 * 
 * Lab04 - Laboratório de Programação II
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Main {

	private static Controller controle = new Controller();
	private static Scanner sc = new Scanner(System.in);
	private static Menu menu = new Menu();

	public static void main(String[] args) {
		String matricula;
		String operacao;

		do {
			System.out.print(menu.menu());
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
				System.out.print(menu.matricula());
				matricula = sc.nextLine();

				if (controle.consultaAluno(matricula) == null) {
					System.out.println(menu.alunoNaoCadastrado());
				} else {
					System.out.println(controle.consultaAluno(matricula));
				}

				break;

			case "N":
				System.out.print(menu.grupo());
				String grupo = sc.nextLine();

				if (controle.cadastraGrupo(grupo)) {
					System.out.println(menu.cadastroRealizado());
				} else {
					System.out.println(menu.grupoJaCadastrado());
				}

				break;

			case "A":
				System.out.println(menu.menuAlocacao());
				String opcao = sc.nextLine().toUpperCase();

				if (opcao.equals("A")) {
					System.out.println(aloca());
				} else if (opcao.equals("I")) {
					System.out.println(imprime());
				} else {
					System.out.println(menu.opcaoInvalida());
				}

				break;

			case "R":
				System.out.print(menu.matricula());
				matricula = sc.nextLine();

				if (controle.alunoResponde(matricula)) {
					System.out.println(menu.alunoRegistrado());
				} else {
					System.out.println(menu.alunoNaoCadastrado());
				}

				break;

			case "I":
				System.out.println(controle.imprimeRespondoes());
				break;

			case "O":
				System.out.println(menu.finalizando());
				break;

			default:
				System.out.println(menu.opcaoInvalida());
			}

		} while (!operacao.equals("O"));
	}

	/**
	 * Lê os dados de entradas e realiza o cadastro de um aluno, caso possível.
	 * 
	 * @return uma String que informa se o cadastro foi realizado ou não.
	 */
	public static String cadastra() {
		System.out.print(menu.matricula());
		String matricula = sc.nextLine();

		System.out.print(menu.nome());
		String nome = sc.nextLine();

		System.out.print(menu.curso());
		String curso = sc.nextLine();

		if (controle.cadastraAluno(matricula, nome, curso)) {
			return menu.cadastroRealizado();
		}
		return menu.matriculaJaCadastrada();
	}

	/**
	 * Lê os dados de Entrada, e aloca um alun a um grupo, caso possível. ou imprime
	 * o grupo. Dependendo do que foi inserido.
	 * 
	 * @return uma String que informa se método
	 */
	public static String aloca() {
		System.out.print(menu.matricula());
		String matricula = sc.nextLine();

		System.out.print(menu.grupo());
		String grupo = sc.nextLine();

		if (!controle.hasAluno(matricula)) {
			return menu.alunoNaoCadastrado();
		}
		if (!controle.hasGrupo(grupo)) {
			return menu.grupoNaoCadastrado();
		}
		controle.alocaAluno(matricula, grupo);
		return menu.alunoAlocado();
	}

	/**
	 * Imprime a representação em string de um grupo dado na entrada.
	 * 
	 * @return uma String que representa um grupo.
	 */
	public static String imprime() {
		System.out.print(menu.grupo());
		String nome = sc.nextLine();

		if (!(controle.imprimeGrupo(nome) == null)) {
			return controle.imprimeGrupo(nome);
		} else {
			return menu.grupoNaoCadastrado();
		}
	}
}
