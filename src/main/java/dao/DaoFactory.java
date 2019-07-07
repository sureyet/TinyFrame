package dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    private static DataDao dataDao = null;
    private static DaoFactory daoFactory = new DaoFactory();
    private DaoFactory(){
        try{
            Properties prop = new Properties();
            InputStream inputStream = DaoFactory.class.getResourceAsStream("daoconfig.properties");
            prop.load(inputStream);
            //从配置文件中读取UserDao的实现类全类名
            String dataDaoClass = prop.getProperty("DataDao");
            //注意：这里forName的参数必须给出全路径（要加上包名）
            Class dataDaoImplClazz = Class.forName(dataDaoClass);
            //反射创建对象
            dataDao = (DataDao) dataDaoImplClazz.newInstance();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    public DataDao getDataDao() {
        return dataDao;
    }
}
