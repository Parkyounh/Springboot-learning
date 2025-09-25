package com.du.test0925.domain;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String phone;
    private Date addDate;
}
