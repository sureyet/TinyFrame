package servlet;

import dao.DaoFactory;
import dao.DataDao;
import entity.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name="deleteServlet",urlPatterns = {"/deleteServlet"})
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String s=request.getParameter("id");
        int id = Integer.parseInt(s);
        String table=request.getParameter("table");
        Data data = new Data();
        data.setId(id);
        //三层架构，获取dao层
        DataDao dataDao = DaoFactory.getInstance().getDataDao();
        dataDao.deleteData(data);

    }
}

