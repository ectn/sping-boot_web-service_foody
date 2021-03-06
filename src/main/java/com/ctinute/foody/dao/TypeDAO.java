package com.ctinute.foody.dao;

import com.ctinute.foody.models.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO extends DAO {

    private static final String TABLE_NAME = "type";

    public TypeDAO() {
        super();
    }

    private List<Type> getTypes(String query){
        List<Type> types = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                Type Type = new Type();
                Type.setId(rs.getInt("ID"));
                Type.setName(rs.getString("NAME"));
                Type.setImage(rs.getString("IMG"));
                Type.setNew(rs.getBoolean("ISNEW"));
                types.add(Type);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return types;
    }

    public List<Type> getAllType(){
        String query = "select * from "+TABLE_NAME;
        return getTypes(query);
    }

}
