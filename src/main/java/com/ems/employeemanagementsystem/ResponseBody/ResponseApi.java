package com.ems.employeemanagementsystem.ResponseBody;

import com.ems.employeemanagementsystem.Models.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseApi {
    @JsonIgnore
    Object data;
    String message;
}
