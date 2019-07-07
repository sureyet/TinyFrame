<%@ page import="jdk.nashorn.internal.runtime.regexp.joni.Config" %>
<%@ page import="dao.DaoFactory" %>
<%@ page import="entity.Data"%>
<%@ page import="dao.DataDao" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>TinyFrame</title>
        <link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css">
    </head>
    <body>

        <a>
            <center>
                This is tiny Framework which contains a complete Background system that can connect the
                database and a index page.
            </center>
        </a>

        <div class="row">

        <div class="col-md-1"></div>

        <div class="col-md-1">
            <div class="row">
                <ul class="nav nav-pills nav-stacked ">
                    <Br><Br>
                    <li><a href="#table1" data-toggle="tab"><h3>表1</h3></a></li>
                    <li><a href="#table1" data-toggle="tab"><h3>表2</h3></a></li>
                    <li><a href="#table1" data-toggle="tab"><h3>表3</h3></a></li>
                    <li><a href="#table1" data-toggle="tab"><h3>表4</h3></a></li>
                </ul>
            </div>
        </div>

        <div class="col-md-1"></div>

        <div class="col-md-6">
            <div class="container well">
                <div class="box">

                    <div class="box-header">

                    </div><!--box-header end-->

                    <div class="box-table">

                        <div id="maincontent" class="span7 ">
                            <div id="myTabContent" class="tab-content">

                                    <div class="modal-header">
                                        <h3>
                                            <center>
                                                表1
                                            </center>
                                        </h3>
                                    </div>
                                    <a href="#"><h4>添加成员</h4></a>

                                    <%
                                      try{
                                        DataDao dataDao = DaoFactory.getInstance().getDataDao();
                                        List list = dataDao.findAll();
                                    %>
                                    <table class="table table-bordered" style="text-align: center" >
                                        <tr><td><strong>ID</strong></td>
                                            <td><strong>列1</strong></td>
                                            <td><strong>列2</strong></td>
                                            <td><strong>操作</strong></td>
                                        </tr>
                                        <%for(int i=0;i<list.size();i++){ %>
                                        <% Data data = (Data)list.get(i);

                                            System.out.println(data);
                                        %>
                                        <tr>
                                            <td>
                                                <% out.print(data.getId());%>
                                            </td>
                                            <td>
                                                <%out.print(data.getColumn1());%>
                                            </td>
                                            <td>
                                                <%out.print(data.getColumn2());
                                                    %>
                                            </td>

                                            <td>
                                                <a href="deleteServlet?id=<%out.print(data.getId());%>&table=sample">删除</a>
                                            </td>
                                        </tr>
                                        <%}%>
                                    </table>
                                    <%
                                    }catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }%>


                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--box end-->
            </div>
        </div>
    </div>

</body>
</html>
