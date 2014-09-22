package com.mdnet.travel.core.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.ReqMessage;
@Repository(ReqMessageDAO.DAO_NAME)
@Scope("prototype")
public class ReqMessageDAOImpl extends BasicDAOImpl<ReqMessage> implements ReqMessageDAO{

}
