package com.mindata.blockchain.core.repository;

import com.mindata.blockchain.core.model.MessageEntity;
import com.mindata.blockchain.core.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface UserRepository extends BaseRepository<UserEntity>{



}
