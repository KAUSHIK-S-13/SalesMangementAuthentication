package com.sales.management.Service;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.DTO.TokenDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.User;

import java.util.Optional;

public interface UserInterface {

    User addUserdetail(UserDTO userDTO);

    APIResponse<User> GetUserWithPagination(int offset, int pageSize, String name);

    Optional<User> updateUser(UserDTO userDTO);

    Optional<User> FindByUserId(int id);

    Optional<User> deletesoft(UserDTO userDTO);

     Object Jwt(TokenDTO tokenDTO);
}
