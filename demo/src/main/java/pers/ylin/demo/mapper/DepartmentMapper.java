package pers.ylin.demo.mapper;

import org.apache.ibatis.annotations.*;
import pers.ylin.demo.entity.BorrowingLog;
import pers.ylin.demo.entity.Department;

import java.util.List;

/**
 * Created by Ylin on 2018/9/4
 */
public interface DepartmentMapper {
    @Select("SELECT * FROM department")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "companyCode",  column = "company_code"),
            @Result(property = "pid",  column = "pid"),
            @Result(property = "name",  column = "name"),
            @Result(property = "type",  column = "type"),
            @Result(property = "code",  column = "code"),
            @Result(property = "level",  column = "level"),
            @Result(property = "status",  column = "status"),
            @Result(property = "remark",  column = "remark"),
            @Result(property = "operator",  column = "operator"),
            @Result(property = "operateTime",  column = "operate_time"),
            @Result(property = "field", column = "field")
    })
    List<Department> getAll();

    @Select("SELECT * FROM department WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "companyCode",  column = "company_code"),
            @Result(property = "pid",  column = "pid"),
            @Result(property = "name",  column = "name"),
            @Result(property = "type",  column = "type"),
            @Result(property = "code",  column = "code"),
            @Result(property = "level",  column = "level"),
            @Result(property = "status",  column = "status"),
            @Result(property = "remark",  column = "remark"),
            @Result(property = "operator",  column = "operator"),
            @Result(property = "operateTime",  column = "operate_time"),
            @Result(property = "field", column = "field")
    })
    Department getOne(String id);

    @Insert("INSERT INTO department(id,company_code,name,type,code,level) VALUES(UUID(),#{companyCode}, #{name}, #{type}, #{code}, #{level})")
    void insert(Department department);

    @Update("UPDATE department SET company_code=#{companyCode} WHERE id =#{id}")
    void update(Department department);

    @Delete("DELETE FROM department WHERE id =#{id}")
    void delete(String id);
    
}
