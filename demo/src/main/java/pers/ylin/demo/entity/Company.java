package pers.ylin.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ylin on 2018/9/26
 */
@Data
@Document
public class Company implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String chinaName;
    private String engName;
    private Integer status;
    private String code;
    private String legPerson;
    private String address;
    private String city;
    private String phone;
    private String fax;
    private String contactPerson;
    private String operator;
    private Date operateTime;
    private String field;
    private String sequence;
    private Integer registerDay;
}
