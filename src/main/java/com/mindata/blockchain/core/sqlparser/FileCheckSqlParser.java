package com.mindata.blockchain.core.sqlparser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.model.CertificateApplyData;
import com.mindata.blockchain.core.model.FileCheckData;
import com.mindata.blockchain.core.repository.FileCheckRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FileCheckSqlParser extends AbstractSqlParser<FileCheckData> {

    @Resource
    FileCheckRepository fileCheckRepository;

    @Override
    void parse(byte operation, String id, FileCheckData entity) {
        if (Operation.ADD == operation) {
            //  entity.setCreateTime(CommonUtil.getNow());
            fileCheckRepository.save(entity);
        } else if (Operation.DELETE == operation) {
            fileCheckRepository.delete(entity.getId());
        } else if (Operation.UPDATE == operation) {
           FileCheckData fileCheckData = fileCheckRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, fileCheckData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            fileCheckRepository.save(fileCheckData);
        }
    }

    @Override
    Class getEntityClass() {
        return FileCheckData.class;
    }
}
