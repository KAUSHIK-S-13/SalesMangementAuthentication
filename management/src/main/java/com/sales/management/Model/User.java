package com.sales.management.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;


    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    @Column(name="user_name")
    private String name;

    @NotEmpty
    @Size(min = 5, message = "password should have at least 5 characters")
    @Column(name="password")
    private String password;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime updateDateTime;

    public User(User user) {
        this.name = name;
        this.password = password;
    }




   /*@OneToMany(mappedBy="users")
    private List<Order> order;*/

}
