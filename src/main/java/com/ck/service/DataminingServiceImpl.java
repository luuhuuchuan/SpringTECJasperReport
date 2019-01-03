package com.ck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dto.ShelfDto;
import com.ck.repository.DataminingRepository;

@Service
public class DataminingServiceImpl implements DataminingService {

	@Autowired
	private DataminingRepository dataminingRepository;

	@Override
	public List<ShelfDto> getGoodsInShelf() {
		ShelfDto shelfDto;
		String jan_code;
		String goods_name;
		int countShelf;
		List<ShelfDto> list = new ArrayList<>();
		List<Object[]> result = dataminingRepository.getGoodsInShelf();

		for (Object[] b : result) {
			shelfDto = new ShelfDto();
			jan_code = (String) b[0];
			goods_name = (String) b[1];
			countShelf = (int) b[2];
			shelfDto.setJan_code(jan_code);
			shelfDto.setGoods_name(goods_name);
			shelfDto.setCountShelf(countShelf);
			list.add(shelfDto);
		}
		return list;
//		return dataminingRepository.getGoodsInShelf();
	}
}
