package ibp.ioc.controller.mydemo;

import ibp.core.annotation.Paging;
import ibp.core.model.OprMessage;
import ibp.core.model.PageInfo;
import ibp.core.tools.MyBatisPageHelper;
import ibp.dto.mydemo.MydemoDTO;
import ibp.dto.question.T01_questionDTO;
import ibp.ioc.controller.core.BaseController;
import ibp.ioc.service.mydemo.MydemoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mydemo")
@Controller
public class MydemoController extends BaseController{
	
	private static final Logger logger = LoggerFactory
			.getLogger(MydemoController.class);
	
	@Autowired
	private MydemoService mydemoService;
	
	
	//主页面显示
	@RequestMapping(value = "/queryMydemoListView.do")
	public String queryMydemoListView(ModelMap modelMap) {

		return "mydemo/mydemo_list";
	}
	
	
	//主页面内容
	
	@RequestMapping(value = "/queryMydemoList.ajax")
	@Paging
	@ResponseBody
	public PageInfo queryMydemoList(MydemoDTO mydemoDTO) {
		PageInfo pageInfo = null;

		try {
			
			List<MydemoDTO> list = mydemoService.getMydemoList(mydemoDTO);
			pageInfo = MyBatisPageHelper.getPageInfo(list);
			
		} catch (Exception e) {
			logger.error("查询失败！", e);
		}

		return pageInfo;
	}
	

	
	

	/**
	 * 跳转到问题管理添加页面
	 * 
	 * @param modelMap
	 * @return
	 */
	
	@RequestMapping(value = "/insertMydemoView.do")
	public String insertT01_questionView(ModelMap modelMap) {

		return "mydemo/mydemo_add";
	}
	
	
	
	
	/**
	 * 添加保存动作
	 * 
	 * @param MydemoDTO
	 * @return
	 */
	@RequestMapping(value = "/insertMydemoSave.ajax")
	@ResponseBody

	public OprMessage insertMydemo(MydemoDTO mydemoDTO) {
		OprMessage oprMessage = new OprMessage("1", "保存成功!");

		try {

			mydemoService.insertMydemo(mydemoDTO);
			// 设置附件的业务主键
			oprMessage.setBusinesskey("CMPQUESTION"
					+ mydemoDTO.getId());
		} catch (Exception e) {
			logger.error("保存失败！", e);
			oprMessage = new OprMessage("0", "保存失败!" + e.getMessage());

		}

		return oprMessage;
	}
	

	
	
	
	
	/**
	 * 跳转到问题管理修改页面
	 * 
	 * @param modelMap
	 * @return
	 */
	
	@RequestMapping(value = "/modifyMydemoView.do")
	public String modifyMydemoView(ModelMap modelMap, MydemoDTO mydemoDTO) {

		String id = mydemoDTO.getId();
		mydemoDTO = mydemoService.getMydemoDisp(id);
		modelMap.put("mydemoDTO", mydemoDTO);
		modelMap.put("businesskey",
				"CMPQUESTION" + mydemoDTO.getId());
		
		return "mydemo/mydemo_modify";
	}

	
	/**
	 * 修改保存动作
	 * 
	 * @param MydemoDTO
	 * @return
	 */
	
	@RequestMapping(value = "/modifyMydemoDo.ajax")
	@ResponseBody
	public OprMessage modifyMydemoDo(MydemoDTO mydemoDTO) {
		OprMessage oprMessage = new OprMessage("1", "保存成功!");

		try {

			mydemoService.modifyMydemo(mydemoDTO);
			// 设置附件的业务主键
			oprMessage.setBusinesskey("CMPQUESTION"
					+ mydemoDTO.getId());

		} catch (Exception e) {
			logger.error("保存失败！", e);
			oprMessage = new OprMessage("0", "保存失败!" + e.getMessage());

		}

		return oprMessage;
	}

	
	
	
	
	/**
	 * 删除
	 * 
	 * @param MydemoDTO
	 * @return
	 */
	
	@RequestMapping(value = "/deleteMydemo.ajax")
	@ResponseBody
	public OprMessage deleteMydemo(MydemoDTO mydemoDTO) {
		OprMessage oprMessage = new OprMessage("1", "删除成功!");

		try {

			mydemoService.deleteMydemoById(mydemoDTO.getId());

		} catch (Exception e) {
			logger.error("删除失败！", e);
			oprMessage = new OprMessage("0", "删除失败!" + e.getMessage());

		}

		return oprMessage;
	}
	
	
	/**
	 * 多条删除
	 * 
	 * @param MydemoDTO
	 * @return
	 */
	@RequestMapping(value = "/deleteAllMydemo.ajax")
	@ResponseBody
	public OprMessage deleteAllMydemo(MydemoDTO mydemoDTO) {
		OprMessage oprMessage = new OprMessage("1", "删除成功!");

		try {

			String[] questionKeys = mydemoDTO.getSelectedQuestionKey();
			for (int i = 0; i < questionKeys.length; i++) {
				mydemoDTO.setId(questionKeys[i]);
				mydemoService.deleteMydemoById(mydemoDTO.getId());
			}

		} catch (Exception e) {
			logger.error("删除失败！", e);
			oprMessage = new OprMessage("0", "删除失败!" + e.getMessage());

		}

		return oprMessage;
	}

}
