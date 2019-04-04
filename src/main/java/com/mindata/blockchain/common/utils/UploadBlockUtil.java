package com.mindata.blockchain.common.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.mindata.blockchain.block.Instruction;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.core.requestbody.BlockRequestBody;
import com.mindata.blockchain.core.requestbody.InstructionBody;
import com.mindata.blockchain.core.service.BlockService;
import com.mindata.blockchain.core.service.InstructionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UploadBlockUtil {

    @Value("${publicKey:A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54}")
    private  String publicKey;
    @Value("${privateKey:yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=}")
    private  String privateKey;

    @Resource
    private  InstructionService instructionService;

    @Resource
    private  BlockService blockService;

    public void uploadBlock(String json,byte operation,String tableName){

        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(operation);
        instructionBody.setTable(tableName);
        instructionBody.setJson(json);
        instructionBody.setPublicKey(publicKey);
        instructionBody.setPrivateKey(privateKey);
        Instruction instruction = null;
        try {
            instruction = instructionService.build(instructionBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BlockRequestBody blockRequestBody = new BlockRequestBody();
        blockRequestBody.setPublicKey(instructionBody.getPublicKey());
        com.mindata.blockchain.block.BlockBody blockBody = new com.mindata.blockchain.block.BlockBody();
        blockBody.setInstructions(CollectionUtil.newArrayList(instruction));

        blockRequestBody.setBlockBody(blockBody);
        blockService.addBlock(blockRequestBody);
    }
}
