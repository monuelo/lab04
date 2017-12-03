package lab04.entidades;

/**
 * Representação de um Aluno. O aluno deve possuir uma número de matrícula, um
 * nome, e seu curso.
 * 
 * @author Héricles Emanuel - 117110647
 *
 */
public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Constrói um aluno a partir de ua matrícula, nome e curso.
	 * 
	 * @param matricula
	 *            O número de matrícula do aluno.
	 * @param nome
	 *            O nome do aluno.
	 * @param curso
	 *            O curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Método get para a matrícula do aluno.
	 * 
	 * @return o número de matrícula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna a representação em String de um aluno. A representação segue o
	 * formato: "Matrícula - Nome - Curso".
	 * 
	 * @return uma string que representa o aluno.
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	/**
	 * Gera um inteiro que representa hashCode de Aluno a partir de seu número de
	 * matrícula.
	 *
	 * @return o inteiro representando o hashCode do Aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Metodo equals, que compara o objeto com outro a partir de seu número de
	 * matrícula.
	 * 
	 * @param obj
	 *            Objeto a ser comparado.
	 * @return um valor booleano que indica se os objetos tem o mesmo número de
	 *         matrícula ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
