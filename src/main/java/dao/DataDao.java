package dao;

import entity.Data;

import java.util.List;

public interface DataDao {
    int addData(Data data);
    int deleteData(Data data);
    int updateData(Data data);
    Data getData(int id);
    Data findData(int col_1,String col_2);
    List findAll();
}
