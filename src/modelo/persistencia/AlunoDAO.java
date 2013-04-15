package modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;

public class AlunoDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public AlunoDAO() {
		con = new Conexao().getConection();
	}
	
	
	public boolean incluir(Aluno aluno){
		//comando sql enviada para o banco
		String sql = "insert into aluno (matricula, nome) values (?, ?) ";
		try {
			//prepara um comando com prepareStatement a partir de uma conex‹o
			pstm = con.prepareStatement(sql);
			
			//passa os parametros unindo cada caracter especial(?) com o seu indice de 
			//aparecimento na sql
			pstm.setString(2, aluno.getNome());
			pstm.setInt(1, aluno.getMatricula());

			//aqui est‡ executando o comando e retornando a quantidade de registros afetados 
			int result = pstm.executeUpdate();
			
			//true se afetou um ou mais registros
			return result > 0;
		} catch (Exception e) {
			System.out.println("Erro ao incluir aluno " + e.getMessage()); 
			return false;
		}
	}
	
	public boolean deletar(int matricula){
		try {
			String sql = "delete from aluno where matricula = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, matricula);
			int result = pstm.executeUpdate();
			return result > 0;
		} catch (Exception e) {
			System.out.println("erro ao deletar "+ e.getMessage()); 
		}
		return false;
	}
	
	public boolean alterar(Aluno aluno){
				String sql = "update aluno set nome=? where matricula = ? ";
				try {
					pstm = con.prepareStatement(sql);

					pstm.setString(1, aluno.getNome());
					pstm.setInt(2, aluno.getMatricula());

					int result = pstm.executeUpdate();
					return result > 0;
				} catch (Exception e) {
					System.out.println("Erro ao alterar aluno " + e.getMessage()); 
					return false;
				}
	}
	
	public List<Aluno> listarTodos(){
		List<Aluno> lista = new ArrayList<Aluno>();
		String sql = "select * from aluno";
		try {
			pstm = con.prepareStatement(sql);
			rs =  pstm.executeQuery();
			while(rs.next()){
				Aluno aluno = new Aluno();
				aluno.setMatricula(  rs.getInt("matricula")  );
				aluno.setNome(  rs.getString("nome")  ); 
				lista.add(aluno);
			}
		} catch (Exception e) {
			System.out.println("erro ao consultar um aluno "+ e.getMessage());
		}
		return lista;
	}
	
	public Aluno getAlunoByMatricula(int matricula){
		Aluno aluno = null;
		String sql = "select * from aluno where matricula = ?";
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, matricula);
			
			rs =  pstm.executeQuery();
			while(rs.next()){
				aluno = new Aluno();
				aluno.setMatricula(  rs.getInt("matricula")  );
				aluno.setNome(  rs.getString("nome")  ); 
			}
			
		} catch (Exception e) {
			System.out.println("erro ao consultar um aluno "+ e.getMessage());
		}
		
		return aluno;
	}
	

}





