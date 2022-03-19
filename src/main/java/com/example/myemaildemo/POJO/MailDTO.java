package com.example.myemaildemo.POJO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author 孙浩林
 * @date 2022/3/19 16:50 50
 */
@Data
public class MailDTO implements Serializable {
    /***
     * 接受的邮箱账户
     */
    @NotEmpty(message="邮箱不能为空")
    private String[] mail;

    /**
     * 邮箱标题
     */
    @NotEmpty(message = "邮箱标题不可为空")
    private String title;

    /**
     * 要发送的内容
     */
     @NotEmpty(message = "内容不能为空")
    private String content;

}
