package lab04.entidades;

import java.util.HashSet;
import lab04.util.Testes;

public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos = new HashSet<>();

	public Grupo(String nome) {
		Testes.verificaNulo("Nome", nome);
		Testes.verificaVazio("Nome", nome);
		this.nome = nome;

	}

	public void AlocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		String retorno = "Alunos do grupo " + this.nome + ":" + System.lineSeparator();
		for (Aluno i : alunos) {
			retorno += "* " + i.toString() + System.lineSeparator();
		}
		return retorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.toLowerCase().hashCode());
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
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}

}
