package com.mindata.blockchain.controller;
import cn.hutool.core.collection.CollectionUtil;
import com.mindata.blockchain.block.Instruction;
import com.mindata.blockchain.block.Operation;
import com.mindata.blockchain.block.check.BlockChecker;
import com.mindata.blockchain.core.manager.DbBlockManager;
import com.mindata.blockchain.core.manager.MessageManager;
import com.mindata.blockchain.core.manager.SyncManager;
import com.mindata.blockchain.core.manager.UserManager;
import com.mindata.blockchain.core.model.UserEntity;
import com.mindata.blockchain.core.repository.UserRepository;
import com.mindata.blockchain.core.service.BlockService;
import com.mindata.blockchain.core.service.InstructionService;
import com.mindata.blockchain.socket.client.PacketSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mindata.blockchain.core.repository.UserRepository;
import com.mindata.blockchain.core.bean.BaseData;
import com.mindata.blockchain.core.bean.ResultGenerator;
import com.mindata.blockchain.core.requestbody.BlockRequestBody;
import com.mindata.blockchain.core.requestbody.InstructionBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    UserRepository userRepository;
    @Resource
    UserManager userManager;
    @Resource
    private BlockService blockService;
    @Resource
    private PacketSender packetSender;
    @Resource
    private DbBlockManager dbBlockManager;
    @Resource
    private InstructionService instructionService;
    @Resource
    private SyncManager syncManager;
    @Resource
    private MessageManager messageManager;
    @Resource
    private BlockChecker blockChecker;
    @Value("${publicKey:A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54}")
    private String publicKey;
    @Value("${privateKey:yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=}")
    private String privateKey;

    @RequestMapping("/register")
    public String showRegister(){
        return "register-simple";
    }
    @RequestMapping("/changepassword")
    public String changePassword(){return "revise-password";}
    @RequestMapping("/forgetpassword")
    public String forgerPassword(){return "recover-password";}
    @RequestMapping(value = "/recoverpassword",method = RequestMethod.POST)
    public String recoverPassword(@RequestParam("unitno") String unitno,@RequestParam("idnumber") String idnumber,@RequestParam("newpassword") String newpassword,@RequestParam("newpassword1") String newpassword1){
        UserEntity userEntity=new UserEntity();
        userEntity.setUpdateTime(null);
        userEntity.setIdnumber(idnumber);
        userEntity.setUnitno(unitno);
        Example<UserEntity> example=Example.of(userEntity);
        UserEntity currentUser= userManager.findOne(example);
        Long changeUserId=currentUser.getId();
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.UPDATE);
        instructionBody.setTable("user");
        instructionBody.setJson("{\"id\":\"" + changeUserId + "\",\"password\":\"" + newpassword + "\",\"idnumber\":\""+idnumber+"\",\"unitno\":\""+unitno+"\"}");
        /*instructionBody.setPublicKey("A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54");
        instructionBody.setPrivateKey("yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=");*/
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
        System.out.print(blockBody.toString());
        return "login-simple";
    }
    @RequestMapping(value="/userregister",method = RequestMethod.POST)
    public String register(@RequestParam("unitno") String unitno,@RequestParam("unittype") String unittype,@RequestParam("usertype") String usertype,@RequestParam("roletype") String roletype,@RequestParam("idnumber") String idnumber,@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("password1") String password1)
    {
        System.out.println(unitno+"  "+unittype);
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("user");
        instructionBody.setJson("{\"unitno\":\"" + unitno + "\",\"unittype\":\""+unittype+"\",\"roletype\":\""+roletype+"\",\"idnumber\":\""+idnumber+"\",\"userType\":\""+usertype+"\",\"name\":\""+name+"\",\"password\":\""+password+"\",\"ifcheck\":\""+"0"+"\"}");
        /*instructionBody.setPublicKey("A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54");
        instructionBody.setPrivateKey("yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=");*/
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
        System.out.print(blockBody.toString());
        return "login-advanced";
    }
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public String userLogin(@RequestParam("idnumber") String idnumber,@RequestParam("password") String password){
        //HttpSession session=request.getSession();
        System.out.println(idnumber);
        UserEntity userEntity=new UserEntity();
        userEntity.setIdnumber(idnumber);
        userEntity.setUpdateTime(null);
        System.out.println(userEntity);
        Example<UserEntity> example= Example.of(userEntity);
        UserEntity loginuser= userManager.findOne(example);
        System.out.println(loginuser.getPassword()+"=============="+password);
        if (loginuser.getPassword().equals(password)){
            //session.setAttribute("currentuserid",loginuser.getId());
            return "index";
        }

            return "login-advanced";


    }
    @RequestMapping(value = "/revisepassword",method = RequestMethod.POST)
    public String revisePassword(@RequestParam("currentpassword") String currentpassword,@RequestParam("newpassword") String newpassword,@RequestParam("newpassword1") String newpassword1){

        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.UPDATE);
        instructionBody.setTable("user");
        instructionBody.setJson("{\"password\":\"" + newpassword + "\",\"id\":\""+28+"\"}");
        /*instructionBody.setPublicKey("A8WLqHTjcT/FQ2IWhIePNShUEcdCzu5dG+XrQU8OMu54");
        instructionBody.setPrivateKey("yScdp6fNgUU+cRUTygvJG4EBhDKmOMRrK4XJ9mKVQJ8=");*/
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
        System.out.print(blockBody.toString());
        return "login-advanced";
    }
}
