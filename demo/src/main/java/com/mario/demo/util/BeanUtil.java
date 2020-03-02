package com.mario.demo.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class BeanUtil implements ApplicationContextAware {
    public static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }

    private void setContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getBean(String name) {
        if (context != null) {
            return (T) context.getBean(name);
        } else {
            return null;
        }

    }
}
