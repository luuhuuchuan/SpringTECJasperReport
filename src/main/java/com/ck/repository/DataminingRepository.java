package com.ck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ck.domain.DataMining;

@Repository
public interface DataminingRepository extends JpaRepository<DataMining, Integer> {

	@Query(value = "select list.JANコード, list.商品名, list.件数 from\r\n" + 
			"(select main.Jan_code as 'JANコード', main.F_Timestamp,\r\n" + 
			" goods.Goods_name as '商品名', sum(case area.CommonArea when 'Shelf' then 1 else 0 end) as '件数'\r\n" + 
			"from tbl_DataMining main\r\n" + 
			"inner join AreaMst area on main.CompanyNO = area.CompanyNO and main.StoreNo = area.StoreNo and main.ReaderNo = area.ReaderNo\r\n" + 
			"inner join GoodsMst goods on main.Jan_code = goods.Jan_code\r\n" + 
			"where main.F_Timestamp is not null\r\n" + 
			"group by main.Jan_code, goods.Goods_name, main.F_Timestamp) list\r\n" + 
			"order by list.F_Timestamp desc", nativeQuery = true)
	List<Object[]> getGoodsInShelf();
//	List<DataMining> getGoodsInShelf();
}
