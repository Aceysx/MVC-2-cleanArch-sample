package cn.acey.mvc2cleanarch.domain.context.note;


import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;

public interface NoteRepository{
    Note save(Note note);

    Note findById(Long id) throws BusinessException;
}
