package com.hcy.classroom.exception;

import com.hcy.classroom.enums.ServiceStatus;
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
public class ClassRoomException extends RuntimeException {

    private ServiceStatus status;

}
