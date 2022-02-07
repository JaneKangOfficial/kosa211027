package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;

@Component
@Repository("kosaShoppingMall.mapper.MemberMapper")
public interface MemberMapper {
	public Integer memberInsert(MemberDTO dto);
	public List<MemberDTO> selectAll();
	public MemberDTO selectOne(String memberNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDel(String memberNum);
	public String memberAutoNum();
	public Integer memberJoin(MemberDTO dto);
	public AuthInfo loginSelect(String userId);
	public MemberDTO selectOneById(String memberId);
	public Integer memberModify(MemberDTO dto);
	public Integer pwUpdate(MemberDTO dto);

}