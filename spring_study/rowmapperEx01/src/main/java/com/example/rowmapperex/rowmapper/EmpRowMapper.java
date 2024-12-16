package com.example.rowmapperex.rowmapper;

import com.example.rowmapperex.dto.Emp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<Emp> {
    @Override
    public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
        Emp emp = new Emp();
        emp.setEname(rs.getString("ename"));
        emp.setJob(rs.getString("job"));
        emp.setEmpno(rs.getInt("empno"));

        return emp;
    }
}
