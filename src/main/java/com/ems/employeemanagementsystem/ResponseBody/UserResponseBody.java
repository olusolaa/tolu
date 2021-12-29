package com.ems.employeemanagementsystem.ResponseBody;

import com.ems.employeemanagementsystem.Models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseBody {
    private String accessToken;
    private String tokenType = "Bearer";
    private Users users;

    public UserResponseBody(String accessToken,  Users users) {
        this.accessToken = accessToken;
        this.users = users;
    }
}
