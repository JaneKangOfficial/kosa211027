package school.service.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import school.domain.StartEndPageDTO;
import school.domain.SubjectDTO;
import school.mapper.SubjectMapper;

@Service
public class SubjectListService {
	@Autowired
	SubjectMapper subjectMapper;
	
	public void execute(Model model, Integer page) {
		
		int limit = 5;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		List<SubjectDTO> list = subjectMapper.selectAll(dto);
		int count = subjectMapper.count();
		
		int maxPage = (int)((double)count / limit + 0.9);
		
		int startPage = ((int)((double)page / limitPage + 0.9) - 1) * limitPage + 1; // 1을 더하면 endPage가 10일때 11로 잘못 계산된다.
		int endPage = startPage + limitPage -1;		
		
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);

		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
	}
}
