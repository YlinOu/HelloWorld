package pers.ylin.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ylin on 2018/9/5
 */
@Entity
@Data
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "pid")
    private String pid;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Column(name = "code")
    private String code;
    @Column(name = "level")
    private Integer level;
    @Column(name = "status")
    private Integer status;
    @Column(name = "remark")
    private String remark;
    @Column(name = "operator")
    private String operator;
    @Column(name = "operate_time")
    private Date operateTime;
    @Column(name = "field")
    private String field;

}
