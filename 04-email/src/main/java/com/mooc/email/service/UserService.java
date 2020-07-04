package com.mooc.email.service;

import com.mooc.email.dao.UserDao;
import com.mooc.email.domain.User;
import com.mooc.email.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void regist(User user){
        userDao.save(user);

        try {
            MailUtils.sendMail(user.getEmail(),user.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 用户激活的方法
     * @param code
     */
    public boolean registActive(String code){

        User user = userDao.findByCode(code);
        if( null == user){
            return false;
        }
        user.setState(1);
        user.setCode("");

        userDao.save(user);

        return true;
    }
}
