package test;
import dao.*;
import entity.Data;

import java.util.List;

public class DaoFactoryTest {
    public static void main(String []args){

        DataDao dataDao = DaoFactory.getInstance().getDataDao();
        List list = dataDao.findAll();
        for(int i=0;i<list.size();i++){
            Data data = (Data)list.get(i);
            System.out.print(data.getId()+" "+data.getColumn1()+" "+data.getColumn2());
        }
    }
}
