package com.example.demo03work.code.command

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest


/**
 * Http上下文实用程序类
 * @author 蔡
 * @since 2019-12-26
 * 修改时间:
 */
object HttpContextUtil {

    ///获取请求的对象
    @JvmStatic
    fun getRequest(): HttpServletRequest {
        return (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
    }

    //获取IP地址
    @JvmStatic
    fun getIpAddress(): String {
        var ip :String? = "127.0.0.1"
        val request = getRequest()
        ip = request.getHeader("x-forwarder-for")

        if (ip == null || ip.isEmpty() || "unknown".equals(ip,true)) {
            ip = request.getHeader("Proxy-Client-IP")
        }
        if (ip == null || ip.isEmpty() || "unknown".equals(ip,true)) {
            ip = request.getHeader("WL-Proxy-Client-IP")
        }
        if (ip == null || ip.isEmpty() || "unknown".equals(ip,true)) {
            ip = request.getHeader("HTTP_Client_IP")
        }
        if (ip == null || ip.isEmpty() || "unknown".equals(ip,true)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR")
        }
        if (ip == null || ip.isEmpty() || "unknown".equals(ip,true)) {
            ip = request.remoteAddr
        }



        println("ip:$ip")
        return if ("0:0:0:0:0:0:0:1" === ip) "127.0.0.1" else ip
    }
}