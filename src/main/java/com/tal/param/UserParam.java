package com.tal.param;
//封装类，页面上需要填写的数据，然后我们来校验

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserParam {
    @NotNull
    private Integer uid;

    @NotBlank(message = "用户名不为空")
    @Length(min = 1,max = 50,message = "名字长度50以内")
    private  String name;

    @NotBlank(message = "用户密码不为空")
    @Length(min = 1,max = 50,message = "密码长度50以内")
    private String password;
    @NotNull(message = "父id不为空")
    private Integer parentid=0;

    @NotNull(message = "必须指定用户的状态")
    @Min(value = 0,message = "用户状态不合法")
    @Max(value = 2,message = "用户状态不合法")
    private Integer status;

    @NotNull

    private int seq;



}
