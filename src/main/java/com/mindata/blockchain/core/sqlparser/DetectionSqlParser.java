package com.mindata.blockchain.core.sqlparser;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.model.DetectionData;
import com.mindata.blockchain.core.model.FileCheckData;
import com.mindata.blockchain.core.repository.DetectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DetectionSqlParser extends AbstractSqlParser<DetectionData>{

    @Resource
    DetectionRepository detectionRepository;


    @Override
    void parse(byte operation, String id, DetectionData entity) {
        if (Operation.ADD == operation) {
            //  entity.setCreateTime(CommonUtil.getNow());
            detectionRepository.save(entity);
        } else if (Operation.DELETE == operation) {
            detectionRepository.delete(entity.getId());
        } else if (Operation.UPDATE == operation) {
            DetectionData detectionData = detectionRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, detectionData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            detectionRepository.save(detectionData);
        }
    }

    @Override
    Class getEntityClass() {
        return DetectionData.class;
    }
}
