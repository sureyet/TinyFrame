package dao;

import entity.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDaoImpl implements DataDao {

    MyJDBCTemplate jdbcTemplate = new MyJDBCTemplate();

    public int addData(Data data){
        String sql = "insert into sample(id, column1, column2) values (?,?,?) ";
        Object []args = new Object[]{data.getId(), data.getColumn1(), data.getColumn2()};
        //调用jdbcTemplate的update方法
        return jdbcTemplate.update(sql,args);
    }

    public int deleteData(Data data){
        String sql = "delete from sample where id=?";
        Object []args = new Object[]{data.getId()};
        return jdbcTemplate.update(sql, args);
    }

    public int updateData(Data data){
        String sql = "update sample set column1=？，column2=? where id=? ";
        Object []args = new Object[]{data.getColumn1(),data.getColumn2(),data.getId()};
        return jdbcTemplate.update(sql,args);
    }

    public Data getData(int id){
        String sql = "select * from sample where id =?";
        Object []args = new Object[]{id};
        List list = jdbcTemplate.query(sql, args, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Data data = new Data();
                data.setId(rs.getInt("id"));
                data.setColumn1(rs.getInt("column1"));
                data.setColumn2(rs.getString("column2"));
                return data;
            }
        });
        return (Data)list.get(0);
    }

    public Data findData(int col_1,String col_2){
        String sql= "select * from sample where column1=? and column2=?";
        Object []args = new Object[]{col_1,col_2};
        List list = jdbcTemplate.query(sql, args, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Data data = new Data();
                data.setId(rs.getInt("id"));
                data.setColumn1(rs.getInt("column1"));
                data.setColumn2(rs.getString("column2"));
                return data;
            }
        });
        return (Data)list.get(0);
    }

    public List findAll(){
        String sql = "select * from sample";
        Object []args = new Object[]{};
        List list= jdbcTemplate.query(sql, args, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                Data data = new Data();
                data.setId(rs.getInt("id"));
                data.setColumn1(rs.getInt("column1"));
                data.setColumn2(rs.getString("column2"));
                return data;
            }
        });
        return  list;
    }

}
