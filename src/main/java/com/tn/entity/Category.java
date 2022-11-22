package com.tn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JsonIgnore
        List<Article> articles;

        @Column(name = "category_name")
        private String categoryName;

        private String description;


    }

