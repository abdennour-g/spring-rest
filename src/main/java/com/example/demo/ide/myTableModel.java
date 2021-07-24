package com.example.demo.ide;


import java.sql.SQLException;
import java.util.List;

import com.example.demo.models.User;


public class myTableModel extends myFatherTableModel {
   public myTableModel() {}

public myTableModel( String[] tHead, List<User> pers ) {
    super( tHead, convert( pers ) );
}



private static Object[][] convert(List<User> pers ) {
    Object[][] o = new Object[pers.size()][4];
    int j = 0;
    for ( User p : pers )
        o[j++] = new Object[] { p.getId()+"", p.getUsername(),  p.getEmail() ,p.getPassword()};
    return o;
}


public myTableModel( String[] tHead, Object[][] tBody ) throws SQLException {
    super( tHead, tBody );
}


}
