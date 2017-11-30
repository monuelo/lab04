package lab04.util;

public class Testes {

	public static void verificaVazio(String tipo, String nome) {
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException(tipo + " Vazio(a)");
		}
	}

	public static void verificaNulo(String tipo, String nome) {
		if (nome == null) {
			throw new NullPointerException(tipo + " Nulo(a)");
		}
	}
}
