package lab04.entidades;

import java.util.ArrayList;
import java.util.HashMap;

import lab04.util.Validacao;

/**
 * Representação de um Controller. Um controle contem o mapeamento dos objetos
 * Grupo e Aluno, pelo seu nome e matrícula, respectivamente, e uma lista de
 * referências aos alunos que responderam questões. Também pode cadastrar,
 * imprimir e exibir um grupo ou aluno, alocar alunos, registrar e imprimir
 * alunos que responderam.
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Controller {

	private final String NL = System.lineSeparator();

	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> respondoes;
	private Validacao validacao;

	/**
	 * Constrói um Controller e inicializa seu array e mapas.
	 */
	public Controller() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respondoes = new ArrayList<>();
		this.validacao = new Validacao();
	}

	/**
	 * Método que verifica a existência de um aluno no mapa pela sua matrícula.
	 * 
	 * @param matricula
	 *            A matrícula do aluno.
	 * @return um valor booleano indicando a existência do aluno.
	 */
	public boolean hasAluno(String matricula) {
		if (alunos.containsKey(matricula)) {
			return true;
		}
		return false;
	}

	/**
	 * Método que verifica a existência de um Grupo no mapa pelo seu nome.
	 * 
	 * @param nome
	 *            O nome do grupo.
	 * @return um valor booleano indicando a existência do grupo.
	 */
	public boolean hasGrupo(String nome) {
		if (grupos.containsKey(nome.toLowerCase())) {
			return true;
		}
		return false;
	}

	/**
	 * Método que invoca o construtor de um aluno, e o cadastra no mapa, com sua
	 * matrícula como chave, caso ele não tenha sido cadastrado ainda.
	 * 
	 * @param matricula
	 *            A Matrícula do aluno.
	 * @param nome
	 *            O nome do aluno.
	 * @param curso
	 *            O curso do aluno.
	 * @return um boolean que indica se foi possível cadastrar ou não.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		validacao.cadastraAlunoInvalido(matricula, nome, curso);

		if (hasAluno(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula, nome, curso));

		return true;
	}

	/**
	 * Método que procura um aluno no mapa pela sua matrícula, e retorna sua
	 * representação em String.
	 * 
	 * @param matricula
	 *            A matrícula do aluno.
	 * @return a representação em String do aluno.
	 */
	public String consultaAluno(String matricula) {
		validacao.matriculaInvalida(matricula);
		if (hasAluno(matricula)) {
			return alunos.get(matricula).toString();
		}
		return null;
	}

	/**
	 * Método que invoca o construtor de um grupo, e o cadastra no mapa, com seu
	 * nome como chave, caso ele não tenha sido cadastrado ainda.
	 * 
	 * @param nome
	 *            O nome do grupo.
	 * @return um boolean que indica se foi possível cadastrar o grupo ou não.
	 */
	public boolean cadastraGrupo(String nome) {
		validacao.nomeDoGrupoInvalido(nome);

		if (hasGrupo(nome)) {
			return false;
		}
		grupos.put(nome.toLowerCase(), new Grupo(nome));
		return true;
	}

	/**
	 * Aloca um aluno a um grupo utilizando o método alocaAluno da classe Grupo. os
	 * objetos Grupo e Aluno são acessados pela sua matrícula e nome.
	 * 
	 * @param matricula
	 *            A matrícula do aluno a ser alocado.
	 * @param grupo
	 *            O nome do grupo que vai receber o aluno.
	 */
	public void alocaAluno(String matricula, String grupo) {
		validacao.matriculaInvalida(matricula);
		validacao.nomeDoGrupoInvalido(grupo);

		grupos.get(grupo.toLowerCase()).alocaAluno((alunos.get(matricula)));

	}

	/**
	 * Imprime a representação em String de um grupo, acessando-o pelo seu nome.
	 * 
	 * @param grupo
	 *            O nome do grupo a ser impresso.
	 * @return a representação em String do grupo.
	 */
	public String imprimeGrupo(String grupo) {
		validacao.nomeDoGrupoInvalido(grupo);

		if (hasGrupo(grupo)) {
			return grupos.get(grupo.toLowerCase()).toString();
		}
		return null;
	}

	/**
	 * Registra a resposta de um aluno, adicionando sua matrícula numa lista como
	 * referência.
	 * 
	 * @param matricula
	 *            A matrícula do aluno que respondeu.
	 * @return um valor booleano que indica se foi possível cadastrar o aluno ou
	 *         não, caso a matrícula seja inválida.
	 */
	public boolean alunoResponde(String matricula) {
		validacao.matriculaInvalida(matricula);

		if (hasAluno(matricula)) {
			respondoes.add(matricula);
			return true;
		}
		return false;
	}

	/**
	 * Imprime todos os alunos que responderam ordenados, com sua representação em
	 * String. A representação segue o formato: "Alunos: (ordem de resposta).
	 * matrícula - nome - curso.
	 * 
	 * @return
	 */
	public String imprimeRespondoes() {
		String retorno = "Alunos:" + NL;
		for (int i = 0; i < respondoes.size(); i++) {
			retorno += i + 1 + ". " + consultaAluno(respondoes.get(i)).toString() + NL;
		}
		return retorno;
	}
}
