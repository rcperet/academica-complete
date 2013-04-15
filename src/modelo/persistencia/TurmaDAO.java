package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import modelo.Turma;

public class TurmaDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public TurmaDAO() {
		con = new Conexao().getConection();
	}
	
	
	public boolean incluir(Turma Turma){
		//comando sql enviada para o banco
		String sql = "insert into Turma (matricula, nome) values (?, ?) ";
		try {
			//prepara um comando com prepareStatement a partir de uma conex‹o
			pstm = con.prepareStatement(sql);
			
			//passa os parametros unindo cada caracter especial(?) com o seu indice de 
			//aparecimento na sql
			pstm.setInt(1, Turma.getId());
			pstm.setString(2, Turma.getNome());

			//aqui est‡ executando o comando e retornando a quantidade de registros afetados 
			int result = pstm.executeUpdate();
			
			//true se afetou um ou mais registros
			return result > 0;
		} catch (Exception e) {
			System.out.println("Erro ao incluir Turma " + e.getMessage()); 
			return false;
		}
	}
	
	public boolean deletar(int id){
		return false;
	}
	
	public boolean alterar(Turma Turma){
		return false;
	}
	
	public List<Turma> listarTodos(){
		return null;
	}
	
	public Turma getTurmaById(int id){
		return null;
	}
	

}





