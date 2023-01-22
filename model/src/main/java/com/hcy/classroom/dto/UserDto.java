package com.hcy.classroom.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 韩传勇
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    private String name;

    private String password;

}
