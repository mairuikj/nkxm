package com.nkp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nkp.config.utils.DataPackJSON;
import com.nkp.config.utils.NewDateTime;
import com.nkp.dao.AuthorMapper;
import com.nkp.dao.NewsMapper;
import com.nkp.dao.NewsTypeMapper;
import com.nkp.dao.ViewNumberMapper;
import com.nkp.pojo.News;
import com.nkp.pojo.UserInfo;
import com.nkp.pojo.ViewNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsTypeMapper newsTypeMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private ViewNumberMapper viewNumberMapper;



    public DataPackJSON add(HttpServletRequest request, News news) throws ParseException {
        news.setCreattime(NewDateTime.getDateTime("yyyy-MM-dd :hh:mm:ss"));
        news.setRemarks("0");//默认0代表新闻在前台显示
        int res=newsMapper.insertSelective(news);
        DataPackJSON dataPackJSON=new DataPackJSON();
        if(res==1){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }
    public DataPackJSON del(HttpServletRequest request, String ids){
        int res=0;
        String[] id=ids.split(",");
        for(String s:id){
            res=+newsMapper.deleteByPrimaryKey(Integer.valueOf(s));
        }

        DataPackJSON dataPackJSON=new DataPackJSON();
        if(res!=0){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }

    public DataPackJSON up(HttpServletRequest request, News news){
        int res=newsMapper.updateByPrimaryKeySelective(news);
        DataPackJSON dataPackJSON=new DataPackJSON();
        if(res==1){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;
    }

    public DataPackJSON selById(HttpServletRequest request,int id){
        News news=newsMapper.selectByPrimaryKey(id);
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        HttpSession session = request.getSession();
        map.put("news",news);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        return dataPackJSON;
    }
    public DataPackJSON selAll(HttpServletRequest request,Integer id){
        List list=newsMapper.selNewsAndNewsType(id);
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        HttpSession session = request.getSession();
        map.put("list",list);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        dataPackJSON.setNumber(list.size());
        return dataPackJSON;
    }

    public DataPackJSON pagingSel(HttpServletRequest request, int pageNum, int pageSize,Integer id) {
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        HttpSession session = request.getSession();

        PageHelper.startPage(pageNum,pageSize);
       // List list=newsMapper.selNewsAndNewsType(id);//关联了newstype
        List list=newsMapper.selAll();

        //得到分页的结果对象
        PageInfo<News> pageInfo = new PageInfo<>(list);
        //得到分页中的person条目对象(分页后的list)
        List pageList = pageInfo.getList();

        dataPackJSON.setNumber((int)pageInfo.getTotal());
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");

        map.put("pageList",pageList);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        return dataPackJSON;

    }

    public DataPackJSON getTypeAndAuthor(HttpServletRequest request){
        List list=newsTypeMapper.selAll();
        List list1=authorMapper.selAll();
        Map map=new HashMap();
        map.put("newsType",list);
        map.put("author",list1);
        DataPackJSON dataPackJSON=new DataPackJSON();
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        dataPackJSON.setMap(map);
        return dataPackJSON;




    }
    //新闻在公众号号上隐藏
    public DataPackJSON hide(HttpServletRequest request, String ids) {
        DataPackJSON dataPackJSON=new DataPackJSON();
        int res=0;
        String[] id=ids.split(",");
        for(String i:id){
            res=+newsMapper.hide(Integer.valueOf(i));
        }
        if(res!=0){
            dataPackJSON.setFlag(0);
            dataPackJSON.setMsg("SUCCESS");
            return dataPackJSON;
        }
        dataPackJSON.setFlag(1);
        dataPackJSON.setMsg("ERROR");
        return dataPackJSON;

    }
    //公众号访问新闻详情
    public DataPackJSON details(HttpServletRequest request, int id) {
        ViewNumber viewNumber=viewNumberMapper.selectByNewsId(id);
        if(viewNumber==null){
            ViewNumber viewNumberTemp=new ViewNumber();
            viewNumberTemp.setNewsid(id);
            viewNumberTemp.setNumber(1);
            viewNumberMapper.insertSelective(viewNumberTemp);
        }else {
            viewNumberMapper.newsNumberAdd(id);
        }
        News news=newsMapper.selectByPrimaryKey(id);
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        HttpSession session = request.getSession();
        map.put("news",news);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        return dataPackJSON;
    }
    //PC仪表盘展示最热的10条新闻
    public DataPackJSON number(HttpServletRequest request) {

        Map map=new HashMap();
        String str="";
        DataPackJSON dataPackJSON=new DataPackJSON();
        List<ViewNumber> list=viewNumberMapper.hb();
        for(ViewNumber viewNumber:list){
            str+=viewNumber.getNewsid()+",";
        }
        str=str.substring(0,str.length()-1);
        List<News> list1=newsMapper.hb(str);
        map.put("number",list);
        map.put("news",list1);
        dataPackJSON.setMap(map);
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");
        return dataPackJSON;
    }
        // 公众号获得新闻列表
    public DataPackJSON byType(HttpServletRequest request, int pageNum, int pageSize, Integer newsType) {
        DataPackJSON dataPackJSON=new DataPackJSON();
        Map map=new HashMap();
        HttpSession session = request.getSession();

        PageHelper.startPage(pageNum,pageSize);
        // List list=newsMapper.selNewsAndNewsType(id);//关联了newstype
        List list=newsMapper.byType(newsType);

        //得到分页的结果对象
        PageInfo<News> pageInfo = new PageInfo<>(list);
        //得到分页中的person条目对象(分页后的list)
        List pageList = pageInfo.getList();

        dataPackJSON.setNumber((int)pageInfo.getTotal());
        dataPackJSON.setFlag(0);
        dataPackJSON.setMsg("SUCCESS");

        map.put("pageList",pageList);
        map.put("session_user",(UserInfo) session.getAttribute("session_user"));
        dataPackJSON.setMap(map);
        return dataPackJSON;
    }
}
