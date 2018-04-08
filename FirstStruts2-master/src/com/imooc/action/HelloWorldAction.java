package com.imooc.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private String username;   
    private String userpassword;  
    
    public String getUsername() {   
        return username;   
    }   
    public void setUsername(String username) {   
        this.username = username;   
    }   
  
    public String getUserpassword() {   
        return userpassword;   
    }   
  
    public void setUserpassword(String userpassword) {   
        this.userpassword = userpassword;   
    }   
  
public String execute(){   
    System.out.println("我进来了呢");   
    System.out.println(this.getUsername());   
    System.out.println(this.getUserpassword());   
    if("bai".equals(this.getUsername())&"admin".equals(this.getUserpassword())){   
        return "success";   
    }else{   
        return "fail";   
    }   
}   
	
}
