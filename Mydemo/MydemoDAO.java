package ibp.ioc.dao.mydemo;

import ibp.dto.mydemo.MydemoDTO;
import ibp.dto.question.T01_questionDTO;

import java.util.List;

public interface MydemoDAO {

	List<MydemoDTO> getMydemoList(MydemoDTO mydemoDTO);
	
	List<MydemoDTO> getMydemoListByFlag(MydemoDTO mydemoDTO);
	
	void insertMydemo(MydemoDTO mydemoDTO);
	
	void deleteMydemoById(String id);
	
	void modifyMydemo(MydemoDTO mydemoDTO);

	MydemoDTO getMydemoDisp(String id);
	
}
