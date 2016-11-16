package sistema.devgo.java;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sibele
 */
public class Venda {

    private long codVenda;
    private long codPlano;
    private long codCliente;
    private long codFuncionario;
    private int quantidadeAluno;
    private double valorVenda;
    private Date dataVenda;

    public Venda() {

    }

    public Venda(long codVenda, long codPlano, long codCliente, long codFuncionario, int quantidadeAluno, double valorVenda, Date dataVenda) {
        this.codCliente = codCliente;
        this.codPlano = codPlano;
        this.codCliente = codCliente;
        this.codFuncionario = codFuncionario;
        this.quantidadeAluno = quantidadeAluno;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;

    }

    public Venda(long codPlano, long codCliente, long codFuncionario, int quantidadeAluno, double valorVenda, Date dataVenda) {
        this.codPlano = codPlano;
        this.codCliente = codCliente;
        this.codFuncionario = codFuncionario;
        this.quantidadeAluno = quantidadeAluno;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;

    }

    /**
     * @return the codVenda
     */
    public long getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(long codVenda) {
        this.codVenda = codVenda;
    }

    /**
     * @return the codPlano
     */
    public long getCodPlano() {
        return codPlano;
    }

    /**
     * @param codPlano the codPlano to set
     */
    public void setCodPlano(long codPlano) {
        this.codPlano = codPlano;
    }

    /**
     * @return the codCliente
     */
    public long getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the codFuncionario
     */
    public long getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    /**
     * @return the quantidadeAluno
     */
    public int getQuantidadeAluno() {
        return quantidadeAluno;
    }

    /**
     * @param quantidadeAluno the quantidadeAluno to set
     */
    public void setQuantidadeAluno(int quantidadeAluno) {
        this.quantidadeAluno = quantidadeAluno;
    }

    /**
     * @return the valorVenda
     */
    public double getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }


}
