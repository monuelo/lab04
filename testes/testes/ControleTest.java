package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab04.entidades.Controle;

public class ControleTest {
	Controle controle, outroControle;

	@Before
	public void inicializaControle() {
		controle = new Controle();
	}

	@Test
	public void testConstrutor() {
		assertTrue(outroControle == null);
		assertFalse(controle == null);
		outroControle = new Controle();
		assertFalse(outroControle == null);
	}

	@Test
	public void testHasAluno() {
		assertFalse(controle.hasAluno("117"));
		controle.cadastraAluno("117", "Anne", "CC");
		assertTrue(controle.hasAluno("117"));
		assertFalse(controle.hasAluno("118"));
	}

	@Test
	public void testHasGrupo() {
		assertFalse(controle.hasGrupo("Gatinhas de cc"));
		controle.cadastraGrupo("Gatinhas de cc");
		assertTrue(controle.hasGrupo("Gatinhas de cc"));
		assertFalse(controle.hasGrupo("Gatinhos de cc"));
	}

	@Test
	public void testCadastraAluno() {
		// Verifica o tamanho antes do cadastro.
		assertTrue(controle.getAlunos().size() == 0);

		// Verificação pós cadastro.
		assertTrue(controle.cadastraAluno("123", "Pericles", "Exaltasamba"));
		assertTrue(controle.getAlunos().size() == 1);
		
		// Garante que alunos de mesma matrícula não se matriculem mais de uma vez.
		assertTrue(controle.getAlunos().containsKey("123"));
		assertFalse(controle.cadastraAluno("123", "Matheus", "Goderagem"));
		assertTrue(controle.getAlunos().size() == 1);
		
		// Verifica o cadastro de outros alunos.
		assertTrue(controle.cadastraAluno("124", "Hemi", "CC"));
		assertTrue(controle.getAlunos().size() == 2);
		assertTrue(controle.getAlunos().containsKey("124"));
	}

	@Test
	public void testConsultaAluno() {
		assertEquals(null, controle.consultaAluno("123"));
		controle.cadastraAluno("123", "Pericles", "Exaltasamba");
		assertEquals("123 - Pericles - Exaltasamba", controle.consultaAluno("123"));
	}

	@Test
	public void testCadastraGrupo() {
		// Verifica o tamanho antes do cadastro.
		assertTrue(controle.getGrupos().size() == 0);
		
		// Garante que o grupo foi cadastrado.
		assertTrue(controle.cadastraGrupo("YoFans"));
		assertTrue(controle.getGrupos().containsKey("yofans"));
		assertTrue(controle.getGrupos().size() == 1);
		
		// Garante que grupos de mesmo nome não sejam cadastrados novamente.
		// --- Insensitive Case.
		assertFalse(controle.cadastraGrupo("yofans"));
		assertTrue(controle.getGrupos().size() == 1);
		
		// Verifica o cadastro de grupos diferentes.
		assertTrue(controle.cadastraGrupo("AtalEhRasgado"));
		assertTrue(controle.getGrupos().containsKey("atalehrasgado"));
		assertTrue(controle.getGrupos().size() == 2);

	}

	@Test
	public void testAlocaAluno() {
		// Verifica o tamanho antes da alocação.
		controle.cadastraAluno("123", "Picles", "CC");
		controle.cadastraGrupo("Testano");
		assertTrue(controle.getGrupos().get("testano").getAlunos().size() == 0);

		// Verifica a alocação do aluno no grupo.
		controle.alocaAluno("123", "Testano");
		assertTrue(controle.getGrupos().get("testano").getAlunos().size() == 1);

		// Garante que o mesmo aluno não pode ser alocado mais de uma vez no mesmo
		// grupo.
		controle.alocaAluno("123", "Testano");
		assertTrue(controle.getGrupos().get("testano").getAlunos().size() == 1);

		// Verifica a alocação de alunos diferentes.
		controle.cadastraAluno("124", "13900ip", "Games");
		controle.alocaAluno("124", "Testano");
		assertTrue(controle.getGrupos().get("testano").getAlunos().size() == 2);

	}

	@Test
	public void testImprimeGrupo() {
		// Verifica o retorno quando o grupo não existe.
		assertTrue(controle.imprimeGrupo("Unknow") == null);

		// Verifica o retorno quando o grupo não possui alunos.
		controle.cadastraGrupo("Sla");
		assertEquals("Alunos do grupo Sla:" + System.lineSeparator(), controle.imprimeGrupo("Sla"));

		// Verifica o retorno quando existe um aluno no grupo.
		controle.cadastraAluno("123", "PraQNome", "CC");
		controle.alocaAluno("123", "Sla");
		assertEquals("Alunos do grupo Sla:" + System.lineSeparator() + "* 123 - PraQNome - CC" + System.lineSeparator(),
				controle.imprimeGrupo("Sla"));

		// Verifica o retorno quando existe mais de um aluno no grupo.
		controle.cadastraAluno("1234", "I Have a name", "Humanax");
		controle.alocaAluno("1234", "Sla");
		assertEquals("Alunos do grupo Sla:" + System.lineSeparator() + "* 123 - PraQNome - CC" + System.lineSeparator()
				+ "* 1234 - I Have a name - Humanax" + System.lineSeparator(), controle.imprimeGrupo("Sla"));
	}

	@Test
	public void testAlunoResponde() {
		// Verifica retorno quando aluno não existe.
		assertFalse(controle.alunoResponde("125"));

		// Garante o cadastro da resposta de um aluno.
		controle.cadastraAluno("125", "Anne Anjo", "Doceria");
		controle.alunoResponde("125");
		assertTrue(controle.getRespostas().size() == 1);
		assertTrue(controle.getRespostas().contains("125"));

		// Garante o cadastro da resposta de mais de um aluno.
		controle.cadastraAluno("126", "Anne Querubim", "Doceria");
		controle.alunoResponde("126");
		assertTrue(controle.getRespostas().size() == 2);
		assertTrue(controle.getRespostas().contains("126"));

		// Garante que um aluno pode responder mais de uma vez.
		controle.alunoResponde("125");
		assertTrue(controle.getRespostas().size() == 3);
	}

	@Test
	public void testImprimeRespondoes() {
		// Verifica o retorno quando nenhum aluno respondeu.
		assertEquals("Alunos:" + System.lineSeparator(), controle.imprimeRespondoes());

		// Verifica o retorno quando um aluno respondeu.
		controle.cadastraAluno("125", "Anne Arcanjo", "QueroDoce");
		controle.alunoResponde("125");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 125 - Anne Arcanjo - QueroDoce" + System.lineSeparator(),
				controle.imprimeRespondoes());

		// Verifica o retorno quando mais de um aluno respondeu.
		controle.cadastraAluno("126", "Hemi do pote", "BoloDePote");
		controle.alunoResponde("126");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 125 - Anne Arcanjo - QueroDoce" + System.lineSeparator()
				+ "2. 126 - Hemi do pote - BoloDePote" + System.lineSeparator(), controle.imprimeRespondoes());

		// Verifica o retorno quando um aluno responde mais de uma vez.
		controle.alunoResponde("125");
		assertEquals("Alunos:" + System.lineSeparator() + "1. 125 - Anne Arcanjo - QueroDoce" + System.lineSeparator()
				+ "2. 126 - Hemi do pote - BoloDePote" + System.lineSeparator() + "3. 125 - Anne Arcanjo - QueroDoce"
				+ System.lineSeparator(), controle.imprimeRespondoes());

	}

	@Test(expected = NullPointerException.class)
	public void cadastraAlunoMatriculaNula() {
		controle.cadastraAluno(null, "Picles", "CC");
	}

	@Test(expected = NullPointerException.class)
	public void cadastraAlunoNomeNulo() {
		controle.cadastraAluno("153", null, "CC");
	}

	@Test(expected = NullPointerException.class)
	public void cadastraAlunoCursoNulo() {
		controle.cadastraAluno("136", "Picles", null);
	}

	@Test(expected = NullPointerException.class)
	public void consultaAlunoMatriculaNula() {
		controle.consultaAluno(null);
	}

	@Test(expected = NullPointerException.class)
	public void cadastraGrupoNulo() {
		controle.cadastraGrupo(null);
	}

	@Test(expected = NullPointerException.class)
	public void alocaAlunoMatriculaNula() {
		controle.alocaAluno(null, "gente que nao fecha o lab");
	}

	@Test(expected = NullPointerException.class)
	public void alocaAlunoGrupoNulo() {
		controle.alocaAluno("232543", null);
	}

	@Test(expected = NullPointerException.class)
	public void imprimeGrupoNulo() {
		controle.imprimeGrupo(null);
	}

	@Test(expected = NullPointerException.class)
	public void alunoRespondeMatriculaNula() {
		controle.alunoResponde(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraAlunoMatriculaInvalida() {
		controle.cadastraAluno("", "Hemi", "computasao");
		controle.cadastraAluno("       ", "Hemi", "computasao");

	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraAlunoNomeInvalido() {
		controle.cadastraAluno("145", "", "computasao");
		controle.cadastraAluno("145", "    ", "computasao");

	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraAlunoCursoInvalido() {
		controle.cadastraAluno("132", "Hemi", "");
		controle.cadastraAluno("132", "Hemi", "       ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void consultaAlunoMatriculaInvalida() {
		controle.consultaAluno("");
		controle.consultaAluno("     ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastraGrupoInvalido() {
		controle.cadastraGrupo("");
		controle.cadastraGrupo("      ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void alocaAlunoMatriculaInvalida() {
		controle.alocaAluno("", "gente que nao fecha o lab");
		controle.alocaAluno("    ", "gente que nao fecha o lab");
	}

	@Test(expected = IllegalArgumentException.class)
	public void alocaAlunoGrupoInvalido() {
		controle.alocaAluno("232543", "");
		controle.alocaAluno("232543", "    ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void imprimeGrupoInvalido() {
		controle.imprimeGrupo("");
		controle.imprimeGrupo("    ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void alunoRespondeMatriculaInvalida() {
		controle.alunoResponde("");
		controle.alunoResponde("    ");
	}

}
