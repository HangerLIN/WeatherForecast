package com.lth.weather.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lth.weather.Utils.ResData;
import com.lth.weather.entity.UserLike;
import com.lth.weather.entity.User;
import com.lth.weather.mapper.LikeMapper;
import com.lth.weather.mapper.UserMapper;
import com.lth.weather.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final LikeMapper likeMapper;



    @Override
    @Transactional
    public ResData UserLogin(User user) {
        //查询一个用户所有信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        User one = userMapper.selectOne(wrapper);
        //查询用户like
        QueryWrapper<UserLike> wrapperLike = new QueryWrapper<>();
        wrapperLike
                .select("address")
                .eq("u_id",one.getId());
        List<Object> likes = likeMapper.selectObjs(wrapperLike);
        one.setLike(likes);
        return ResData.resultObject(one);
    }

    @Override
    public ResData UserLike(String id) {
        //查询用户like
        QueryWrapper<UserLike> wrapperLike = new QueryWrapper<>();
        wrapperLike
                .select("address")
                .eq("u_id",id);
        List<Object> likes = likeMapper.selectObjs(wrapperLike);
        return ResData.resultObject(likes);
    }

    @Override
    public ResData editPwd(User user) {
        int i = userMapper.updateById(user);
        return ResData.resultInt(i);
    }

    @Override
    public ResData editInfo(User user) {
        return ResData.resultInt(userMapper.updateById(user));
    }

    @Override
    public ResData addLike(String name, String userId) {
        UserLike userLike = new UserLike();
        userLike.setUId(userId);
        userLike.setAddress(name);
        return ResData.resultInt(likeMapper.insert(userLike));
    }

    @Override
    public ResData delLike(String name, String userId) {
//        int e = likeMapper.delLike(name,userId);
        QueryWrapper<UserLike> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",userId).eq("address",name);
        int delete = likeMapper.delete(wrapper);
        return ResData.resultInt(delete);
    }

    @Override
    public ResData addUser(User user) {
        int insert = userMapper.insert(user);
        return ResData.resultInt(insert);
    }

    @Override
    public ResData delUser(String id) {
        int i = userMapper.deleteById(id);
        return ResData.resultInt(i);
    }

    @Override
    public ResData getAll() {
        List<User> users = userMapper.selectList(null);
        return ResData.resultObject(users);
    }

}
