package xyz.wqf.dockerdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.wqf.dockerdemo.aop.CustomAspect;

/**
 * Created by Administrator on 2020/7/1.
 *
 * @author WeiQuanfu
 */
@Configuration
@EnableAspectJAutoProxy
public class CustomAspectConfig {
    @Bean
    public CustomAspect customAspect(){
        return new CustomAspect();
    }
}
