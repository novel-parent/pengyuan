package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.bean.UserInfoWagesNodes;
import com.pengyuan.backstage.bean.WagesNode;
import com.pengyuan.backstage.mapper.UserMapper;
import com.pengyuan.backstage.mapper.WagesNodeMapper;
import com.pengyuan.backstage.service.WagesNodeService;
import com.pengyuan.backstage.util.DateUtil;
import com.pengyuan.backstage.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/25 - 0:11
 */
@Service
public class WagesNodeServiceImpl implements WagesNodeService {

    @Autowired
    private WagesNodeMapper wagesNodeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoWagesNodes getWagesNode(int page, int pageSize, Long startTime, Long endTime, String procedureNode, String username) {

        UserInfoWagesNodes userInfoWagesNodes = null ;

        int index = (page-1)*pageSize;

        Long uid = null ;

        if(username!=null){

            User user = userMapper.selUserByName(username);

            if( user!=null ){

                uid = user.getUid();
            }
        }
        userInfoWagesNodes = new UserInfoWagesNodes();

        List<WagesNode> wagesNodes = wagesNodeMapper.selWagesNode(index, pageSize, startTime, endTime, procedureNode, uid);
        int size = wagesNodeMapper.selWagesNodeNumber(startTime, endTime, procedureNode, uid);
        userInfoWagesNodes.setWagesNodes(wagesNodes);
        userInfoWagesNodes.setPageNumber(size%pageSize==0?size/pageSize:(size/pageSize +1));
        long sum = 0;

        int length = wagesNodes.size();
        userInfoWagesNodes.setSize(length);

        for( int i =0 ;i<length;i++){
            WagesNode wagesNode = wagesNodes.get(i);
            long money = Long.parseLong(wagesNode.getMoney());

            sum+=money;

            wagesNode.setMoney(MoneyUtil.formatMoney(money));
        }
        userInfoWagesNodes.setMoney(MoneyUtil.formatMoney(sum));
        return userInfoWagesNodes;
    }

	@Override
	public WagesNode putIntoWage(WagesNode wn,Long price) {
		
		 int number = wn.getNumber();
		 
		 long pid = wn.getPid();
		 
		 String procedureNode = wn.getProcedureNode();
		 
		 long times = Long.valueOf(DateUtil.getMonthAndDay());
		 
		 long uid = wn.getUid();
		 
		 long money = price * number;
		 
		 wn.setMoney(""+money);
		 
		
			
			//插入之前判断是否有重复提交
			 List<WagesNode> wgn=wagesNodeMapper.selectWageNode(uid,pid,procedureNode,price,times);
			 
			 if(wgn.isEmpty()) {
				 wagesNodeMapper.putIntoWage(uid,pid,procedureNode,price,number,times,money);
				 
				 return wagesNodeMapper.selectWageNode(uid,pid,procedureNode,price,times).get(0);
			 }else {
				 throw new RuntimeException("该工序已添加了该用户");
				 
			 }
		 
		
		
		
	}

	@Override
	public int updateWagesNode(Long wid, Long uid, Integer number,Long price) {
		
		String money=price*number+"";
		
		return wagesNodeMapper.updateWagesNode(wid,uid,number,money);
	}

	@Override
	public int deleteFromWagesNode(Long wid) {
		
		return wagesNodeMapper.deleteWagesNodeByWid(wid);
	}

	@Override
	public UserInfoWagesNodes getWagesNode(int page, int pageSize, Long startTime, Long endTime, Long pid,
			String username) {
		
		return null;
	}


}
