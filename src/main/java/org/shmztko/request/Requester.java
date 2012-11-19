package org.shmztko.request;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Requester {

	private DefaultHttpClient client;

	public Requester() {
		client = new DefaultHttpClient();
	}

	public String get(String url) throws RequestException {
		return getResponseBody(new HttpGet(url));
	}

	private String getResponseBody(HttpUriRequest method) throws RequestException {
		HttpResponse response = null;
		try {
			response = client.execute(method);
			return EntityUtils.toString(response.getEntity());

		} catch (ClientProtocolException e) {
			throw new RequestException(e);

		} catch (IOException e) {
			throw new RequestException(e);

		} finally {
			HttpClientUtils.closeQuietly(response);
		}
	}

	public void setProxy(String hostname, int port) {
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(hostname, port));
	}
}
