package com.gura.spring04.file.dao;

import java.util.List;

import com.gura.spring04.file.dto.FileDto;

public interface FileDao {
	   public void insert(FileDto dto);
	   public FileDto getData(int num);
	   public void delete(int num);
	   public List<FileDto> getList(FileDto dto); //페이징처리와 검색키워드를 위해 dto를 보냄
	   public int getCount(FileDto dto); //검색 키워드를 위해 dto 보냄
	}