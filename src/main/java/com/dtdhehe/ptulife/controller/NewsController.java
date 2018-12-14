package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuNews;
import com.dtdhehe.ptulife.service.NewsService;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 新闻加载controller
 * date:2018-10-31
 * @author dtdhehe
 */
@RestController
@RequestMapping("/news/newsController")
public class NewsController {

    private final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @RequestMapping("/queryAllNews")
    public ResultVO queryAllNews(@RequestParam("page")Integer page,@RequestParam("size")Integer size){
        logger.info("查询所有新闻");
        ResultVO resultVO = new ResultVO();
        List<PtuNews> newsList;
        try {
            Pageable pageable = PageRequest.of(page,size);
            //分页查询新闻列表
            Page<PtuNews> ptuNews = newsService.queryAllNews(pageable);
            resultVO.setError_msg("");
            if (ptuNews.isLast()){
                resultVO.setError_msg("最后一页啦");
            }
            //获得新闻List
            newsList = ptuNews.getContent();
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
