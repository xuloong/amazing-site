package com.xulong.amazingsite.config;

import com.xulong.amazingsite.common.SysContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * MyAuditorAware
 *
 * @author xulong
 * @date 2018/9/18
 */
@Configuration
public class MyAuditorAware implements AuditorAware<Long> {

    @Override
    public Long getCurrentAuditor() {

        return SysContext.getCurrentUser().getId();

    }

}
