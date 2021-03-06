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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.mindata.blockchain.core.requestbody.BlockRequestBody;
import com.mindata.blockchain.core.requestbody.InstructionBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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
        return "login";
    }
    @RequestMapping(value="/userregister",method = RequestMethod.POST)
    public String register(@RequestParam("unitno") String unitno,@RequestParam("unittype") String unittype,@RequestParam("usertype") String usertype,@RequestParam("roletype") String roletype,@RequestParam("idnumber") String idnumber,@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("password1") String password1)
    {
        System.out.println(unitno+"  "+unittype);
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.ADD);
        instructionBody.setTable("user");
        instructionBody.setJson("{\"unitno\":\"" + unitno + "\",\"unittype\":\""+unittype+"\",\"roletype\":\""+roletype+"\",\"idnumber\":\""+idnumber+"\",\"userType\":\""+usertype+"\",\"name\":\""+name+"\",\"password\":\""+password+"\",\"ifcheck\":\""+"0"+"\"}");
        System.out.println("++++++++++++"+instructionBody.getJson());
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
        return "login";
    }
    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("username") String username, @RequestParam("password") String password,ModelAndView model){
        //HttpSession session=request.getSession();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
         Subject subject= SecurityUtils.getSubject();
        String error=null;

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }
        System.out.println("------------------------------error:"+error);

        if(error != null) {//出错了，返回登录页面
            model.setViewName("login");;
        } else {//登录成功
            UserEntity checkuser=new UserEntity();
            checkuser.setIfcheck("0");
            checkuser.setUpdateTime(null);
            Example<UserEntity> example1=Example.of(checkuser);
            List<UserEntity> userEntityList=userManager.findAll(example1);
            System.out.println(userEntityList);
            model.addObject("userlist",userEntityList);
            model.setViewName("index");
        }

            return model;
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
        return "login";
    }
    @RequestMapping(value = "/showuserdetail/{id}",method = RequestMethod.GET)
    public ModelAndView showUserDetail(@PathVariable("id") Long id,ModelAndView model){
        //System.out.println(id+"===========");
        UserEntity userEntity=userRepository.findOne(id);
        model.addObject("userdetail",userEntity);
        model.setViewName("/Request_details");
        return model;
    }
    @RequiresRoles("admin")
    @RequestMapping(value = "/passcheck/{id}",method = RequestMethod.GET)
    public ModelAndView passCheck(@PathVariable("id") Long id,ModelAndView model){
        InstructionBody instructionBody = new InstructionBody();
        instructionBody.setOperation(Operation.UPDATE);
        instructionBody.setTable("user");
        instructionBody.setJson("{\"id\":\"" + id + "\",\"ifcheck\":\""+"1"+"\"}");
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
        UserEntity checkuser=new UserEntity();
        checkuser.setIfcheck("0");
        checkuser.setUpdateTime(null);
        Example<UserEntity> example1=Example.of(checkuser);
        List<UserEntity> userEntityList=userManager.findAll(example1);
        System.out.println(userEntityList);
        model.addObject("userlist",userEntityList);
        model.setViewName("index");
        return model;
    }
}
