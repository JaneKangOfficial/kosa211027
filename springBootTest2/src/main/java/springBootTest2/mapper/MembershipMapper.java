package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.MemberDTO;

@Component
@Repository(value="springBootTest2.mapper.MembershipMapper")
public interface MembershipMapper {
	public Integer memberInsert(MemberDTO dto);

}
