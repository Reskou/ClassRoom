package com.hcy.classroom.model.user;

import com.hcy.classroom.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "UserInfo")
@TableName("user_info")
public class UserInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手机号")
	@TableField("phone")
	private String phone;

	@ApiModelProperty(value = "用户密码")
	@TableField("password")
	private String password;

	@ApiModelProperty(value = "用户姓名")
	@TableField("name")
	private String name;

}