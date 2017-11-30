package lab04.entidades;

import java.util.ArrayList;
import java.util.HashMap;

import lab04.util.Testes;

public class Controle {

	private static final String NL = System.lineSeparator();

	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> respostas;

	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respostas = new ArrayList<>();
	}

	public boolean hasAluno(String matricula) {
		Testes.verificaNulo("Matrícula", matricula);
		Testes.verificaVazio("Matrícula", matricula);
		if (alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}

	public boolean hasGrupo(String nome) {
		Testes.verificaNulo("Nome", nome);
		Testes.verificaVazio("Nome", nome);

		if (grupos.containsKey(nome)) {
			return true;
		}
		return false;
	}

	public boolean cadastraAluno(String matricula, String nome, String curso) {
		Testes.verificaNulo("Matrícula", matricula);
		Testes.verificaNulo("Nome", nome);
		Testes.verificaNulo("Curso", curso);
		Testes.verificaVazio("Matrícula", matricula);
		Testes.verificaVazio("Nome", nome);
		Testes.verificaVazio("Curso", curso);

		if (hasAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));

		return true;
	}

	public Aluno consultaAluno(String matricula) {
		Testes.verificaNulo("Matrícula", matricula);
		Testes.verificaVazio("Matrícula", matricula);

		if (hasAluno(matricula)) {
			return alunos.get(matricula);
		}
		return null;
	}

	public boolean cadastraGrupo(String nome) {
		Testes.verificaNulo("Nome", nome);
		Testes.verificaVazio("Nome", nome);

		if (hasGrupo(nome)) {
			return false;
		}
		grupos.put(nome, new Grupo(nome));
		return true;
	}

	public void alocaAluno(String matricula, String grupo) {
		Testes.verificaNulo("Matrícula", matricula);
		Testes.verificaNulo("Nome", grupo);
		Testes.verificaVazio("Matrícula", matricula);
		Testes.verificaVazio("Nome", grupo);

		grupos.get(grupo).AlocaAluno((alunos.get(matricula)));
	}

	public Grupo imprimeGrupo(String grupo) {
		Testes.verificaNulo("Nome", grupo);
		Testes.verificaVazio("Nome", grupo);

		if (hasGrupo(grupo)) {
			return grupos.get(grupo);
		}
		return null;
	}

	public boolean alunoResponde(String matricula) {
		Testes.verificaNulo("Matrícula", matricula);
		Testes.verificaVazio("Matrícula", matricula);

		if (hasAluno(matricula)) {
			respostas.add(matricula);
			return true;
		}
		return false;
	}

	public String imprimeRespondoes() {
		String retorno = "Alunos: " + NL;
		for (int i = 0; i < respostas.size(); i++) {
			retorno += i + 1 + ". " + consultaAluno(respostas.get(i)).toString() + NL;
		}
		return retorno;
	}
}
