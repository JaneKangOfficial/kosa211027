package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.BoardDTO2;

@Component
@Repository("springBootTest2.mapper.BoardMapper2")
public interface BoardMapper2 {

	public Integer boardInsert(BoardDTO2 dto);
	public List<BoardDTO2> selectAll();
	public BoardDTO2 selectOne(Integer boardNum);
	public Integer boardDel(Integer boardNum);
	public Integer boardUpdate(BoardDTO2 dto);
}
