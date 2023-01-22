package com.hcy.classroom.dto;

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
public class UserRegisterDto {

    private String name;

    private String password;

    private String telephone;

}
