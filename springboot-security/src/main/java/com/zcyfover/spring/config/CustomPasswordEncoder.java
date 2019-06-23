package com.zcyfover.spring.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zcy-fover
 * @description TODO
 * @date 2019-05-26 15:18
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
