package kosaShoppingMall.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Component
@Service
public class FindIdService {
	@Autowired
	LoginMapper loginMapper;
	
	public String execute(FindIdCommand findIdCommand, BindingResult result, Model model) {

		// id 찾기
		AuthInfo authInfo = loginMapper.findId(findIdCommand.getMemberEmail());
		
		if(authInfo == null) {
			result.rejectValue("memberEmail", "findIdCommand.memberEmail", "일치하는 이메일 없음");
			return "thymeleaf/help/findId";
		}else {
			if(authInfo.getPhone().equals(findIdCommand.getMemberPhone())) {
				model.addAttribute("userId", authInfo.getUserId());
				return "thymeleaf/help/findIdOk";
			}else {
				// error.properties에서 설정한 bad(error 메세지) /(.properties는 application.properties 또는 WebConfig.java에서 설정)
				result.rejectValue("memberPhone", "bad");
				//result.rejectValue("memberPhone", "findIdCommand.memberPhone", "일치하는 전화번호 없음");
				return "thymeleaf/help/findId";
				
			}
		}

	}
}
