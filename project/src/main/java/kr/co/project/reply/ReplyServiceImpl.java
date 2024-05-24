package kr.co.project.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;

	@Override
	public int insert(ReplyVO vo) {
		int r = mapper.insert(vo);
		if (r > 0)
			mapper.updateGno(vo.getNo());
		return r;
	}

	@Override
	public int reply(ReplyVO vo) {
		mapper.updateOno(vo);
		vo.setOno(vo.getOno() + 1);
		vo.setNested(vo.getNested() + 1);
		return mapper.insert(vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int delete(int no) {
		return mapper.delete(no);
	}

	@Override
	public Map<String, Object> list(ReplyVO vo) {
		// 총 개수
		int total = mapper.count(vo);

		// 총 페이지 수
		int totalPage = total / 10;
		if (total % 10 > 0)
			totalPage++;

		// 목록
		List<ReplyVO> list = mapper.list(vo);

		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("totalPage", totalPage);
		map.put("list", list);

		int endPage = (int) (Math.ceil(vo.getPage() / 10.0) * 10);
		int startPage = endPage - 9;
		if(endPage > totalPage) { //endPage가 totalPage보다 크면 안됨
			endPage = totalPage;
		}
		
		boolean isPrev = startPage > 1; //이전 페이지가 있는 경우
		boolean isNext = endPage < totalPage;
		
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		map.put("isPrev", isPrev);
		map.put("isNext", isNext);
		
		return map;
	}

	@Override
	public ReplyVO detail(ReplyVO vo, boolean isUpdate) {
		if (isUpdate)
			mapper.increaseReadcnt(vo.getNo());
		return mapper.detail(vo);
	}

}
