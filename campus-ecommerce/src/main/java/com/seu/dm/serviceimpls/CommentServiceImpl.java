package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Comment;
import com.seu.dm.mappers.CommentMapper;
import com.seu.dm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public Comment findComment(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }
}
