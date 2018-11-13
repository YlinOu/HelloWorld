package pers.ylin.demo.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ylin.demo.entity.Department;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ylin on 2018/9/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() {
        List<Department> departmentList = departmentMapper.getAll();
        departmentList.forEach(System.out::println);
    }

    @Test
    public void getOne() {
        System.out.println(departmentMapper.getOne("8ad1ae2061c796350161f97f3686079b"));
    }

    @Test
    public void insert() {
        Department department = new Department();
        department.setCode("oooooooo_wM6Herwq_p0ntVhOu_qkwjenq");
        department.setCompanyCode("001");
        department.setCompanyCode("test");
        department.setType(1);
        department.setLevel(12);
        departmentMapper.insert(department);

    }

    @Test
    public void update() {
        Department department = new Department();
        department.setId("6ad66e1b-b0d8-11e8-9d24-00163e0e43fb");
        department.setCompanyCode("002");
        departmentMapper.update(department);
    }

    @Test
    public void delete() {
        departmentMapper.delete("6ad66e1b-b0d8-11e8-9d24-00163e0e43fb");
    }
}