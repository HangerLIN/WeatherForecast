package com.lth.weather.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String username;
    private String password;
    private String email;
    private String nickname;
    private String sex;
    private String age;
    private String role;

    @TableField(exist = false)
    private List<Object> like;
}
