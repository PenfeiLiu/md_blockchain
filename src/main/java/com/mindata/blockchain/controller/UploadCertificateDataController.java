package com.mindata.blockchain.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.mindata.blockchain.block.Instruction;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.common.utils.SubStringUtils;
import com.mindata.blockchain.core.model.*;
import com.mindata.blockchain.core.requestbody.BlockRequestBody;
import com.mindata.blockchain.core.requestbody.InstructionBody;
import com.mindata.blockchain.core.service.BlockService;
import com.mindata.blockchain.core.service.InstructionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UploadCertificateDataController {//数据上传所有功能模块
    @Value("${publicKey:A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54}")
    private String publicKey;
    @Value("${privateKey:yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=}")
    private String privateKey;
    @Resource
    private InstructionService instructionService;

    @Resource
    private BlockService blockService;


    @RequestMapping(value = "/applyCertificateUpdate",method = RequestMethod.POST)
    public String applyCertificateUpdate(@ModelAttribute("certificateApplyData")CertificateApplyData certificateApplyData,Model model){
        //HttpSession session=request.getSession();
        System.out.println(certificateApplyData.toString());
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("certificate");
        instructionBody.setJson(certificateApplyData.toString());
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

        return "/index";

    }

    @RequestMapping("/uploadpage")//证书申请资料上传
    public ModelAndView intoUploadPage(){
        CertificateApplyData certificateApplyData = new CertificateApplyData();

        return new ModelAndView("upload_Certificate_Application").addObject(certificateApplyData);
    }

    @RequestMapping("/uploadFile")//文件审核资料上传
    public ModelAndView intoUploadFile(){
        FileCheckData fileCheckData = new FileCheckData();

        return new ModelAndView("upload_Document_audit_Application").addObject(fileCheckData);
    }

    @RequestMapping("/uploadCertification")//证书数据上传
    public ModelAndView intoUploadCertificationPage(){
        CertificationData certificationData = new CertificationData();

        return new ModelAndView("upload_Certificate_data").addObject(certificationData);
    }

    @RequestMapping("/uploadOnSiteData")//现场审核资料上传
    public ModelAndView intoUploadOnSitePage(){
        OnSiteAuditData onSiteAuditData = new OnSiteAuditData();

        return new ModelAndView("upload_Site_audit").addObject(onSiteAuditData);
    }



    @RequestMapping(value = "/filecheckupload",method = RequestMethod.POST)
    public String fileCheck(@ModelAttribute("fileCheckData")FileCheckData fileCheckData){
        //HttpSession session=request.getSession();
        System.out.println(fileCheckData.toString());
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("file_check_data");
        instructionBody.setJson(fileCheckData.toString());
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

        return "/index";

    }

    @RequestMapping(value = "/uploadCertificateData",method = RequestMethod.POST)
    public String uploadCertificateData(@ModelAttribute("certificationData")CertificationData certificationData){
        //HttpSession session=request.getSession();
        System.out.println(certificationData.toString());
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("certificate_data");
        instructionBody.setJson(certificationData.toString());
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

        return "/index";

    }

    @RequestMapping(value = "/uploadOnSiteAuditData",method = RequestMethod.POST)
    public String uploadOnSiteAuditData(@ModelAttribute("onSiteAuditData")OnSiteAuditData onSiteAuditData){
        //HttpSession session=request.getSession();
        System.out.println(onSiteAuditData.toString());
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("on_site_data");
        instructionBody.setJson(onSiteAuditData.toString());
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

        return "/index";

    }
}
