package com.zcyfover.spring.service;

import java.util.List;

/**
 * @author zcy-fover
 * @description TODO
 * @date 2019-05-26 15:51
 */
public interface IBlogService {

    List<Blog> getList();

    void deleteBlog(Long id);

}
