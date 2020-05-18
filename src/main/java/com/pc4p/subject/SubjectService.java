package com.pc4p.subject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAllSubject() {
        return subjectRepository.findAll();
    }

    public Subject findById(int id) {
        return subjectRepository.findById(id).get();
    }
}
