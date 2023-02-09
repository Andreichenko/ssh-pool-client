package com.github.andreichenko.ssh;

public interface SshClientEventListener {
    /**
     * after SshClient finished executing command
     * @param client the ssh client
     */
    public void didExecuteCommand(Object client);

    /**
     * after SshClient disconnnect from the remote server
     * @param client the ssh client
     */
    public void didDisConnected(Object client);

    /**
     * after SshClient start the ssh session
     * @param client the ssh client
     */
    public void didConnected(Object client);
}
