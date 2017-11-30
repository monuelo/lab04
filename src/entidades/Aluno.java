package entidades;

public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	public Aluno(String matricula, String nome, String curso) {

		verificaNulo("Matrícula", matricula);
		verificaNulo("Nome", nome);
		verificaNulo("Curso", curso);		
		verificaVazio("Matrícula", matricula);
		verificaVazio("Nome", nome);
		verificaVazio("Curso", curso);

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	private void verificaVazio(String tipo, String nome) {
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(tipo + " Vazio(a)");
		}
	}
	
	private void verificaNulo(String tipo, String nome) {
		if (nome == null) {
			throw new NullPointerException(tipo + " Nulo(a)");
		}
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
