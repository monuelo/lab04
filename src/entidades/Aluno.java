package entidades;

public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula Inválida");
		}

		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula Inválida");
		}

		if (nome == null) {
			throw new NullPointerException("Nome Inválido");
		}

		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome Inválida");
		}

		if (curso == null) {
			throw new NullPointerException("Curso Inválido");
		}

		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso Inválido");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

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
