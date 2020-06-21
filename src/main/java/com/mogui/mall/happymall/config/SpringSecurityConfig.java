package com.mogui.mall.happymall.config;

import com.mogui.mall.happymall.Seivice.MgUmPermissionService;
import com.mogui.mall.happymall.Seivice.MgUmUserService;
import com.mogui.mall.happymall.common.JwtAuthenticationTokenFilter;
import com.mogui.mall.happymall.common.ResponseVO;
import com.mogui.mall.happymall.dto.MgUserDetail;
import com.mogui.mall.happymall.pojo.MgUmPermission;
import com.mogui.mall.happymall.pojo.MgUmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @author ke nan
 * @date 2020/6/12 22:38
 * @declare SpringSecurity配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private MgUmUserService mgUmUserService;

    @Autowired
    private MgUmPermissionService mgUmPermissionService;


    /**
     * 用于配置需要拦截的url路径、jwt过滤器及出异常后的处理器；
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login","admin/register")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .antMatchers("/**")
                .permitAll()
                .anyRequest()
                .authenticated();
        //禁用缓存
        httpSecurity.headers().cacheControl();
        //添加jwt filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    /**
     * 用于配置UserDetailsService及PasswordEncoder；
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    /**
     * SpringSecurity定义的用于对密码进行编码及比对的接口
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    /**
     * 定义的核心接口，用于根据用户名获取用户信息，需要自行实现；
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        //获取登录信息
        //获取登录用户信息
        return userName -> {
            MgUmUser umUser = mgUmUserService.selectMgUmUserByUserName(userName);
            if (umUser!=null) {
                List<MgUmPermission> permissionList =mgUmPermissionService.mgUmPermissionList(umUser.getId());
                return new MgUserDetail(umUser,permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    /**
     * 在用户名和密码校验前添加的过滤器，如果有jwt的token，会自行根据token信息进行登录。
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
