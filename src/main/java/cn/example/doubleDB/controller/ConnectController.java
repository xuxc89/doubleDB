package cn.example.doubleDB.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class ConnectController {

	@Test
	/**
	 * 发送成功 不知道如何取出返回值
	 * @author xxc
	 * @since 2017年8月3日 下午3:03:34
	 * ConnectController.java
	 * TODO
	 */
	public void runConnect() throws IOException  {
		HttpClient client  = HttpClients.custom().build();
		HttpGet doGet = new HttpGet("http://127.0.0.1:10086/cms/news/name?name=tom");
		HttpResponse req = null;
		try {
			req = client.execute(doGet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity entity = req.getEntity();
		
		System.out.println(req.getStatusLine());
		System.out.println(entity);
		String en = EntityUtils.toString(entity);
		System.out.println(en);
		System.out.println(entity.getContentLength());
		InputStream is = entity.getContent();
//		is.
		//TODO 仿照toString方法取出返回信息
		Reader reader = new InputStreamReader(is, "UTF-8");
		long le = entity.getContentLength();
		if (le < 0) {
			le = 4096;
        }
        CharArrayBuffer buffer = new CharArrayBuffer(Integer.valueOf(Long.toString(le)));
        char[] tmp = new char[1024];
        int l;
        try {
			while((l = reader.read(tmp)) != -1) {
			    buffer.append(tmp, 0, l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		HeaderElement[] elements = entity.getContentType().getElements();
		System.out.println(elements);
		
		//关闭input流
		EntityUtils.consume(entity);
	}
}
