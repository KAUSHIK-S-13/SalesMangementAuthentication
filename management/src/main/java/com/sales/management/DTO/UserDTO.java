package com.sales.management.DTO;


import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class UserDTO {

    private int userId;

    private String name;

    private String password;

    private int isActive;

    private int isDelete;


}
