package com.seu.dm.services;

import com.seu.dm.entities.Comment;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface CommentService {
    int addComment(Comment comment);

    int deleteComment(Integer id);

    int updateComment(Comment comment);

    Comment findComment(Integer id);
}
