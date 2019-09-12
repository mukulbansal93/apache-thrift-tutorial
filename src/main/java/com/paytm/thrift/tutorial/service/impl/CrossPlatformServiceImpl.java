package com.paytm.thrift.tutorial.service.impl;

import com.paytm.thrift.tutorial.service.CrossPlatformResource;
import com.paytm.thrift.tutorial.service.CrossPlatformService;
import com.paytm.thrift.tutorial.service.InvalidOperationException;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {
    @Override
    public CrossPlatformResource get(int id)
            throws InvalidOperationException, TException {
        return new CrossPlatformResource();
    }

    @Override
    public void save(CrossPlatformResource resource)
            throws InvalidOperationException, TException {
        //Do Something
    }

    @Override
    public List<CrossPlatformResource> getList()
            throws InvalidOperationException, TException {
        return Collections.emptyList();
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }
}
