package pers.ylin.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import pers.ylin.demo.entity.BorrowingLog;
import pers.ylin.demo.entity.Department;
import pers.ylin.demo.mapper.DepartmentMapper;
import pers.ylin.demo.repository.BorrowingLogRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by Ylin on 2018/9/5
 */
@RestController
@Slf4j
@Api(value = "Demo Value", description = "Demo description")
public class BorrowingLogController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BorrowingLogRepository borrowingLogRepository;
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping (value = "/api")
    @ApiOperation(value = "Get Hello World", notes = "Get Hello World Notes")
    public String helloWorld(@RequestParam(value = "word",defaultValue = "") String word) throws Exception {


        if (word.equals("io")) {
            throw new Exception("ex");
        }

        return (1/0)+"";
    }

    @PostMapping(value = "/demo/test")
    @ApiOperation(value = "Get Hello World2", notes = "Get Hello World2 Notes")
    public String helloWorld2(@RequestParam(value = "word",defaultValue = "") String word,
                              @RequestBody BorrowingLog borrowingLog,
                              @ApiIgnore @RequestHeader("token") String token) throws Exception {

        return "word:"+word+";token:"+token+";borrowingLog:"+borrowingLog;
    }

    @PostMapping(value = "/getAll")
    @ApiOperation(value = "getAll", notes = "getAll")
    public @ResponseBody List<BorrowingLog> getAll() {

        return borrowingLogRepository.findAll();
    }

    @PostMapping(value = "/getAllDept")
    @ApiOperation(value = "getAllDept", notes = "getAllDept")
    public @ResponseBody List<Department> getAllDept() {

        return departmentMapper.getAll();
    }

    @PostMapping(value = "/getDept")
    @ApiOperation(value = "getDept", notes = "getDept")
    public @ResponseBody Department getDept(@RequestParam("id") String id) {

        return departmentMapper.getOne(id);
    }


}
