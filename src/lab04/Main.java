package lab04;

import java.util.Scanner;

import lab04.entidades.*;
import lab04.util.Menu;

public class Main {
	private static final String NL = System.lineSeparator();
	private static Controle controle = new Controle();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String matricula;
		String operacao;

		do {
			System.out.print(Menu.menu());
			operacao = sc.nextLine().toUpperCase();

			if (operacao == null) {
				throw new NullPointerException("Operação Nula" + NL);
			}

			if (operacao.trim().isEmpty()) {
				throw new IllegalArgumentException("Operação Inválida" + NL);
			}

			switch (operacao) {
			case "C":
				System.out.println(cadastra());
				break;
			case "E":
				System.out.print(Menu.matricula());
				matricula = sc.nextLine();
				Aluno aluno = controle.consultaAluno(matricula);
				if (aluno == null) {
					System.out.println("Aluno não cadastrado!" + NL);
				} else {
					System.out.println(aluno.toString());
				}
				break;

			case "N":
				System.out.print(Menu.grupo());
				String grupo = sc.nextLine();
				if (controle.cadastraGrupo(grupo)) {
					System.out.println("Cadastro Realizado." + NL);
				} else {
					System.out.println("Grupo já cadastrado." + NL);
				}
				break;

			case "A":
				System.out.println(alocaImprime());
				break;

			case "R":
				System.out.print(Menu.matricula());
				matricula = sc.nextLine();
				if(controle.alunoResponde(matricula)) {
					System.out.println("Aluno Registrado." + NL);
				} else {
					System.out.println("Aluno não cadastrado." + NL);
				}
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
				System.out.println("Opção Inválida!" + NL);
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
			return "Cadastro Realizado!" + NL;
		}
		return "Matrícula Já Cadastrada" + NL;
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
				return "Aluno não cadastrado!" + NL;
			}
			if (!controle.hasGrupo(grupo)) {
				return "Grupo não cadastrado!" + NL;
			}
			controle.alocaAluno(matricula, grupo);
			return "Aluno Alocado!" + NL;

		} else if (opcao.equals("I")) {
			System.out.print(Menu.grupo());
			String nome = sc.nextLine();
			Grupo grupo = controle.imprimeGrupo(nome);
			if (!(grupo == null)) {
				return grupo.toString();
			} else {
				return "Grupo não cadastrado." + NL;
			}
		}
		return "Opção Inválida" + NL;
	}
}
