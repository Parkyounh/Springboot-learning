package edu.du.mybatis0916.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Integer id;
    private String title;
    private String content;
    private Date createdAt;


}
