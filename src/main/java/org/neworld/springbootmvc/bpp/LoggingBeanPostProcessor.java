package org.neworld.springbootmvc.bpp;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
@Log4j2
public class LoggingBeanPostProcessor implements BeanPostProcessor {
    private static volatile int counter;
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        //перед инициализацией каждого бина
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        // Добавляем логирование после инициализации бина
        log.info("Bean" + counter++ + " created: " + beanName);
        if (AopUtils.isAopProxy(bean)) {
            log.info(bean.getClass().getName() + " is a proxy");
        }
        return bean;
    }

    @PreDestroy
    public void postProcessBeforeDestruction() {
        // Добавляем логирование перед уничтожением бина
        log.warn("Bean will destroy");
    }
}
