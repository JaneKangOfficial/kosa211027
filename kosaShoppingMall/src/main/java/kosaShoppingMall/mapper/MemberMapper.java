package kosaShoppingMall.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.GoodsCartDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Component
@Repository("kosaShoppingMall.mapper.MemberMapper")
public interface MemberMapper {
	public Integer memberInsert(MemberDTO dto);
	public List<MemberDTO> selectAll(StartEndPageDTO dto);
	public MemberDTO selectOne(String memberNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDel(String memberNum);
	public String memberAutoNum();
	public Integer memberJoin(MemberDTO dto);
	public AuthInfo loginSelect(String userId);
	public MemberDTO selectOneById(String memberId);
	public Integer memberModify(MemberDTO dto);
	public Integer pwUpdate(MemberDTO dto);
	// 여러개 삭제
	// 1. 배열 이용
	public Integer memDels(String[] deletes);
	// 2. 리스트 이용
	public Integer memDels2(List<String> cs);
	// 3. map 이용
	public Integer memDels3(Map<String, Object> condition);
	
	public int memberCount();
	
	// 메일로 비밀번호 변경
	public Integer changPw(AuthInfo authInfo);
	
	// 이메일로 가입 인증
	public Integer joinOkUpdate(MemberDTO dto);
	
	// 장바구니 목록
	public List<GoodsCartDTO> cartList(String memberNum);
	// 장바구니 수량
	public Integer goodsCartQtyDown(CartDTO dto);
	// 장바구니 주문
	public List<GoodsCartDTO> goodsOrder(GoodsBuy goodsBuy);
	// 장바구니 삭제
	public Integer cartDel(CartDTO dto);
	// 장바구니 선택 삭제
	public Integer cartDels(String[] goodsNum);
	

}
