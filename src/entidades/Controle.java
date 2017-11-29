package entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	private static final String NL = System.lineSeparator();
	private HashMap<String, Aluno> alunos = new HashMap<>();
	private HashMap<String, Grupo> grupos = new HashMap<>();
	private ArrayList<Aluno> respostas = new ArrayList<>();

	public String CadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (alunos.containsValue(aluno)) {
			return "MATRÍCULA JÁ CADASTRADA" + NL;
		}
		alunos.put(matricula, aluno);
		return "CADASTRO REALIZADO!" + NL;
	}

	public String consultaAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		return "Aluno não cadastrado." + NL;
	}

	public String cadastraGrupo(String nome) {
		Grupo grupo = new Grupo(nome);
		if (grupos.containsValue(grupo)) {
			return "GRUPO JÁ CADASTRADO" + NL;
		}
		grupos.put(nome, grupo);
		return "CADASTRO REALIZADO!" + NL;
	}

	public String alocaAluno(String matricula, String grupo) {
		if (!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado." + NL;
		}
		if (!grupos.containsKey(grupo)) {
			return "Grupo não cadastrado." + NL;
		}
		grupos.get(grupo).AlocaAluno((alunos.get(matricula)));

		return "ALUNO ALOCADO!" + NL;

	}

	public String imprimeGrupo(String grupo) {
		if (!grupos.containsKey(grupo)) {
			return "Grupo não cadastrado." + NL;
		}
		return grupos.get(grupo).toString();
	}

	public String alunoResponde(String matricula) {
		if (alunos.containsKey(matricula)) {
			respostas.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!" + NL;
		}
		return "Aluno não cadastrado" + NL;
	}

	public String imprimeRespondoes() {
		String retorno = "Alunos: " + NL;
		for (int i = 0; i < respostas.size(); i++) {
			retorno += i + 1 + ". " + respostas.get(i).toString() + NL;
		}
		return retorno;
	}
}
