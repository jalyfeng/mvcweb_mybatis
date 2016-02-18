package org.jaly.web.db.service;

import org.jaly.web.db.entity.User;

/**
 * Created by daboowifi on 16/2/17.
 */
public interface UserServiceI {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    User getUserById(int userId);
}
