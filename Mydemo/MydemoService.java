package ibp.ioc.service.mydemo;

import ibp.dto.mydemo.MydemoDTO;
import ibp.dto.question.T01_questionDTO;
import ibp.ioc.service.core.BaseService;

import java.util.List;

public interface MydemoService extends BaseService{
	
	List<MydemoDTO> getMydemoList(MydemoDTO mydemoDTO);
	

	void insertMydemo(MydemoDTO mydemoDTO);

	void modifyMydemo(MydemoDTO mydemoDTO);

	void deleteMydemoById(String id);


	MydemoDTO getMydemoDisp(String id);
	
	
	
}
