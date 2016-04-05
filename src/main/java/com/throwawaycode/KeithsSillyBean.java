package com.throwawaycode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeithsSillyBean {

    private static final Logger LOG = LoggerFactory.getLogger(KeithsSillyBean.class);

    public void makeStuffHappen() {
        LOG.info("Im making stuff happen!");
    }
}
