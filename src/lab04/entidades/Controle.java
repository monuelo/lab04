package lab04.entidades;

import java.util.ArrayList;
import java.util.HashMap;

import lab04.util.Validacao;

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

	public HashMap<String, Aluno> getAlunos() {
		return alunos;
	}

	public HashMap<String, Grupo> getGrupos() {
		return grupos;
	}

	public ArrayList<String> getRespostas() {
		return respostas;
	}

	public boolean hasAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}

	public boolean hasGrupo(String nome) {
		if (grupos.containsKey(nome.toLowerCase())) {
			return true;
		}
		return false;
	}

	public boolean cadastraAluno(String matricula, String nome, String curso) {
		Validacao.cadastraAlunoInvalido(matricula, nome, curso);

		if (hasAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));

		return true;
	}

	public String consultaAluno(String matricula) {
		Validacao.matriculaInvalida(matricula);
		if (hasAluno(matricula)) {
			return alunos.get(matricula).toString();
		}
		return null;
	}

	public boolean cadastraGrupo(String nome) {
		Validacao.nomeDoGrupoInvalido(nome);

		if (hasGrupo(nome)) {
			return false;
		}
		grupos.put(nome.toLowerCase(), new Grupo(nome));
		return true;
	}

	public void alocaAluno(String matricula, String grupo) {
		Validacao.matriculaInvalida(matricula);
		Validacao.nomeDoGrupoInvalido(grupo);

		grupos.get(grupo.toLowerCase()).alocaAluno((alunos.get(matricula)));

	}

	public String imprimeGrupo(String grupo) {
		Validacao.nomeDoGrupoInvalido(grupo);

		if (hasGrupo(grupo)) {
			return grupos.get(grupo.toLowerCase()).toString();
		}
		return null;
	}

	public boolean alunoResponde(String matricula) {
		Validacao.matriculaInvalida(matricula);

		if (hasAluno(matricula)) {
			respostas.add(matricula);
			return true;
		}
		return false;
	}

	public String imprimeRespondoes() {
		String retorno = "Alunos:" + NL;
		for (int i = 0; i < respostas.size(); i++) {
			retorno += i + 1 + ". " + consultaAluno(respostas.get(i)).toString() + NL;
		}
		return retorno;
	}
}
