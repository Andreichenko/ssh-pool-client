package com.github.andreichenko.ssh;

import com.github.andreichenko.ssh.pool.SshClientPoolConfig;

public class SshClientFactory {

    /**
     * Create a new instance of {@link SshClientSSHJ}
     * @param config ssh connection configuration of the remote server
     * @return SshClient in inited state
     */
    public static SshClient newInstance(SshClientConfig config){
        return newInstance(config, null);
    }

    /**
     * Create a custom implementation of {@link SshClient}
     * @param config ssh connection configuration of the remote server
     * @param poolConfig customized configuration
     * @return SshClient in inited state
     * @throws RuntimeException if SshClientImplClass in {@code poolConfig} is invalid
     */
    public static SshClient newInstance(SshClientConfig config, SshClientPoolConfig poolConfig){
        try {
            SshClient client = null;
            if (poolConfig==null || poolConfig.getSshClientImplClass()==null){
                client = new SshClientSSHJ();
            }else {
                client = (SshClient)poolConfig.getSshClientImplClass().newInstance();
            }
            client.init(config);
            if(client instanceof SshClientSSHJ && poolConfig!=null && poolConfig.getServerCommandPromotRegex()!=null) {
                ((SshClientSSHJ)client).setCommandPromotRegexStr(poolConfig.getServerCommandPromotRegex());
            }
            return client;
        } catch (InstantiationException e) {
            throw new RuntimeException("new instance failed", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("new instance failed", e);
        }
    }
}
