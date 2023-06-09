package com.mem.model;

import com.admin.AdminJDBCDAO;
import com.admin.AdminJNDIDAO;
import com.mem.dao.MemDAO_interface;
import com.mem.model.MemDAO;
import com.mem.model.MemVO;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class MemService {
//	private MemDAO_interface dao = (MemDAO_interface) new MemDAO();
	
	MemDAO_interface dao;
	
	public MemService() {
//		dao = new MemJDBCDAO();
		dao = new MemJNDIDAO();
		
	};

	public MemVO addMem(MemVO memVO) {			
		memVO.setMemStatus(1);
		memVO.setPostSuspended(0);
		memVO.setPostReportedNum(0);
		this.dao.insert(memVO);
		return memVO;
	}

	public MemVO updateMem(MemVO tempVO) {
		this.dao.update(tempVO);
		return tempVO;
	}

	public void deleteMem(Integer memId) {
		this.dao.delete(memId);
	}

	public MemVO getOneMem(Integer memId) {
		return this.dao.findByPrimaryKey(memId);
	}

	public List<MemVO> getAll() {
		return this.dao.getAll();
	}
	
	public MemVO login(String memEmail, String memPsd) {
		if (!checkValue(memEmail)||!checkValue(memPsd)) {
			return null;
		}		
		return dao.login(memEmail, memPsd);
	}
	
	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
				System.out.println(value);
				return false;
		}
		return true;
	}
	
	
}
