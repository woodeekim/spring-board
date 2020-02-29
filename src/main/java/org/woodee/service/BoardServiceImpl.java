package org.woodee.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.woodee.domain.BoardVO;
import org.woodee.domain.Criteria;
import org.woodee.mapper.BoardMapper;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info(board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        //BoardVO board = mapper.read(bno); 한줄로 처리
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify....." + board);
        return mapper.update(board)==1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove....." + bno);
        return mapper.delete(bno)==1;
    }


    /*@Override
    public List<BoardVO> getList() {
        log.info("getList.......");
        return mapper.getList();
    }
*/
    @Override
    public List<BoardVO> getList(Criteria cri) {
        log.info("get List with criteria: " + cri);
        return mapper.getListWithPaging(cri);
    }
}
