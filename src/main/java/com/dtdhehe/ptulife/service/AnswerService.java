package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.PtuAnswer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Page<PtuAnswer> queryAllAnswer(Pageable pageable);

    /**
     * 根据id查询问答
     * @param answerId
     * @return
     */
    PtuAnswer queryAnswerById(String answerId);

}
