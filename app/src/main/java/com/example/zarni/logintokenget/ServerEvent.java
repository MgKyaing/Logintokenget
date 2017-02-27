package com.example.zarni.logintokenget;


public class ServerEvent {
    private ServerResponseLogin ServerResponseLogin ;
    private ServerResponse serverResponse;

    public ServerEvent(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerEvent(String s) {
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerEvent(ServerResponseLogin ServerResponseLogin){
        this.ServerResponseLogin=ServerResponseLogin;
    }

    public ServerResponse getServerResponseLogin() {

        return  serverResponse;
    }
}
