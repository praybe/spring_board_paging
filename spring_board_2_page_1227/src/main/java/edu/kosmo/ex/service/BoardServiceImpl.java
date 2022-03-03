package edu.kosmo.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.ex.mapper.BoardMapper;
import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	//생성자
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList(){
		
		//로그로 하면 시간도 뿌려줌
		//sysout은 부하가 좀 걸림
		log.info("getList() ..");
		
		return boardMapper.getList();
		
	}
	
	
	//@Tran
	@Override
	public BoardVO get(int bid){
		log.info("get() ..");
		
		//반드시 컨트롤러가 아니라 서비스단에서 불러와야 함.
		upHit(bid); //조회수
		
		return boardMapper.read(bid);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register() ..");
		boardMapper.insert(board);
		
	}

	
	//@Transactional //트랜잭션 추가 주의 ! ! ! (관련 라이브러리 다운받아야 굴러감)
	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply() ..");
		
		//updateShape 구현
		boardMapper.updateShape(board); // 업데이트 성공
		//insertReply 구현
		boardMapper.insertReply(board); /// 여기서 에러가 나면 ..oTL..
		
		// 댓글을 달려면 위 두 개가 다 성공되어야 댓글이 달림
		// 밑에서 에러나면 위에거 롤백(원복) 시켜야 함.. ㄹㅇ 황당
		// 예전에는 try catch로 방어 함
		// 이제는 @Tran웅앵으로 하면 됨
		
		
	}
	

	@Override
	public void remove(int bid) {
		log.info("remove() ..");
		boardMapper.delete(bid);
	}

	
	@Override
	public void modify(BoardVO boardVO) {
		log.info("modify() ..");
		boardMapper.update(boardVO);
	}

	@Override
	public void upHit(int bid) {
		log.info("upHit() ..");
		boardMapper.updateHit(bid);
		
	}


	
	
	
	
	
	//페이징
	@Override
	public int getTotal() {
		log.info("getTotal() ..");
		return boardMapper.getTotalCount();
	}

	//페이징
	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList(Criteria) ..");
		return boardMapper.getListWithPaging(criteria); //BoardMapper에서의 명칭 주의 
	}
	


}
