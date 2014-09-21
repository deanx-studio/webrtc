package com.mdnet.asterisk.action;

import com.mdnet.asterisk.ami.ActionMsg;

public class LoginActionMsg extends ActionMsg {
	public LoginActionMsg() {
		this.Action = "Login";
	}

	private String Username;// : admin
	private String Secret;// : secret5

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getSecret() {
		return Secret;
	}

	public void setSecret(String secret) {
		Secret = secret;
	}

	public String toString() {

		String msg = super.toString();
		msg += "Username: " + this.Username + "\r\n";
		msg += "Secret: " + this.Secret + "\r\n\r\n";
		return msg;
	}

}
