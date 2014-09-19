package modelo;

public class Aluno {
	
	private int matricula;
	
	private String nome;
	
	public Aluno(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Aluno() {
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		if (matricula > 0)
		    this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if !(nome.isEmpty()){
		    this.nome = nome;
		}
	}

	

}
