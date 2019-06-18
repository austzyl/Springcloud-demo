package com.nr.job.eureka.client1.RpcService;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * Created by yaleizhu on 2019/5/28.
 * description: RPC simple implement
 */
@Service
public class RpcServiceImpl {


    public BigDecimal getAddResult(String a, String b) throws IOException {

        String url = "http://localhost:8800/cal?a=" + a + "&b=" + b;
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpResponse response = aDefault.execute(new HttpGet(url));

        InputStream content = response.getEntity().getContent();

        String s = io.micrometer.core.instrument.util.IOUtils.toString(content);

        return new BigDecimal(s);

    }

}
