package com.example.acrm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/*
Post 1 ----- id:- 1
User 1 ----- id:- 1

------------------------
id | blog_id | user_id |
------------------------
1  |  1      |  1      |
------------------------
2  |  1      |  1      |
------------------------

*/

@Entity
@Table(
    name="blog_like",
    uniqueConstraints=@UniqueConstraint(
        columnNames={
            "user_id",
            "blog_id"
        }
    )
)
public class BlogLike {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}