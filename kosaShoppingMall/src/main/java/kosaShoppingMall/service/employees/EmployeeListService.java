package kosaShoppingMall.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.EmployeeMapper;
import kosaShoppingMall.repository.EmployeeRepository;

@Component
@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper; // interface 사용시
	//EmployeeRepository employeeMapper; // class 사용시
	
	public void execute(Model model, Integer page) {
		int limit = 5;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		// Long startRow = ((long)page * limit) - (limit - 1); 
		// Long endRow = (long)page * limit;	
		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		int count = employeeMapper.empCount();
		List<EmployeeDTO> list = employeeMapper.selectAll(dto);
		
		int maxPage = (int)((double)count / limit + 0.9);
		int startPage = ((int)((double)page / limitPage + 0.9) - 1) * limitPage + 1; 
		// int startPage = (int)page / limitPage + 1;
		int endPage = startPage + limitPage - 1;		
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("count",count);
		model.addAttribute("list",list);
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
	}
}
