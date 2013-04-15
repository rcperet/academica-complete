package visao;

import java.util.List;

import modelo.Aluno;
import modelo.persistencia.AlunoDAO;

public class Principal {

	public static void main(String[] args) {
		
		AlunoDAO alunoDAO = new AlunoDAO();
//		Aluno aluno = new Aluno(123, "jose");
//		alunoDAO.incluir(aluno);
//		
//		aluno =  new Aluno(456, "ana");
//		alunoDAO.incluir(aluno);
		List<Aluno> lista = alunoDAO.listarTodos();
		for(Aluno al : lista){
			System.out.println(al.getNome() + " " + al.getMatricula()); 
		}
		
		
		
	}
	
}











