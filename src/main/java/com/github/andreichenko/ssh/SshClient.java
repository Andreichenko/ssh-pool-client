package com.github.andreichenko.ssh;

import com.github.andreichenko.ssh.exception.SshException;

public interface SshClient {
    public SshClient init(SshClientConfig config);

    public SshClient connect(int timeoutInSeconds) throws SshException;

    public SshClient authPublickey() throws SshException;
}
