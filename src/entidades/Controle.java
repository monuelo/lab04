package entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {

	private static final String NL = System.lineSeparator();

	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> respostas;

	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respostas = new ArrayList<>();
	}
	
	public boolean hasAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}

	public boolean hasGrupo(String nome) {
		if (grupos.containsKey(nome)) {
			return true;
		}
		return false;
	}

	public boolean CadastraAluno(String matricula, String nome, String curso) {
		if (hasAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));
		return true;
	}

	public Aluno consultaAluno(String matricula) {
		if (hasAluno(matricula)) {
			return alunos.get(matricula);
		}
		return null;
	}

	public boolean cadastraGrupo(String nome) {
		if (hasGrupo(nome)) {
			return false;
		}
		grupos.put(nome, new Grupo(nome));
		return true;
	}

	public void alocaAluno(String matricula, String grupo) {
		grupos.get(grupo).AlocaAluno((alunos.get(matricula)));
	}

	public Grupo imprimeGrupo(String grupo) {
		if (hasGrupo(grupo)) {
			return grupos.get(grupo);
		}
		return null;
	}

	public boolean alunoResponde(String matricula) {
		if (hasAluno(matricula)) {
			respostas.add(alunos.get(matricula));
			return true;
		}
		return false;
	}

	public String imprimeRespondoes() {
		String retorno = "Alunos: " + NL;
		for (int i = 0; i < respostas.size(); i++) {
			retorno += i + 1 + ". " + respostas.get(i).toString() + NL;
		}
		return retorno;
	}
}
