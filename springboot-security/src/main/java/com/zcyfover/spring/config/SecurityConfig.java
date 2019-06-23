package com.zcyfover.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author zcy-fover
 * @description 如何验证用户身份
 * @date 2019-05-26 13:02
 */
@EnableWebSecurity //开启Web security功能
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(new CustomPasswordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zcy-fover").password("123456").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN", "USER").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //css资源和index页面不需要验证
        http.authorizeRequests().antMatchers("/css/**", "/index").permitAll()
                //以user和blogs开头的资源需要验证，并且用户的角色是"USER"
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                //表单登录的地址是/login，登录失败的地址是login-error
                .and().formLogin().loginPage("/login").failureUrl("/login-error")
                //异常处理重定向到401页面
                .and().exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }

}
