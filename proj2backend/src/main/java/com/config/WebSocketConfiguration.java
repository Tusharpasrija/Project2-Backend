package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages="com")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// /queue/ - destinationPrefix - send chat msg from server to client[Chat]
		// /topic/ - destinationPrefix - send user name to all clients[String]
		registry.enableSimpleBroker("/queue/","/topic/");
		//for browser - to send messages from browser to server 
		registry.setApplicationDestinationPrefixes("/app");
		
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/chatmodule").withSockJS();
	}

}
