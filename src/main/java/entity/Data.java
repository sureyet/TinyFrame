package entity;

//这里定义数据库中表的实体类，类中的属性与表的字段一一对应
public class Data {
    private int id;
    private int column1;
    private String column2;

    public void setId(int id) {
        this.id = id;
    }

    public void setColumn1(int column1) {
        this.column1 = column1;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public int getId() {
        return id;
    }

    public int getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }
}
