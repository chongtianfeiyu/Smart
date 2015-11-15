package com.somnus.smart.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.service.JmsService;

@Component
public class JmsServiceImpl implements JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination incomeQueue;

    @Resource
    private Destination procotolDrawQueue;

    @Override
    public void incomeSend(TrnTransaction trnTransaction) {
        jmsTemplate.convertAndSend(incomeQueue, trnTransaction);
    }

    @Override
    public void procotolDrawSend(String batchNo) {
        jmsTemplate.convertAndSend(procotolDrawQueue, batchNo);
    }

}
