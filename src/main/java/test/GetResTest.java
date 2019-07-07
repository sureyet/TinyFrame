package test;



import servlet.Test;

import java.io.InputStream;

public class GetResTest {
    public static void main(String []args){
        InputStream inputStream = GetResTest.class.getResourceAsStream("daoconfig.properties");
        if(inputStream==null)
            System.out.println("inputstream为null");
        System.out.println(GetResTest.class.getResource(""));
        System.out.println(GetResTest.class.getResource("/"));
    }
}
