package com.cos.blog.action.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dto.ReplyResponseDto;
import com.cos.blog.model.Reply;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

public class ReplyWriteProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
					Script.getMessage("잘못된 접근입니다.", response);
					return;
				}
		
		//application/json
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input=null;
		while((input= br.readLine()) != null) {
			sb.append(input);
			
		}
		System.out.println(sb.toString());
		Gson gson = new Gson();
		Reply reply = gson.fromJson(sb.toString(), Reply.class);
		//ReplyRepository 연결 -save(reply)
		ReplyRepository replyRepository = ReplyRepository.getInstance();
		int result = replyRepository.save(reply);
		// save 성공시 1, 실패시 -1
		if(result == 1) {
			List<ReplyResponseDto> replyDtos = replyRepository.findAll(reply.getBoardId());
			String replyDtosJson = gson.toJson(replyDtos);
			Script.outJson(replyDtosJson, response);
		}else {
			Script.outJson(result+"", response);
		}
		//script.outText()로 응답
		
	}
}
