package com.example.demo05.controller;

import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{pageCode}")
public class WebSocketController {
	private static final String loggeerName=WebSocketController.class.getName();

	public static Map<String,List<Session>> electricSocketmap = new ConcurrentHashMap<String, List<Session>>();
	//建立连接对象
	@OnOpen
	public void onOpen(@PathParam("pageCode") String pageCode, Session session){
		List<Session> sessions=electricSocketmap.get(pageCode);
		if(sessions==null){
			List<Session> sessionList=new ArrayList<>();
			sessionList.add(session);
			electricSocketmap.put(pageCode,sessionList);
		}
		else {
			sessions.add(session);
		}
	}

	//收到调用的信息
	@OnMessage
	public void onMessage(String message,Session session){
		System.out.println("接受到的信息:"+message);
		try {
			session.getBasicRemote().sendText("我推送的信息是:"+message);
			System.out.println("我推送的信息是:"+message);
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	@OnError
	public void onError(Session session,Throwable throwable){
		System.out.println("发生错误");
	}
	@OnClose
	public void onClose(@PathParam("pageCode")String pageCode,Session session){
		if (electricSocketmap.containsKey(pageCode)){
			electricSocketmap.get(pageCode).remove(session);

		}
	}
}
