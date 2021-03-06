package sistema.devgo.Model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.devgo.java.Funcionario;

/**
 *
 * @author Natanael
 */
public class FuncionarioDAO extends GenericaDAO {

    public void insert(Funcionario funcionario) throws SQLException {
        String insert = "INSERT INTO FUNCIONARIO (cod_depto,nome,sobrenome,telefone,cpf,"
                + "status,dt_nascimento) VALUES(?,?,?,?,?,?,?)";
        insert(insert, funcionario.getCodDepartamento(), funcionario.getNome(), funcionario.getSobrenome(),
                funcionario.getTelefone(), funcionario.getCpf(), funcionario.getStatus(),
                funcionario.getDtNascimento());
    }

    public void update(Funcionario funcionario) throws SQLException {
        String update = "UPDATE FUNCIONARIO "
                + "SET COD_DEPTO = ?, NOME = ?, SOBRENOME = ?, CPF = ?, STATUS = ?, TELEFONE = ?, "
                + "DT_NASCIMENTO= ? WHERE COD_FUNCIONARIO = ?";
        update(update,funcionario.getCodFuncionario(),funcionario.getCodDepartamento(), funcionario.getNome(), funcionario.getSobrenome(),
                funcionario.getCpf(),funcionario.getStatus(), funcionario.getTelefone(), 
                funcionario.getDtNascimento());
    }

    public List<Funcionario> findFuncionario() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        String select = "SELECT * FROM FUNCIONARIO";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodDepartamento(rs.getLong("cod_depto"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSobrenome(rs.getString("sobrenome"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setStatus(rs.getString("status"));
            funcionario.setDtNascimento(rs.getDate("dt_nascimento"));
            funcionario.setCodFuncionario(rs.getLong("cod_funcionario"));
            funcionarios.add(funcionario);
        }

        rs.close();
        stmt.close();

        return funcionarios;
    }

    public Funcionario findByCPF(String cpf) throws SQLException {
        String select = "SELECT * FROM FUNCIONARIO WHERE cpf ='"+cpf+"'";
        Funcionario funcionario = null;
       
        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setCodDepartamento(rs.getLong("cod_depto"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSobrenome(rs.getString("sobrenome"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setStatus(rs.getString("status"));
            funcionario.setDtNascimento(rs.getDate("dt_nascimento"));
            funcionario.setCodFuncionario(rs.getLong("cod_funcionario"));
        
        }

        rs.close();
        stmt.close();
        return funcionario;
    }
    
      public List<Funcionario> findFuncionarioDep() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        String select = "SELECT a.*,b.SETOR FROM FUNCIONARIO a INNER JOIN departamento b ON (a.COD_DEPTO = b.COD_DEPTO)";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodDepartamento(rs.getLong("cod_depto"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSobrenome(rs.getString("sobrenome"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setStatus(rs.getString("status"));
            funcionario.setDtNascimento(rs.getDate("dt_nascimento"));
            funcionario.setCodFuncionario(rs.getLong("cod_funcionario"));
            funcionario.setDepartamento(rs.getString("SETOR"));
            funcionarios.add(funcionario);
        }

        rs.close();
        stmt.close();

        return funcionarios;
    }

}
