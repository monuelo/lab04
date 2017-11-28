package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controle {

	private HashMap<String, Aluno> alunos = new HashMap<>();
	private HashMap<String, Grupo> grupos = new HashMap<>();
	private ArrayList<Aluno> respostas = new ArrayList<>();

	public String CadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (alunos.containsValue(aluno)) {
			return "MATRÍCULA JÁ CADASTRADA";
		}
		alunos.put(matricula, aluno);
		return "CADASTRO REALIZADO!";
	}

	public String consultaAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		return "Aluno não cadastrado.";
	}

	public String cadastraGrupo(String nome) {
		Grupo grupo = new Grupo(nome);
		if (grupos.containsValue(grupo)) {
			return "GRUPO JÁ CADASTRADO";
		}
		grupos.put(nome, grupo);
		return "CADASTRO REALIZADO!";
	}

	public String alocaAluno(String matricula, String grupo) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		if (!grupos.containsKey(grupo)) {
			return "Grupo não cadastrado.";
		}
		grupos.get(grupo).AlocaAluno((alunos.get(matricula)));

		return "ALUNO ALOCADO!";

	}

	public String alunoResponde(String matricula) {
		if (alunos.containsKey(matricula)) {
			respostas.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		}
		return "Aluno não cadastrado";
	}

	public String imprimeRespondoes() {
		String retorno = "Alunos: " + System.lineSeparator();
		for (int i = 0; i < respostas.size(); i++) {
			retorno += i + 1 + respostas.get(i).toString();
		}
		return retorno;
	}
}
