package com.machich.jpa.example.service;


import com.machich.jpa.example.model.DBFile;
import com.machich.jpa.example.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

        return dbFileRepository.save(dbFile);

    }

    public Optional<DBFile> getFile(String fileId) {
        return dbFileRepository.findById(fileId);
    }
}