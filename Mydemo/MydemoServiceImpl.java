package ibp.ioc.service.mydemo.impl;

import java.util.Iterator;
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
public class MydemoServiceImpl extends BaseServiceImpl implements MydemoService {

	@Autowired
	private MydemoDAO mydemoDAO;

	@Override
	// s->'a'->'z'
	public List<MydemoDTO> getMydemoList(MydemoDTO mydemoDTO) {
		// TODO Auto-generated method stub
		List<MydemoDTO> list = mydemoDAO.getMydemoList(mydemoDTO);
		if (list.size() > 0) {
			Map<String, String> flagMap = getCacheDict("AWP11002");
			Map<String, String> entrykeyMap = getCacheSqL("t01_qentry");
			Iterator<MydemoDTO> it = list.iterator();
			while (it.hasNext()) {
				MydemoDTO dto = it.next();
				dto.setFlag_disp(StringUtils.trimToNull(flagMap.get(dto
						.getFlag())));
				dto.setUsername_disp(StringUtils.trimToNull(entrykeyMap.get(dto
						.getUsername())));
			}

		}
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

		MydemoDTO mydemoDTO = mydemoDAO.getMydemoDisp(id);
		Map<String, String> flagMap = getCacheDict("AWP11002");
		Map<String, String> entrykeyMap = getCacheSqL("t01_qentry");
		mydemoDTO.setFlag_disp(StringUtils.trimToNull(flagMap.get(mydemoDTO
				.getFlag())));
		mydemoDTO.setUsername_disp(StringUtils.trimToNull(entrykeyMap.get(mydemoDTO
				.getUsername())));
		
		return mydemoDTO;
	}

}
