package com.mindata.blockchain.core.sqlparser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.common.CommonUtil;
import com.mindata.blockchain.core.model.MessageEntity;
import com.mindata.blockchain.core.model.UserEntity;
import com.mindata.blockchain.core.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserSqlParser extends AbstractSqlParser<UserEntity> {

    @Resource
    UserRepository userRepository;

    @Override
    public  void parse(byte operation, String id, UserEntity entity) {
      //  id = String.valueOf(entity.getId()) ;
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(entity.toString()+"------------------------------------------------------------");
        if (Operation.ADD == operation) {
            entity.setCreateTime(CommonUtil.getNow());
            userRepository.save(entity);
        } else if (Operation.DELETE == operation) {
           // userRepository.deleteByMessageId(messageId);
        } else if (Operation.UPDATE == operation) {
            UserEntity userEntity = userRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, userEntity, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            userRepository.save(userEntity);
        }
    }

    @Override
    Class getEntityClass() {
        return UserEntity.class;
    }


}
