package entidades;

public class Main {
	public static void main(String[] args) {
		Controle c = new Controle();
		System.out.println(c.CadastraAluno("125", "Wes", "CC"));
		System.out.println(c.consultaAluno("125"));
		System.out.println(c.consultaAluno("124"));
		System.out.println(c.alocaAluno("125", "gg"));
		System.out.println(c.alocaAluno("124", "gg"));
		System.out.println(c.cadastraGrupo("gg"));
		System.out.println(c.alocaAluno("125", "gg"));
		System.out.println(c.alocaAluno("125", "gg"));
		System.out.println(c.imprimeGrupo("gg"));
		System.out.println(c.imprimeGrupo("ggas"));
		System.out.println(c.cadastraGrupo("GG"));
		
	}
}
