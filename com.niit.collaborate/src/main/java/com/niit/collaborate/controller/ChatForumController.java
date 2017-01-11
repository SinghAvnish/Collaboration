package com.niit.collaborate.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.niit.collaborate.model.Message;
import com.niit.collaborate.model.OutputMessage;



@Controller
public class ChatForumController {

		@MessageMapping("/chatforum")
		@SendTo("/topic/message")
		public OutputMessage sendMessage(Message message)
		{
			return new OutputMessage(message, new Date());
		}
}