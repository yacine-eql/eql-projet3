package com.eql.service.impl;

import com.eql.model.Commentaire;
import com.eql.repository.CommentaireRepository;
import com.eql.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }


}
