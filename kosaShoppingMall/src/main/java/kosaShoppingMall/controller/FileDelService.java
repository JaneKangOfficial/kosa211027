package kosaShoppingMall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.FileInfo;

@Service
public class FileDelService {
// ============================== 많이 사용하는 알고리즘 ==============================
	public void fileAdd(FileInfo fileInfo, HttpSession session, Model model) {
		
		Integer num = 0;
		Boolean newFile = true;
		
		// session이 있는 경우
		List<FileInfo> list = (List<FileInfo>)session.getAttribute("fileList");
		// session이 없는 경우
		if(list == null) {
			list = new ArrayList<FileInfo>();
		}
		
		// 같은 값이 있을 경우
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getOrgFile().equals(fileInfo.getOrgFile())) {
				list.remove(i);
				newFile = false;
				num = 0;
			}
		}
		// 같은 값이 없을 경우
		if(newFile) { // if문 : 논리 연산과 비교연산식 : 결과값이 boolean
			list.add(fileInfo);
			num = 1;
		}
		
		session.setAttribute("fileList", list);
		model.addAttribute("val", num);
	}
}
