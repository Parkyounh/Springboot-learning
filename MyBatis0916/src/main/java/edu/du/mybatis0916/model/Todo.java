package edu.du.mybatis0916.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private String title;
    private Boolean completed;
}
