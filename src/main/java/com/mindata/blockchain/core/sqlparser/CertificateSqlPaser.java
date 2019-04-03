package com.mindata.blockchain.core.sqlparser;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.model.CertificateApplyData;
import com.mindata.blockchain.core.model.UserEntity;
import com.mindata.blockchain.core.repository.CertificateRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CertificateSqlPaser extends AbstractSqlParser<CertificateApplyData> {

    @Resource
    CertificateRepository certificateRepository;

    @Override
    void parse(byte operation, String id, CertificateApplyData entity) {
        if (Operation.ADD == operation) {
            //  entity.setCreateTime(CommonUtil.getNow());
            certificateRepository.save(entity);
        } else if (Operation.DELETE == operation) {
             certificateRepository.delete(entity.getId());
        } else if (Operation.UPDATE == operation) {
            CertificateApplyData certificateApplyData = certificateRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, certificateApplyData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            certificateRepository.save(certificateApplyData);
        }
    }

    @Override
    Class getEntityClass() {
        return CertificateApplyData.class;
    }
}
