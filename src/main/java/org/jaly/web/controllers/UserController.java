package org.jaly.web.controllers;

import org.jaly.web.db.dao.UserMapper;
import org.jaly.web.db.entity.User;
import org.jaly.web.db.entity.UserExample;
import org.jaly.web.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by daboowifi on 16/2/17.
 */
@Controller
@RequestMapping("/api/user")
public class UserController {


    final static String contentType = "application/json";

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="checkUser",method = RequestMethod.POST, produces = contentType)
    @ResponseBody
    public ResponseResult checkUser(String username){

        ResponseResult response=new ResponseResult();
        if(username==null){
            response.setError("用户名未输入");
            response.setErrorCode(300);
            response.setStatus(-1);
        }else{
            UserExample userExample=new UserExample();
            userExample.createCriteria().andUsernameEqualTo(username);
            List<User> list= userMapper.selectByExample(userExample);
            if(list!=null && list.size()>0){
                //存在
                response.setError("当前用户已经存在");
                response.setErrorCode(300);
                response.setStatus(-1);
            }
        }
        return response;

    }

    @RequestMapping(value="addUser",method = RequestMethod.POST, produces = contentType)
    @ResponseBody
    public ResponseResult addUser(@Valid @ModelAttribute("user") User user,
                                  BindingResult result){
        ResponseResult response=new ResponseResult();
        if(result.hasErrors()){
            response.setError(result.getAllErrors().get(0).getDefaultMessage());
            response.setErrorCode(310);
            response.setStatus(-1);
        }else if(user==null){
            response.setError("信息不全");
            response.setErrorCode(310);
            response.setStatus(-1);
        }else{
            response=checkUser(user.getUsername());
            if(response.getStatus()==0){
                int count=userMapper.insertSelective(user);
                if(count==0){
                    response.setError("更新失败");
                    response.setErrorCode(310);
                    response.setStatus(-1);
                }
            }
        }
        return response;
    }

    @RequestMapping(value = "userList",method = RequestMethod.POST,produces = contentType)
    @ResponseBody
    public ResponseResult userList(){
        UserExample userExample=new UserExample();
        List<User> list = userMapper.selectByExample(userExample);
        ResponseResult response=new ResponseResult();
        response.setData(list);
        return response;

    }

}
