package com.mindata.blockchain.core.manager;

import com.mindata.blockchain.core.model.UserEntity;
import com.mindata.blockchain.core.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserManager {
    @Resource
    private UserRepository userRepository;
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    public UserEntity findOne(Example<UserEntity> example){
        return userRepository.findOne(example);
    }
    public UserEntity findOne(Long id){
        return userRepository.findOne(id);
    }
}
