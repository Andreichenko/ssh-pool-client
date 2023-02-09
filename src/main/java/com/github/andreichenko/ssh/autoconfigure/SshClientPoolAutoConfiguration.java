package com.github.andreichenko.ssh.autoconfigure;

import com.github.andreichenko.ssh.pool.SshClientPoolConfig;
import com.github.andreichenko.ssh.pool.SshClientsPool;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SshClientPoolProperties.class)
public class SshClientPoolAutoConfiguration {

    private final SshClientPoolProperties properties;

    public SshClientPoolAutoConfiguration(SshClientPoolProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(SshClientsPool.class)
    SshClientsPool sshClientsPool() {
        return new SshClientsPool(sshClientPoolConfig());
    }

    SshClientPoolConfig sshClientPoolConfig() {
        SshClientPoolConfig poolConfig = new SshClientPoolConfig(properties.getMaxActive()
                ,properties.getMaxIdle()
                ,properties.getIdleTime()
                ,properties.getMaxWait());
        if(properties.getSshj()!=null) {
            poolConfig.setServerCommandPromotRegex(properties.getSshj().getServerCommandPromotRegex());
        }
        if (properties.getSshClientImplClass()!=null) {
            try {
                poolConfig.setSshClientImplClass(Class.forName(properties.getSshClientImplClass()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return poolConfig;
    }

}
