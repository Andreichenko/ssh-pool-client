package com.github.andreichenko.ssh.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("andreichenko.ssh-pool-client")
public class SshClientPoolProperties {

    private int maxIdle = 20;
    private int idleTime = 120*1000;
    private int maxActive = 20;
    private int maxWait = 120*1000;
    private String sshClientImplClass = "com.github.andreichenko.ssh.SshClientSSHJ";
    private SshClientProperties sshj;

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public String getSshClientImplClass() {
        return sshClientImplClass;
    }

    public void setSshClientImplClass(String sshClientImplClass) {
        this.sshClientImplClass = sshClientImplClass;
    }

    public SshClientProperties getSshj() {
        return sshj;
    }

    public void setSshj(SshClientProperties sshj) {
        this.sshj = sshj;
    }

    public static class SshClientProperties{
        private String serverCommandPromotRegex;

        public String getServerCommandPromotRegex() {
            return serverCommandPromotRegex;
        }

        public void setServerCommandPromotRegex(String serverCommandPromotRegex) {
            this.serverCommandPromotRegex = serverCommandPromotRegex;
        }

    }
}
