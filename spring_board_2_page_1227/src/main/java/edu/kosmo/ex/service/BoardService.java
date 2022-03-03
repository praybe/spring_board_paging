package edu.kosmo.ex.service;

import java.util.List;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getList();
	BoardVO get(int bid);
	void register(BoardVO board);
	void registerReply(BoardVO board);
	void remove(int bid);
	void modify(BoardVO boardVO);
	void upHit(int bid);
	
	// 페이징 처리 함수 (위에랑 똑가은거기 떄문에 함수 오버로딩을 적용시켰다)
	public int getTotal();
	public List<BoardVO> getList(Criteria criteria);

	
}

// service는 root-context에서 만든다.
// Service쪽은 유저친화형으로 이름 지음
