package springBootTest2.service.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.LibraryMapper;

@Component
@Service
public class LibraryDelService {
	@Autowired
	LibraryMapper libraryMapper;
	
	public void execute(Integer libNum) {
		libraryMapper.libDel(libNum);
	}
}
