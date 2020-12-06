package com.minibackend.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * <h1>创建用户请求对象定义</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    /** 用户名 */
    private String username;

    /** 邮箱 */
    private String email;

    /**
     * <h2>请求有效性验证</h2>
     * */
    public boolean validate() {

        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
