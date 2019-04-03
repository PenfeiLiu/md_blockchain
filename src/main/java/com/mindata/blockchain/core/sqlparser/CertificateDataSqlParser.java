package com.mindata.blockchain.core.sqlparser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.model.CertificateApplyData;
import com.mindata.blockchain.core.model.CertificationData;
import com.mindata.blockchain.core.repository.CertificateDataRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CertificateDataSqlParser extends AbstractSqlParser<CertificationData>{

    @Resource
    CertificateDataRepository certificateDataRepository;


    @Override
    void parse(byte operation, String id, CertificationData entity) {
        if (Operation.ADD == operation) {
            //  entity.setCreateTime(CommonUtil.getNow());
            certificateDataRepository.save(entity);
        } else if (Operation.DELETE == operation) {
            certificateDataRepository.delete(entity.getId());
        } else if (Operation.UPDATE == operation) {
           CertificationData certificationData = certificateDataRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, certificationData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            certificateDataRepository.save(certificationData);
        }
    }

    @Override
    Class getEntityClass() {
        return CertificationData.class;
    }
}
