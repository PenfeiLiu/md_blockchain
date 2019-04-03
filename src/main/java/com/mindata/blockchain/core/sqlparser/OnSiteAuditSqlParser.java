package com.mindata.blockchain.core.sqlparser;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.model.CertificationData;
import com.mindata.blockchain.core.model.OnSiteAuditData;
import com.mindata.blockchain.core.repository.OnSiteAuditRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OnSiteAuditSqlParser extends  AbstractSqlParser<OnSiteAuditData> {

    @Resource
    OnSiteAuditRepository onSiteAuditRepository;

    @Override
    void parse(byte operation, String id, OnSiteAuditData entity) {
        if (Operation.ADD == operation) {
            //  entity.setCreateTime(CommonUtil.getNow());
            onSiteAuditRepository.save(entity);
        } else if (Operation.DELETE == operation) {
            onSiteAuditRepository.delete(entity.getId());
        } else if (Operation.UPDATE == operation) {
            OnSiteAuditData onSiteAuditData = onSiteAuditRepository.findOne(entity.getId());
            BeanUtil.copyProperties(entity, onSiteAuditData, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("createTime"));
            onSiteAuditRepository.save(onSiteAuditData);
        }
    }

    @Override
    Class getEntityClass() {
        return OnSiteAuditData.class;
    }
}
