package cn.acey.mvc2cleanarch.domain.note;


import cn.acey.mvc2cleanarch.domain.exception.BusinessException;

public interface NoteRepository{
    Note save(Note note);

    Note findById(Long id) throws BusinessException;
}
