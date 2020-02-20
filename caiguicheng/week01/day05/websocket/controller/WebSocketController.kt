package com.example.demo05.controller

import org.springframework.stereotype.Component
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import javax.websocket.*
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@ServerEndpoint("/websocket/{pageCode}")
@Component
open class WebSocketController {

    private val loggerName = WebSocketController::class.java.name

    var electricScoketmap: MutableMap<String, MutableList<Session>> = ConcurrentHashMap()

    @OnOpen
    open fun onOpen(@PathParam("pageCode") pageCode: String, session: Session) {
        val sessions: MutableList<Session>? = electricScoketmap[pageCode]
        if (sessions == null) {
            val sessionList = ArrayList<Session>()
            sessionList.add(session)
            electricScoketmap[pageCode] = sessionList
        } else {
            electricScoketmap[pageCode]?.add(session)
        }
    }

    //收到调用信息
    @OnMessage
    fun onMessage(message: String, session: Session) {
        println("发送的内容:$message")
//        println("session:$session")
//        val mutableList = electricScoketmap["1"]
//        mutableList?.let {
//            println(it)
//        }
        //session.basicRemote.sendText("我推送的信息是:$message")
        try {
            session.basicRemote.sendText("我发送的内容是:${message}")
        } catch (e: IOException) {
            println(e.message)
        }
    }

    @OnError
    fun onError(session: Session, throwable: Throwable) {
        println("发生错误")
    }

    @OnClose
    fun onClose(@PathParam("pageCode") pageCode: String, session: Session) {
        if (electricScoketmap.containsKey(pageCode)) {
            electricScoketmap[pageCode]?.remove(session)
        }
        //println("close")
    }
}