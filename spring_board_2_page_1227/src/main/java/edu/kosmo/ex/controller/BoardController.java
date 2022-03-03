package edu.kosmo.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.ex.page.Criteria;
import edu.kosmo.ex.page.PageVO;
import edu.kosmo.ex.service.BoardService;
import edu.kosmo.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@AllArgsConstructor //이건 습관적으로 넣음
@Controller
public class BoardController {
	
	
	@Inject
	private BoardService boardService;
	
	@GetMapping("/list") //주소: http://localhost:8282/ex/list
	public String list(Model model) {
		log.info("list() ..");
		  
		model.addAttribute("boardList", boardService.getList());
		
		return "/board/list";
	}
	
	
	////주소: http://localhost:8282/ex/content_view?bid=41
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO,Model model) { //BoardVO boardVO는 커맨드객체
		
		log.info("content_view() ..");
		log.info("BoardVO" + boardVO);
		
		int bid = boardVO.getBid();
		
		model.addAttribute("content_view", boardService.get(bid));
		
		return "/board/content_view";
	} //우선 만들고 mapper, impl 수정하러 ㄱㄱ 
	
	
	

	@GetMapping("/write_view")
	public String write_view() {
		//view페이지 보여주는거라 model도 필요 없음
		log.info("write_view() ..");

		return "/board/write_view";
	}  
	
	//post방식으로 넘어가고 있음
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write() ..");
		
		boardService.register(boardVO);

		return "redirect:list";
	}  
	
	
	
	
	
	//수정, 삭제, 업뎃은 알아서 하기 ㅋㅋㅋ
	
	
	@GetMapping("/reply_view") //@PostMapping으로 하면 오류뜸
	public String reply_view(BoardVO boardVO,Model model) { 
		log.info("reply_view() ..");
		model.addAttribute("reply_view", boardService.get(boardVO.getBid()));
		
		return "/board/reply_view";
	} 
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO,Model model) { 
		log.info("reply() ..");
		boardService.registerReply(boardVO);

		return "redirect:list";
	} 
	
	
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO,Model model) { 
		log.info("delete() ..");
		boardService.remove(boardVO.getBid());
		return "redirect:list";
	} 
	
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO,Model model) { 
		log.info("modify() ..");
		boardService.modify(boardVO);
		
		return "redirect:list"; //수정한 다음 리스트로 오세요
	} 
	
	
	
	
	
	
	//페이징
	@GetMapping("/list2") //주소: http://localhost:8282/ex/list2
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("Criteria " + cri);
		  
		model.addAttribute("boardList", boardService.getList(cri));
		int total = boardService.getTotal();
		
		log.info("total " + total);
		
		model.addAttribute("pageMaker", new PageVO(cri, total)); //pageMaker라는 객체 생성
		
		
		return "/board/list2";
	}
	
	
	

}
