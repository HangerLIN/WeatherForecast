package com.lth.weather.service;

import com.lth.weather.entity.User;
import com.lth.weather.Utils.ResData;


public interface UserService {
    ResData UserLogin(User user);

    ResData UserLike(String id);

    ResData editPwd(User user);

    ResData editInfo(User user);

    ResData addLike(String name, String userId);

    ResData delLike(String name, String userId);

    ResData addUser(User user);

    ResData delUser(String id);

    ResData getAll();
}
