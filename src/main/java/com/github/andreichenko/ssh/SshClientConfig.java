package com.github.andreichenko.ssh;

public class SshClientConfig {
    private String host;
    private int port;
    private String username;
    private String password;
    private String privateKeyPath;
    private String id;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SshClientConfig) {
            return id.equals(((SshClientConfig) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return this.id;
    }

    public SshClientConfig() {
    }

    public SshClientConfig(String host, int port, String username, String password, String privateKeyPath) {
        this.id = host + port + username;
        if (null != password && password.length() > 0) {
            this.id += password;
        }
        if (privateKeyPath != null) {
            this.id += privateKeyPath;
        }
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.privateKeyPath = privateKeyPath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
