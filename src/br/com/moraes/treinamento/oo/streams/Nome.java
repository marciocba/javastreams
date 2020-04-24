package br.com.moraes.treinamento.oo.streams;

public class Nome {
	
	private String nome;
	
	private int frequencia;
	
	public Nome() {
		
	}
	
	public Nome(String n, int f) {
		setNome(n);
		setFrequencia(f);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	public String toString() {
		return nome+"("+frequencia+")";
	}
}
