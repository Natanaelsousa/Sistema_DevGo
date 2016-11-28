<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html> 
<%@ page import="sistema.devgo.java.Cliente" %>
<%@ page import="sistema.devgo.Model.dao.ClienteDAO" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/listaClientes.css" type="text/css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="SCRIPT/funcoes.js"></script>
      
        <title>Clientes Cadastrados</title>
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="<c:url value="/IMG/DevGo.png"/>" />
            </div>
            <div class="logout">
                <h3><a href="#">Sair</a></h3>
            </div>
            <div class="bar">
                <ul>
                    <li class="dropdown">
                        <a href="#" class="btn">Cadastros</a>
                        <div class="dropdown-content">
                            <a href="CadastroCliente">Cliente</a>
                            <a href="CadastroFuncionario">Funcionario</a>
                        </div>
                    </li>
                    <li><a href="CadastroProduto">Produtos e Serviços</a><li>
                    <li><a href="Relatorio">Relatorios</a></li>
                    <li><a href="BuscaCNPJvenda">Vendas</a></li>
                </ul>
            </div>
        </header>
        <aside>
            <ul>
                <li><a href="#">Listar Clientes</a></li>
                <li><a href="RelatorioFuncionario">Listar Funcionários</a></li>
            </ul>
        </aside>
        <%
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> userList = dao.findCliente();
            Iterator<Cliente> itr = userList.iterator();
            Cliente utilisateur = null;
        %>
        <form>
        <table id="exTable" class="table">
            <tr>
                <th>Id</th>
                <th>CNPJ</th>
                <th>Razao Social</th>
                <th>Cidade</th>
                <th>Telefone</th>
                <th>E-mail</th>

            </tr>
            <tr>
                <% 
                    while (itr.hasNext()) {
                        utilisateur = itr.next();
                %>
                <td><%= utilisateur.getCodCliente()%></td>
                <td><%= utilisateur.getCNPJ()%></td>
                <td><%= utilisateur.getRazaoSocial()%></td>
                <td><%= utilisateur.getCidade()%></td>
                <td><%= utilisateur.getTelefone1()%></td>
                <td><%= utilisateur.getEmail()%></td>
                
            </tr>
            <%
                }
            %>	
            
        </table>
        </form>
            <input type="button" value="Gerar Relatório" id="exportar" onclick="exportToExcel('exTable')"/>
    </body>
</html>
