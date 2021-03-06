<%-- 
    Document   : BuscaPlano
    Created on : 03/12/2016, 15:16:25
    Author     : natan
--%>


<%@page import="sistema.devgo.java.Plano"%>
<%@page import="sistema.devgo.Model.dao.PlanoDAO"%>
<%@page import="java.util.List"%>
<%@page import="sistema.devgo.java.Livro"%>
<%@page import="sistema.devgo.Model.dao.LivroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
        <title>Buscar Plano</title>
        <c:url value="CSS/buscaPlano.css" var="EditarProduto"/>
        <link type="text/css" rel="stylesheet" href="${EditarProduto}"/>
        <script type="text/javascript" src="SCRIPT/funcoes.js"></script>
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
                    <li><a href="RelatorioCliente">Relatorios</a></li>
                    <li><a href="BuscaCNPJvenda">Vendas</a></li>
                </ul>
            </div>
        </header>
        <aside>
            <ul>
                <li><a href="CadastroProduto">Cadastrar Produto</a></li>
                <li><a href="CadastroPlano">Cadastrar Plano</a></li>
                <li><a href="BuscaProduto">Editar Produto</a></li>
                <li><a href="BuscaPlano">Editar Plano</a></li>
            </ul>
        </aside>
        <input type="hidden" id="departamento" value="<c:out value="${departamento}"/>" />
        <input type="hidden" id="mens" value="<c:out value="${msgm}"/>" />
        <input type="hidden" id="act" value="editado" />
        <input type="hidden" id="req" value="Plano" />
        <div id="mensagem"></div>
        <c:url value="BuscaPlano" var="BuscaPlano"/>
        <form action="${BuscaPlano}" method="post" enctype="application/x-www-form-urlencoded">
            <fieldset id="dados">
                <h4>Empresa</h4>
                <div id="topo">
                   
                    <p> Selecione um Plano: <select name="opcaoPlano">
                             
                                <%
                                    PlanoDAO dao = new PlanoDAO (); 
                                    List<Plano> planos = dao.findPlano();
                                    for (Plano plano : planos) {
                                %>
                                <option value="<%=plano.getCod_plano()%>"><%=plano.getNomePlano()%></option>
                                <%}%>
                            </select></p> 
                            <input id="Buscar" title="Buscar" value="Buscar" type="submit"></p>
                </div>
            </fieldset>
        </form>
    </body>
</html>

