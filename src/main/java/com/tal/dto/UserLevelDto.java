package com.tal.dto;

import com.google.common.collect.Lists;
import com.tal.pojo.SysUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@ToString
//欲 建立树结构用户，见一个新的结构，即 此结构中
//1.包含原来用户信息，通过复制而来 2.加一个包括自己的列表，这样就可以树结构了
//注意要想包含原来sysuser的属性，要继承
public class UserLevelDto extends SysUser{

    private List<UserLevelDto> userLevelDtoList= Lists.newArrayList();

    public static UserLevelDto adapt(SysUser user){
        UserLevelDto userLevelDto=new UserLevelDto();
        BeanUtils.copyProperties(user,userLevelDto);
        return userLevelDto;
    }



}
