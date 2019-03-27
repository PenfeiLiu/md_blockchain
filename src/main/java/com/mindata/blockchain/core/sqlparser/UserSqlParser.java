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
@Service
public class UserSqlParser extends AbstractSqlParser<UserEntity> {

    @Resource
    UserRepository userRepository;

    @Override
    public  void parse(byte operation, String id, UserEntity entity) {
       System.out.println(entity.toString()+"------------------------------------------------------------");
        if (Operation.ADD == operation) {
          //  entity.setCreateTime(CommonUtil.getNow());
            userRepository.save(entity);
        } else if (Operation.DELETE == operation) {
           // userRepository.deleteByMessageId(messageId);
        } else if (Operation.UPDATE == operation) {
        /*    UserEntity messageEntity = userRepository.findByMessageId(messageId);
            BeanUtil.copyProperties(entity, messageEntity, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("id", "createTime"));
            userRepository.save(messageEntity);*/
        }
    }

    @Override
    Class getEntityClass() {
        return UserEntity.class;
    }


}
