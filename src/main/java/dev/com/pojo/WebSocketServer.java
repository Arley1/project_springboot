package dev.com.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


@ServerEndpoint(value="/websocket/{uid}")
@Component
public class WebSocketServer
{
    private Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static final AtomicInteger onlineCount = new AtomicInteger(0);

    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<Session>();

    @OnOpen
    public void onOpen(Session session,@PathParam("uid") String uid)
    {
        logger.info("open message uid:{}",uid);
        sessionSet.add(session);
        onlineCount.incrementAndGet();
        logger.info("窗口开始监听uid:{},当前在线人数：{}",uid,onlineCount);
    }

    @OnClose
    public void onClose(Session session)
    {
        String sessionId=session.getId();
        logger.info("sessionid:{} close",sessionId);
        sessionSet.remove(this);
        int count=onlineCount.decrementAndGet();
        logger.info("有一连接关闭！当前在线人数为:{}",count);
    }

    @OnError
    public void onError(Session session, Throwable error)
    {
        logger.error("消息发生错误：{},Session ID： {}",error.getMessage(),session.getId());
    }


    public void batchSendMesasge(String uid,String message) throws IOException
    {
        logger.info("推送消息到窗口:{},推送内容:{}",uid,message);
        for(Session session:sessionSet){
            sendMessage(session, message);
        }
    }

    public void sendMessage(Session session, String message) throws IOException {

        if(session!=null)
        {
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }

}
