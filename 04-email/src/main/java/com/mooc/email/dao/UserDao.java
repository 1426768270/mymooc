package com.mooc.email.dao;

import com.mooc.email.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    /**
     * 通过code查询用户
     *
     * @param code code
     * @return 用户
     */
    User findByCode(String code);
}
