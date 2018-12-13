package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuNews;
import com.dtdhehe.ptulife.service.impl.NewsServiceImpl;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户访问首页controller
 * crate By:dtdhehe
 * date:2018-10-31
 */
@RestController
@RequestMapping("/news/newsController")
public class NewsController {

    private final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping("/queryAllNews")
    public ResultVO queryAllNews(){
        logger.info("查询所有新闻");
        ResultVO resultVO = new ResultVO();
        List<PtuNews> newsList;
        try {
            newsList = newsService.queryAllNews();
            resultVO.setStatus("0");
            resultVO.setObject(newsList);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            //新闻列表  9952
            resultVO.setError_code("9952");
            resultVO.setError_msg(e.getMessage());
        }
        return resultVO;
    }
}
