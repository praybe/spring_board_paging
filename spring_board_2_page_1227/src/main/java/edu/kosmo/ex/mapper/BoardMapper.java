package edu.kosmo.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Param;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//21-12-22
	//list
	List<BoardVO> getList();
	
	//content_view
	BoardVO read(int bid);
	
	//write_view
	void insert(BoardVO board); //객체를 집어 넣음
	
	
	//21-12-23
	// 삭제
	void delete(int bid);
	
	// 수정(update)
	void update(BoardVO board);
	
	//조회수
	void updateHit(int bid);

	//댓글 관련
	void updateShape(BoardVO boardVO);
	void insertReply(BoardVO boardVO);

	
	/* 복수 객체 보내려면 반드시 @Param(" ")으로 넘겨야 함
	void update(@Param("bid") int bid, 
					@Param("bcontent") String bcontent);
	
	이번엔 객체에 @Param
	void update(@Param("board") BoardVO board);
	이러면 Mapper.xml에서 #{board.bname} 이런식으로 들어감
	
	void update(@Param("board") BoardVO board,
					@Param("emp") Emp emp);
	*
	*
	*/
	
	
	
	//21-12-27
	//페이징 처리 관련
	//페이징 처리 관련
	int getTotalCount(); //전체 몇 개인가
	List<BoardVO> getListWithPaging(Criteria criteria); //괄호 안 반드시 가져와야 함


	
}

//만들고 BoardMapper.xml 가서 추가 수정 진행
// Mapper쪽은 이름들 다이렉트로 입력. 개발자 친화적으로..
