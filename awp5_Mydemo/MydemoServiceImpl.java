package ibp.ioc.service.mydemo.impl;

import java.util.List;
import java.util.Map;

import ibp.core.util.StringUtils;
import ibp.core.web.runtime.LoginManager;
import ibp.dto.mydemo.MydemoDTO;
import ibp.dto.question.T01_questionDTO;
import ibp.ioc.dao.mydemo.MydemoDAO;
import ibp.ioc.service.core.impl.BaseServiceImpl;
import ibp.ioc.service.mydemo.MydemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MydemoServiceImpl extends BaseServiceImpl implements MydemoService{
	
	@Autowired
	private MydemoDAO mydemoDAO;

	@Override
	//s->'a'->'z'
	public List<MydemoDTO> getMydemoList(MydemoDTO mydemoDTO) {
		// TODO Auto-generated method stub
		List<MydemoDTO> list = mydemoDAO.getMydemoList(mydemoDTO);		
		return list;
	}

	
	
	@Override
	public List<MydemoDTO> getMydemoListByFlag(MydemoDTO mydemoDTO) {
		// TODO Auto-generated method stub
		List<MydemoDTO> list = mydemoDAO.getMydemoListByFlag(mydemoDTO);
		return list;
	}

	@Override
	public void insertMydemo(MydemoDTO mydemoDTO) {
		// TODO Auto-generated method stub

		mydemoDAO.insertMydemo(mydemoDTO);
		
	}
	

	@Override
	public void modifyMydemo(MydemoDTO mydemoDTO) {
		// TODO Auto-generated method stub
		mydemoDAO.modifyMydemo(mydemoDTO);
		
	}

	@Override
	public void deleteMydemoById(String id) {
		// TODO Auto-generated method stub
		mydemoDAO.deleteMydemoById(id);
	}

	
	/**
	 * 明细
	 */
	@Override
	public MydemoDTO getMydemoDisp(String id) {

		MydemoDTO mydemo = mydemoDAO
				.getMydemoDisp(id);
		
		return mydemo;
	}
	
}
