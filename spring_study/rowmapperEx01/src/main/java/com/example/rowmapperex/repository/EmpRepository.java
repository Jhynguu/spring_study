package com.example.rowmapperex.repository;

import com.example.rowmapperex.dto.Emp;
import com.example.rowmapperex.rowmapper.EmpRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmpRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Emp> findAllusers() {
        String sql = "select ename, job, empno from emp";

        return jdbcTemplate.query(sql, new EmpRowMapper());
    }

    public Emp findUserByDeptno(int empno) {
        String sql = "select ename, job, empno from emp where empno = ?";

        return jdbcTemplate.queryForObject(sql, new EmpRowMapper(), empno);
    }
}
