package com.github.andreichenko.ssh;

import com.github.andreichenko.ssh.exception.SshException;

public interface SshClient {
    /**
     * pass the {@link SshClientConfig} to client
     * @param config the information used to connect to server
     * @return SshClient itself
     */
    public SshClient init(SshClientConfig config);

    /**
     * connect to server, and timeout if longer than {@code timeoutInSeconds}
     * @param timeoutInSeconds timeout in seconds
     * @return SshClient itself
     * @throws SshException if server is unreachable, usually the host and port is incorrect
     */
    public SshClient connect(int timeoutInSeconds) throws SshException;

    /**
     * auth with password
     * @return SshClient itself
     * @throws SshException if username or password is incorrect
     */
    public SshClient authPassword() throws SshException;

    /**
     * auth with key
     * @return SshClient itself
     * @throws SshException if username or public key is incorrect
     */
    public SshClient authPublickey() throws SshException;

    /**
     * start session
     * @param shellMode <tt>true</tt>: communicate with server interactively in session, just like command line
     * <p><tt>false</tt>: only execute command once in session
     * @return SshClient itself
     * @throws SshException when start session failed
     *
     */
    public SshClient startSession(boolean shellMode) throws SshException;

    /**
     *
     * @param command execute the {@code command} on server instance, and timeout if longer than {@code timeoutInSeconds}.
     * @param timeoutInSeconds timeout in seconds
     * @return SshResponse
     *
     */
    public SshResponse executeCommand(String command, int timeoutInSeconds);

    /**
     * set the listener on SshClient
     * @param listener notify listener when events occur in SshClient
     * @return SshClient itself
     */
    public SshClient setEventListener(SshClientEventListener listener);

    /**
     * disconnect from server
     */
    public void disconnect();

    /**
     * state of SshClient
     *
     * @return SshClientState the state of ssh client
     * <p><tt>inited</tt> before {@link #startSession(boolean)} success
     * <p><tt>connected</tt> after {@link #startSession(boolean)} success
     * <p><tt>disconnected</tt> after {@link #disconnect()}, or any connection problem occurs
     */
    public SshClientState getState();
}
