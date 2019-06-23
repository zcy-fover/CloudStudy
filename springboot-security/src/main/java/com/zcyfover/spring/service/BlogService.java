package com.zcyfover.spring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zcy-fover
 * @description TODO
 * @date 2019-05-26 15:51
 */
@Service("iBlogService")
public class BlogService implements IBlogService {

    private List<Blog> blogList = new ArrayList<>();

    public BlogService() {
        blogList.add(new Blog(1L, "《Springboot》", "spring boot"));
        blogList.add(new Blog(2L, "《架构探险》", "架构"));
    }

    @Override
    public List<Blog> getList() {
        return blogList;
    }

    @Override
    public void deleteBlog(Long id) {
        Iterator iterator = blogList.iterator();
        while (iterator.hasNext()) {
            Blog blog = (Blog) iterator.next();
            if (blog.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
}
