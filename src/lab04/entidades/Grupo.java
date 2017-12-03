package lab04.entidades;

import java.util.HashSet;

/**
 * Representação de um Grupo de estudos. O grupo deve possuir uma nome, e um set
 * com os alunos que estão incluídos nele, sendo possível alocar um aluno ao
 * grupo.
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos = new HashSet<>();

	/**
	 * Constrói um Grupo a partir de seu nome.
	 * 
	 * @param nome
	 *            O nome do grupo a ser criado.
	 */
	public Grupo(String nome) {
		this.nome = nome;

	}

	/**
	 * Aloca um aluno ao grupo, adicionando-o ao seu Set de alunos.
	 * 
	 * @param aluno
	 *            O objeto Aluno a ser alocado.
	 */
	public void alocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	/**
	 * Método get para o nome do Grupo.
	 * 
	 * @return o nome do grupo.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método get para o Set de alunos do Grupo.
	 * 
	 * @return o Set de alunos que integram o grupo.
	 */
	public HashSet<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * Retorna a representação em String de um grupo. A representação segue o
	 * formato: 
	 * "Alunos do Grupo (nome): 
	 * * Representação em String de cada aluno".
	 * 
	 * @return uma String que representa o grupo.
	 */
	@Override
	public String toString() {
		String retorno = "Alunos do grupo " + this.nome + ":" + System.lineSeparator();
		for (Aluno i : alunos) {
			retorno += "* " + i.toString() + System.lineSeparator();
		}
		return retorno;
	}

	/**
	 * Gera um inteiro que representa hashCode do Grupo a partir de seu nome. o nome
	 * não é diferenciado por letras maiúsculas e minúsculas.
	 *
	 * @return o inteiro representando o hashCode do Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.toLowerCase().hashCode());
		return result;
	}
	
	/**
	 * Metodo equals, que compara o objeto com outro a partir de seu nome. Não é considerada a diferença de letras maiúsculas e minúsculas.
	 * 
	 * @param obj
	 *            Objeto a ser comparado.
	 * @return um valor booleano que indica se os objetos tem o mesmo nome ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}

}
