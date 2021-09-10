package com.sales.management.ServiceImpl;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.DTO.TokenDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.User;
import com.sales.management.Repository.UserRepository;
import com.sales.management.Service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.sales.management.Util.JwtUtil.generateToken;


@Service
@Transactional

public class UserServiceImpl implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUserdetail(UserDTO userDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(bcrypt.encode(userDTO.getPassword()));
        userRepository.save(user);
        return user;
    }


    @Override
    public APIResponse<User> GetUserWithPagination(int offset, int pageSize, String name) {
        Pageable paging = PageRequest.of(offset, pageSize);
        Page<User> Users = userRepository.searchAllByNameLike("%" + name + "%", paging);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponse(Users);
        apiResponse.setRecordCount(Users.getTotalPages());
        return apiResponse;
    }

    @Override
    public Optional<User> updateUser(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        if (existUser.isPresent()) {
            existUser.get().setName(userDTO.getName());
            existUser.get().setPassword(userDTO.getPassword());
            userRepository.save(existUser.get());
        } else {
            throw new RuntimeException("not found");
        }
        return existUser;
    }

    @Override
    public Optional<User> FindByUserId(int id) {
        Optional<User> users = userRepository.findById(id);
        return users;
    }

    @Override
    public Optional<User> deletesoft(UserDTO userDTO) {
        Optional<User> existUser = userRepository.findById(userDTO.getUserId());
        if (existUser.isPresent()) {
            existUser.get().setIsDelete(1);
            userRepository.save(existUser.get());
        } else {
            throw new RuntimeException("not found");
        }
        return existUser;
    }

    @Override
    public TokenDTO Jwt(TokenDTO tokenDTO) {
        Optional<User> users = userRepository.findByName(tokenDTO.getName());
        try {
            if (users.isPresent()) {
                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                boolean chek = bcrypt.matches(tokenDTO.getPassword(), users.get().getPassword());
                if (chek == true) {
                    String jwtt = generateToken(users.get().getUserId(), "üser", users.get().getName());
                    tokenDTO.setToken(jwtt);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenDTO;
    }

    public UserDetails loadByUserId(String userId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(userId);
        Optional<User> opt = Optional.ofNullable(user).orElseThrow(
                        () -> new UsernameNotFoundException("useridnot found"))
                .map(UserDetailImp::new);
        if (opt.isPresent()) {
            return (UserDetails) opt.get();
        }
        return null;


    }
}
