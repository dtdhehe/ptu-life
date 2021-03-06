package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.PtuAnswer;
import com.dtdhehe.ptulife.vo.AnswerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Create By Xie_东
 * on 2019/2/25 15:22
 */
public interface PtuAnswerRepository extends JpaRepository<PtuAnswer,String> {

    /**
     * 根据用户id查询问答
     * @param userId
     * @param answerTitle
     * @param pageable
     * @return
     */
    @Query(value = "select t from PtuAnswer t where t.userId=?1 and t.answerTitle like %?2%")
    Page<PtuAnswer> findByUserId(String userId,String answerTitle, Pageable pageable);

    /**
     * 查询所有问答带头像
     * @param pageable
     * @return
     */
    @Query(value = "select new com.dtdhehe.ptulife.vo.AnswerDto(t,u.headImg) from PtuAnswer t left join PtuUser u on t.userId=u.userId")
    Page<AnswerDto> queryAllAnswerWithHead(Pageable pageable);

}
