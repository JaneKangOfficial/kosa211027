package school.mapper;

import org.springframework.stereotype.Repository;

import school.domain.CheckDTO;

@Repository("school.mapper.CkMapper")
public interface CkMapper {
	
	public CheckDTO emailCk(String email);
	public CheckDTO idCk(String id);

}
