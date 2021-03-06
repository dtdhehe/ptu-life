package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.PtuAnswer;
import com.dtdhehe.ptulife.vo.AnswerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Create By Xie_东
 * on 2019/2/25 15:23
 */
public interface AnswerService {

    /**
     * 保存问答
     * @param ptuAnswer
     * @return
     */
    PtuAnswer save(PtuAnswer ptuAnswer);

    /**
     * 查询所有问答
     * @param pageable
     * @return
     */
    Page<AnswerDto> queryAllAnswerWithHead(Pageable pageable);

    /**
     * 查询全部问答
     * @return
     */
    List<PtuAnswer> queryAllAnswer();

    /**
     * 根据id查询问答
     * @param answerId
     * @return
     */
    PtuAnswer queryAnswerById(String answerId);

    /**
     * 根据用户id查询全部问答
     * @param userId
     * @param answerTitle
     * @param pageable
     * @return
     */
    Page<PtuAnswer> queryAnswerByUserId(String userId,String answerTitle,Pageable pageable);

    /**
     * 根据问答id删除问答
     * @param answerId
     */
    void delAnswerById(String answerId);

}
